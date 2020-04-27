package com.learntechfree.ltf.resolver;

import com.learntechfree.ltf.article.ArticleService;
import com.learntechfree.ltf.category.CategoryService;
import com.learntechfree.ltf.entity.Article;
import com.learntechfree.ltf.entity.Category;
import com.learntechfree.ltf.entity.Subject;
import com.learntechfree.ltf.entity.Unit;
import com.learntechfree.ltf.subject.SubjectService;
import com.learntechfree.ltf.unit.UnitService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final ArticleService articleService;
    private final CategoryService categoryService;
    private final SubjectService subjectService;
    private final UnitService unitService;

    public List<Article> listArticles(){
       return articleService.listArticles(10);
    }

    public List<Category> listCategories(){
        return categoryService.listCategories();
    }
 public List<Unit> listUnits(){
        return unitService.listUnits();
    }
 public List<Subject> listSubjects(){
        return subjectService.listSubjects();
    }



}
