package com.learntechfree.ltf.resolver;

import lombok.RequiredArgsConstructor;
import com.learntechfree.ltf.entity.Unit;
import com.learntechfree.ltf.entity.Article;
import com.learntechfree.ltf.entity.Subject;
import com.learntechfree.ltf.entity.Category;
import com.learntechfree.ltf.unit.UnitService;
import org.springframework.stereotype.Controller;
import com.learntechfree.ltf.article.ArticleService;
import com.learntechfree.ltf.category.CategoryService;
import com.learntechfree.ltf.subject.SubjectService;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final UnitService unitService;
    private final ArticleService articleService;
    private final CategoryService categoryService;
    private final SubjectService subjectService;

    public List<Article> articles() {

        return articleService.listArticles(10);
    }

    public List<Category> categories() {

        return categoryService.listCategories();
    }

    public List<Unit> units() {

        return unitService.listUnits();
    }

    public List<Subject> subjects() {

        return subjectService.listSubjects();
    }
}
