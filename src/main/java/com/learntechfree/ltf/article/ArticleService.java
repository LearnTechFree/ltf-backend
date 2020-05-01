package com.learntechfree.ltf.article;

import com.learntechfree.ltf.entity.Article;
import com.learntechfree.ltf.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public Article createArticle(Article article) {

        return articleRepository.saveAndFlush(article);
    }

    public List<Article> listArticles(int count) {

        return articleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    public Article getArticle(Long id) {
        
        return articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article", "id", id));
    }

}
