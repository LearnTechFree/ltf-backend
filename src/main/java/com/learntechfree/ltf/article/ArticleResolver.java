package com.learntechfree.ltf.article;

import com.learntechfree.ltf.entity.Article;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleResolver implements GraphQLResolver<Article> {

    @Autowired
    private ArticleService articleService;

    public Article getArticle(Long id) {

        return articleService.getArticle(id);
    }
}
