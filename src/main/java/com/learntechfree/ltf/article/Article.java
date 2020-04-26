package com.learntechfree.ltf.article;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "articles",uniqueConstraints = {
        @UniqueConstraint(columnNames = "title")
})

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String title;

    @Column
    private String subTitle;

    @Column(nullable = false)
    private String body;

    @Column
    private String featureImageUrl;

    @Column(nullable = false)
    private String userId;

    @Column
    private Timestamp publishedAt;

    @Column
    private Timestamp scheduledAt;

    @Column
    @CreationTimestamp
    private Timestamp createdAt;


    @Column
    @UpdateTimestamp
    private Timestamp updatedAt;

}

