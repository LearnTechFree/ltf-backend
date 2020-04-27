package com.learntechfree.ltf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "articles",uniqueConstraints = {
        @UniqueConstraint(columnNames = "title")
})

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String title;

    @Column
    private String subTitle;

    @Column(nullable = false)
    private String slug;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column
    private String status;

    @Column
    private String tags;

    @Column
    private String featureImageUrl;

    // FIXME: relation
    @Column
    private Long unitId;

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

}
