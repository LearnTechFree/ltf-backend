package com.learntechfree.ltf.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.sql.Timestamp;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Getter
@Setter
@Table(name = "articles")
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
    private List<ArticleRevision> articleRevisions;
}

