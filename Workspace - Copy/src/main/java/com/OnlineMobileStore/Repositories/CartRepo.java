package com.OnlineMobileStore.Repositories;

import com.OnlineMobileStore.entities.CartModel;
import com.OnlineMobileStore.entities.MobileModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface CartRepo extends JpaRepository<CartModel,Integer> {
    public List<CartModel> findAllByUserid(int User_id);

    public Boolean existsByUseridAndProduct(int User_id,int product);

    @Query("SELECT SUM(c.price) FROM CartModel c WHERE c.userid = :user_id")
    public float TotalCost(int user_id);
}
