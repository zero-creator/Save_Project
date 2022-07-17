package com.OnlineMobileStore.Services;

import com.OnlineMobileStore.Exceptions.MobileNotFoundException;
import com.OnlineMobileStore.entities.CartModel;
import com.OnlineMobileStore.entities.MobileModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICartService {
    List < CartModel > findAll();
    void save(CartModel cartModel);
    Optional< CartModel > findById(int id);
    List<CartModel> findAllByUserid(int User_id);
    void findByUserAndProduct(int User_id, int pid) throws MobileNotFoundException;
    void delete(int id);
    public float TotalSum(int userId);
}
