package com.learntechfree.lftgraphql.article;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ArticleQuery implements GraphQLQueryResolver {

    private ArticleService articleService;

    public List<Article> listArticles(int count){
        return articleService.listArticles(count);
    }

    public Optional<Article> getArticle(Long id){
        return articleService.getArticle(id);
    }

}
