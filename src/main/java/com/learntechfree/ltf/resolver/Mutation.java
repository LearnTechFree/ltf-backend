package com.learntechfree.ltfgraphql.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    public String createArticle(){
        return "Article Created";
    }

}
