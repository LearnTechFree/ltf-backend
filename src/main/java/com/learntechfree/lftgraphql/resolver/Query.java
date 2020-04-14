package com.learntechfree.lftgraphql.resolver;

import com.learntechfree.lftgraphql.article.ArticleController;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    private ArticleController articleController;

    public Query(ArticleController articleController){
        System.out.println("here in query");
        this.articleController = articleController;
    }

    public Query(){
    }

    public String hello(){
        return "Hello world";
    }

}
