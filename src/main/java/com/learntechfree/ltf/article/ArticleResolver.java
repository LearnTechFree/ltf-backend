package com.learntechfree.ltf.article;

import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ArticleResolver implements GraphQLResolver<Article> {
    @Autowired
    private ArticleService articleService;

    public Optional<Article> getArticle(Long id){
        return articleService.getArticle(id);
    }
}
