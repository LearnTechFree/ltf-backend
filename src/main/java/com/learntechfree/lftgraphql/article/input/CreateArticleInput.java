package com.learntechfree.lftgraphql.article.input;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateArticleInput {
    private String title;
    private String body;
    private String userId;
    private  String subTitle;
    private String featureImageUrl;
    private Timestamp publishedAt;
    private Timestamp scheduleAt;
}
