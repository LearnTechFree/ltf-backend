package com.learntechfree.ltf.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

     @OneToMany(fetch = FetchType.EAGER,mappedBy = "category")
     private Set<Subject> subjects;
}
