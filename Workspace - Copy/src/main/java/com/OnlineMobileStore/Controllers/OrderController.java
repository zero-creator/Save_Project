package com.OnlineMobileStore.Controllers;

import com.OnlineMobileStore.Exceptions.OrderNotFoundException;
import com.OnlineMobileStore.Services.*;
import com.OnlineMobileStore.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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

    @Autowired
    OrderItemService orderItemService;


    @GetMapping("/add")
    public ResponseEntity<?> addToOrder(@RequestBody HashMap<String,String> addOrderRequest) {
            int userId =  Integer.parseInt(addOrderRequest.get("userId"));
            UserModel user= userService.getUserById(userId);
            float TotalCost=cartService.TotalSum(userId);
            //double price = Double.parseDouble(addCartRequest.get("price"));
            //c.setProduct(productId); find by product id
            //c.setUserid(userId);
            //c.setPrice(price);
            //c.setQuantity(qty);

            //c.setProduct(product);
            OrderModel o=new OrderModel(userId,TotalCost);
            orderService.save(o);
            return ResponseEntity.ok(o);

    }

    @GetMapping("/viewAll")
    public ResponseEntity<?> View() {
            List<OrderModel> obj = orderService.findAll();
            return ResponseEntity.ok(obj);

    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> ViewWithId(@PathVariable int id) throws OrderNotFoundException{
            List<OrderModel> obj = orderService.findAllByUserId(id);
            return ResponseEntity.ok(obj);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) throws OrderNotFoundException{
        OrderModel orderModel= orderService.findById(id);
        orderModel.setStatus("Cancelled");
        orderService.save(orderModel);
        return ResponseEntity.ok("Order with Id "+id+" has been Cancelled");
    }





}
