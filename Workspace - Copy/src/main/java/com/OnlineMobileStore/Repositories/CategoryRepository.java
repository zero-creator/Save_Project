package com.OnlineMobileStore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.OnlineMobileStore.entities.CategoryModel;



      public interface CategoryRepository extends JpaRepository<CategoryModel,Integer> {
      }



