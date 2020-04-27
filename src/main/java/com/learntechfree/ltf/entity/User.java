package com.learntechfree.ltf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learntechfree.ltf.common.enums.AuthProvider;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Boolean isEmailVerified = false;

    @Column
    private String refreshToken;

    @Column
    private Integer refreshTokenUsed;

    @JsonIgnore
    private String password;

    @Column
    private Boolean passwordExpired;

    @Column
    private Boolean locked;

    @Column
    private String lockedReason;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    @Column
    private String providerId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
}
