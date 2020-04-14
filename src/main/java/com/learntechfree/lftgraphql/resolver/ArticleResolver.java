package com.learntechfree.lftgraphql.resolver;

import com.learntechfree.lftgraphql.article.Article;
import com.learntechfree.lftgraphql.article.ArticleRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleResolver implements GraphQLResolver<Article> {
    private ArticleRepository articleRepository;


    public List<Article> listArticles(){
      return  articleRepository.findAll();
    }
}
