package com.OnlineMobileStore.Services;

import com.OnlineMobileStore.Exceptions.MobileNotFoundException;
import com.OnlineMobileStore.entities.CartModel;
import com.OnlineMobileStore.entities.MobileModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICartService {
    public List < CartModel > findAll();
    public CartModel addCart(CartModel cartModel);
    public CartModel findById(int id);
    public List<CartModel> findAllByUserid(int User_id);
    public Boolean findByUserAndProduct(int User_id, int pid) throws MobileNotFoundException;
    public void delete(int id);
    public float TotalSum(int userId);
}
