package com.learntechfree.lftgraphql.article;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/public")
public class ArticleResolver{
    @GetMapping
    public String getMessage() {
        return "Hello from public API controller";
    }
}
