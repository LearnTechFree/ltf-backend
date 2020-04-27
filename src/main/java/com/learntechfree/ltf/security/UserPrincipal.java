package com.learntechfree.ltf.security;

import com.learntechfree.ltf.entity.Permission;
import com.learntechfree.ltf.entity.Role;
import com.learntechfree.ltf.entity.User;
import com.learntechfree.ltf.user.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class UserPrincipal implements  OAuth2User, UserDetails {
    @Autowired
    private RoleRepository roleRepository;

    private Long id;

    private String email;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    private Map<String, Object> attributes;

    public UserPrincipal(Long id, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(User user) {
        Collection<? extends GrantedAuthority> authorities = getAuthorities(user.getRoles());

        return new UserPrincipal(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    public static UserPrincipal create(User user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {

        return getGrantedAuthorities(getPrivileges(roles));
    }

    public static List<String> getPrivileges(Collection<Role> roles) {

        List<String> permission = new ArrayList<>();
        List<Permission> collection = new ArrayList<>();
        for (Role role : roles) {
            permission.add(role.getName().toString());
            collection.addAll(role.getPermissions());
        }

        for (Permission item : collection) {
            permission.add(item.getName().toString());
        }

        return permission;
    }

    private static List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }

        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getName() {
        return String.valueOf(id);
    }

}
