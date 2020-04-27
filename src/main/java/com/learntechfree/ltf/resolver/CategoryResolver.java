package com.learntechfree.ltf.resolver;

import com.learntechfree.ltf.entity.Category;
import com.learntechfree.ltf.entity.Subject;
import com.learntechfree.ltf.subject.SubjectService;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoryResolver implements GraphQLResolver<Category> {

    private final SubjectService subjectService;

    public List<Subject> subjects(Category category){
        return (List<Subject>) subjectService.finaAllSubjectsForCategory(category);
    }
}
