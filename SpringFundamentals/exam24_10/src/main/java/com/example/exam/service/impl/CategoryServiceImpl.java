package com.example.exam.service.impl;

import com.example.exam.model.entity.Category;
import com.example.exam.model.entity.CategoryNameEnum;
import com.example.exam.repository.CategoryRepository;
import com.example.exam.service.CategoryService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }
        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category();
                    category.setName(categoryNameEnum);
                    switch (categoryNameEnum) {
                        case BATTLE -> category.setDescription("Very scary battle ship.");
                        case CARGO -> category.setDescription("Can transport anything anywhere.");
                        case PATROL -> category.setDescription("Will scout the area.");
                    }
                    categoryRepository.save(category);
                });
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum category) {

        return categoryRepository.findByName(category).orElse(null);
    }


}
