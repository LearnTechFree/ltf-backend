package com.learntechfree.ltf.resolver;

import com.learntechfree.ltf.category.CategoryService;
import com.learntechfree.ltf.entity.Category;
import com.learntechfree.ltf.entity.Subject;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoryResolver implements GraphQLResolver<Category> {

    private final CategoryService categoryService;

    public List<Subject> subjects(Category category) {
        
        return categoryService.getSubjects(category);
    }
}
