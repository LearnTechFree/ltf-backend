package com.learntechfree.ltf.resolver;

import com.learntechfree.ltf.article.ArticleService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final ArticleService articleService;
}
