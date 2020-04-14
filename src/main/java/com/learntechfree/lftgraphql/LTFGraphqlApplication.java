package com.learntechfree.lftgraphql;

import com.learntechfree.lftgraphql.article.ArticleController;
import com.learntechfree.lftgraphql.resolver.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LTFGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(LTFGraphqlApplication.class, args);
    }


}
