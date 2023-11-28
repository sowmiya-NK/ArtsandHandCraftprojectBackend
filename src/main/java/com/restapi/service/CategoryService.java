package com.restapi.service;

import com.restapi.dto.CategoryDto;
import com.restapi.model.Category;
import com.restapi.repository.CategoryRepository;
import com.restapi.request.CategoryRequest;
import com.restapi.response.CategoryResponse;
import com.restapi.response.common.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryDto categoryDto;


    public CategoryResponse findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categoryDto.mapToCategoryResponse(categories);
    }

    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        Category category = categoryDto.mapToCategory(categoryRequest);
        categoryRepository.save(category);
        return findAll();
    }

    public CategoryResponse updateCategory(CategoryRequest categoryRequest) {
        Category category = categoryDto.mapToCategory(categoryRequest);
        categoryRepository.save(category);
        return findAll();
    }

    public CategoryResponse deleteById(Integer id) {
        System.out.println(Long.valueOf(id));
        categoryRepository.deleteById(Long.valueOf(id));
        return findAll();
    }

    public Category findById(Long id) {
        Category category= categoryRepository.findById(id).get();
        return  category;
    }
}
