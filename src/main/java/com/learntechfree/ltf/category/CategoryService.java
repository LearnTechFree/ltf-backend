package com.learntechfree.ltf.category;

import com.learntechfree.ltf.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> listCategories() {

        return categoryRepository.findAll();
    }
}
