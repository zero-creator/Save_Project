package com.OnlineMobileStore.Repositories;


import com.OnlineMobileStore.entities.CartModel;
import com.OnlineMobileStore.entities.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepo extends JpaRepository<OrderModel,Integer> {
    public List<OrderModel> findAllByUserId(int user_Id);

}
