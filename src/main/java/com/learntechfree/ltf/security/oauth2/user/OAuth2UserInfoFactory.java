package com.learntechfree.ltf.security.oauth2.user;

import com.learntechfree.ltf.common.enums.AuthProvider;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) throws Exception {
        if(registrationId.equalsIgnoreCase(AuthProvider.GOOGLE.getProvider())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.FACEBOOK.getProvider())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.GITHUB.getProvider())) {
            return new GithubOAuth2UserInfo(attributes);
        } else {
            // FIXME: add custom exception
            throw  new Exception();
        }
    }
}
