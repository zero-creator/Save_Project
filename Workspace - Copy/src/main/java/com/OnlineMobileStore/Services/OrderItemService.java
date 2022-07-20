package com.OnlineMobileStore.Services;

import com.OnlineMobileStore.Exceptions.MobileNotFoundException;
import com.OnlineMobileStore.Exceptions.OrderItemNotFoundException;
import com.OnlineMobileStore.Repositories.OrderItemRepo;
import com.OnlineMobileStore.entities.CartModel;
import com.OnlineMobileStore.entities.OrderItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepo orderItemRepo;


    public List<OrderItemModel> findAll() {
        return orderItemRepo.findAll();
    }


    public void save(OrderItemModel orderItemModel) {
        orderItemRepo.save(orderItemModel);
    }


    public Optional<OrderItemModel> findById(int id) throws OrderItemNotFoundException {
        if(orderItemRepo.findById(id).isEmpty())
            throw new OrderItemNotFoundException("Order Item With this Id Doesn't exist" + id);
        return orderItemRepo.findById(id);
    }


    public List<OrderItemModel> findAllByOrderid(int id) throws OrderItemNotFoundException {
        if(orderItemRepo.findAllByOrderId(id).isEmpty())
            throw new OrderItemNotFoundException("Order Item With this Id Doesn't exist" + id);
        return orderItemRepo.findAllByOrderId(id);
    }

}
