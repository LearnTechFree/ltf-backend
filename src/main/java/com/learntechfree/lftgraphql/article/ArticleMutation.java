package com.learntechfree.lftgraphql.article;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.learntechfree.lftgraphql.article.input.CreateArticleInput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class ArticleMutation implements GraphQLMutationResolver {

    private  ArticleService articleService;

    @Transactional
    public Article createArticle(CreateArticleInput input){
        Article article = new Article();
        return articleService.createArticle(new Article());
    }
}
