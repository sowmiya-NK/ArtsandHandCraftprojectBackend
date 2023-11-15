package com.restapi.dto;

import com.restapi.model.Category;
import com.restapi.request.CategoryRequest;
import com.restapi.response.CategoryResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDto {
    //particular category create
    public Category mapToCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        if (categoryRequest.getId() != null) {
            category.setId(categoryRequest.getId());
        }
        category.setTitle(categoryRequest.getTitle());
        return category;
    }

    //display all category using for loop
    public CategoryResponse mapToCategoryResponse(List<Category> categories) {
        CategoryResponse categoryResponse = new CategoryResponse();
        ArrayList<CategoryRequest> categoryRequests = new ArrayList<>();
        for (Category category : categories) {
            categoryRequests.add(new CategoryRequest(category.getId(), category.getTitle()));
        }
        categoryResponse.setCategories(categoryRequests);//set category
        return categoryResponse;
    }
}
