package com.OnlineMobileStore.Repositories;

import com.OnlineMobileStore.entities.CartModel;
import com.OnlineMobileStore.entities.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<OrderModel,Integer> {

}
