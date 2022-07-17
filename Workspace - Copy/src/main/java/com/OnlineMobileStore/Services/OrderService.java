package com.OnlineMobileStore.Services;

import com.OnlineMobileStore.Repositories.OrderRepo;
import com.OnlineMobileStore.entities.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;


    //view
    public List<OrderModel> findAll() {
        return orderRepo.findAll();
    }

   //Add
    public void save(OrderModel cartModel) {
        orderRepo.save(cartModel);
    }

    //view
    public Optional<OrderModel> findById(int id) {
        return orderRepo.findById(id);
    }

/*
    public List<OrderModel> findAllByUserid(int id) {
        return orderRepo.findAllByUserid(id);
    }
*/

}
