package com.learntechfree.ltf.security.oauth2;

import com.learntechfree.ltf.common.enums.AuthProvider;
import com.learntechfree.ltf.common.exception.OAuth2AuthenticationProcessingException;
import com.learntechfree.ltf.entity.User;
import com.learntechfree.ltf.security.UserPrincipal;
import com.learntechfree.ltf.security.oauth2.user.OAuth2UserInfo;
import com.learntechfree.ltf.security.oauth2.user.OAuth2UserInfoFactory;
import com.learntechfree.ltf.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.util.StringUtils;

import java.util.Optional;

public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            // Throwing an instance of AuthenticationException will trigger the OAuth2AuthenticationFailureHandler
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) throws Exception {
        OAuth2UserInfo oAuth2UserInfo =
                OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId()
                        , oAuth2User.getAttributes());
        if (StringUtils.isEmpty(oAuth2UserInfo.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }

        Optional<User> senderOptional = userRepository.findByEmail(oAuth2UserInfo.getEmail());
        User user;
        if (senderOptional.isPresent()) {
            user = senderOptional.get();
            if (!user.getProvider().equals(AuthProvider.get(oAuth2UserRequest.getClientRegistration().getRegistrationId()))) {
                throw new OAuth2AuthenticationProcessingException(String.format("Looks like you're signed up with %s " +
                        "account. Please use your %s account to login.", user.getProvider(), user.getProvider()));
            }
            user = updateExistingSender(user, oAuth2UserInfo);
        } else {
            user = registerNewSender(oAuth2UserRequest, oAuth2UserInfo);
        }

        return UserPrincipal.create(user, oAuth2User.getAttributes());
    }

    private User registerNewSender(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
        User user = new User();
//        Role roleUser = roleService.findByName(RoleType.ROLE_GUEST);

        user.setProvider(AuthProvider.get(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
        user.setProviderId(oAuth2UserInfo.getId());
        user.setEmail(oAuth2UserInfo.getEmail());
//        user.setRoles(new ArrayList<>(Collections.singletonList(roleUser)));
        user.setIsEmailVerified(true);

        return userRepository.save(user);
    }

    private User updateExistingSender(User existingUser, OAuth2UserInfo oAuth2UserInfo) {
        existingUser.setEmail(oAuth2UserInfo.getEmail());

        return userRepository.save(existingUser);
    }
}
