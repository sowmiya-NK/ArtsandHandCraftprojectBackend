package com.restapi.controller.Admin;

import com.restapi.model.Category;
import com.restapi.model.Role;
import com.restapi.request.CategoryRequest;
import com.restapi.response.CategoryResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/admin/category")
@RolesAllowed(Role.ADMIN)
public class AdminCategoryController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    private ResponseEntity<APIResponse> getAllCategories() {
        CategoryResponse categoryResponse = categoryService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(categoryResponse.getCategories());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<APIResponse> createCategory(@Valid  @RequestBody CategoryRequest categoryRequest) {
        CategoryResponse categoryResponse = categoryService.createCategory(categoryRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(categoryResponse.getCategories());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<APIResponse> updateCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        CategoryResponse categoryResponse = categoryService.updateCategory(categoryRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(categoryResponse.getCategories());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<APIResponse> deleteCategory(@PathVariable Integer id) {
        CategoryResponse categoryResponse = categoryService.deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(categoryResponse.getCategories());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
