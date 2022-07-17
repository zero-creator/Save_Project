package com.OnlineMobileStore.Services;

import com.OnlineMobileStore.Exceptions.MobileNotFoundException;
import com.OnlineMobileStore.Repositories.CartRepo;
import com.OnlineMobileStore.entities.CartModel;
import com.OnlineMobileStore.entities.MobileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CartService implements ICartService {

    @Autowired
    CartRepo cartRepo;

    @Override
    public List<CartModel> findAll() {
        return cartRepo.findAll();
    }

    @Override
    public void save(CartModel cartModel) {
        cartRepo.save(cartModel);
    }

    @Override
    public Optional<CartModel> findById(int id) {
        return cartRepo.findById(id);
    }

    @Override
    public List<CartModel> findAllByUserid(int id) {
        return cartRepo.findAllByUserid(id);
    }


    @Override
    public void delete(int id) {
        cartRepo.deleteById(id);
    }

    public void findByUserAndProduct(int User_id,int pid) throws MobileNotFoundException { //Need to Change
        if (cartRepo.existsByUseridAndProduct(User_id,pid))
             throw new MobileNotFoundException("Product Already Exits in your Cart " + pid); //.getMobileId()


    }

    @Override
    public float TotalSum(int userId) {
        return cartRepo.TotalCost(userId);

    }


}
