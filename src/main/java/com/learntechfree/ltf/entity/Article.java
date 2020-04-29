package com.learntechfree.ltf.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "articles")

@Getter
@Setter
public class Article extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String title;

    @Column
    private String subTitle;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column
    private String status;

    @Column
    private String tags;

    @Column
    private String featureImageUrl;

    @Column(updatable = false, nullable = false)
    private Long createdBy;

    @Column
    private Long updatedBy;

    @Column
    private Long publishedBy;

    @Column(nullable = false)
    private String userId;

    @Column
    private Timestamp publishedAt;

    @Column
    private Timestamp scheduledAt;

    @ManyToOne()
    @JoinColumn(name = "unit_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Unit unit;


    @OneToMany(mappedBy = "article")
    private Set<ArticleRevision> articleRevisions;


}
