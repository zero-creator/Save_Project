package com.OnlineMobileStore.Repositories;

import com.OnlineMobileStore.entities.CartModel;
import com.OnlineMobileStore.entities.OrderItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItemModel,Integer> {
    public List<OrderItemModel> findAllByOrderId(int Order_id);
    public void deleteByOrderId(int Order_id);
}
