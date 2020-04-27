package com.learntechfree.ltf.entity;

import com.learntechfree.ltf.common.enums.PermissionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private PermissionType name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "permissions")
    private Collection<Role> roles;

    public Permission(PermissionType name) {
        this.name = name;
    }
}