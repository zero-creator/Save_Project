package com.OnlineMobileStore.Controllers;

import com.OnlineMobileStore.Services.ICartService;
import com.OnlineMobileStore.Services.MobileService;
import com.OnlineMobileStore.Services.OrderService;
import com.OnlineMobileStore.Services.UserService;
import com.OnlineMobileStore.entities.CartModel;
import com.OnlineMobileStore.entities.MobileModel;
import com.OnlineMobileStore.entities.OrderModel;
import com.OnlineMobileStore.entities.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/order")
public class OrderController {


    @Autowired
    ICartService cartService;

    @Autowired
    UserService userService;

    @Autowired
    MobileService mobileService;

    @Autowired
    OrderService orderService;


    @GetMapping("/add")
    public ResponseEntity<?> addToOrder(@RequestBody HashMap<String,String> addOrderRequest) {
        try {
                System.out.println("OK?");
            int userId =  Integer.parseInt(addOrderRequest.get("userId"));

            //double price = Double.parseDouble(addCartRequest.get("price"));
            //c.setProduct(productId); find by product id
            //c.setUserid(userId);
            //c.setPrice(price);
            //c.setQuantity(qty);
            UserModel user= userService.getUserById(userId);
            float TotalCost=cartService.TotalSum(userId);
            //c.setProduct(product);
            OrderModel o=new OrderModel(userId,TotalCost);
            orderService.save(o);
            return ResponseEntity.ok(o);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}
