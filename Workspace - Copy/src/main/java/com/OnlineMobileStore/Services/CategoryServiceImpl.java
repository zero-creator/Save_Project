package com.OnlineMobileStore.Services;

import com.OnlineMobileStore.entities.CategoryModel;
import com.OnlineMobileStore.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;


    @Service
    public class CategoryServiceImpl implements CategoryService {

        @Autowired
        CategoryRepository categoryRepository;

        @Override
        public CategoryModel addCategory(CategoryModel category) {
            return this.categoryRepository.save(category);
        }

        @Override
        public CategoryModel updateCategory(CategoryModel category) {
            return this.categoryRepository.save(category);
        }

        @Override
        public Set<CategoryModel> getCategories() {
            return new LinkedHashSet<>(this.categoryRepository.findAll());
        }

        @Override
        public Optional<CategoryModel> getCategory(int Id) {
            return categoryRepository.findById(Id);
        }


//        @Override
//        public void delete(Integer categoryId) {
//
//        }

        @Override
        public void delete(Integer categoryId) {
            this.categoryRepository.deleteById(categoryId);
        }
    }

