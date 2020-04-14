package com.learntechfree.lftgraphql.article;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ArticleController {
   private ArticleService articleService;

   public ArticleController(ArticleService articleService){
       this.articleService = articleService;
   }

    public List<Article> listArticles(int count){
        return articleService.listArticles(count);
    }

}
