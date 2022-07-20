package com.OnlineMobileStore.Services;

import java.util.Optional;
import java.util.Set;

import com.OnlineMobileStore.entities.CategoryModel;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {




            public CategoryModel addCategory(CategoryModel categoryModel);
            public CategoryModel updateCategory(CategoryModel categoryModel);
            public Set<CategoryModel> getCategories();
            public Optional<CategoryModel> getCategory(int categoryId);
            public void delete(Integer categoryId);
        }

