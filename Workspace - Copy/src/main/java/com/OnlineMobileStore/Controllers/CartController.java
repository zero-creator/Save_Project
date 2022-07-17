package com.OnlineMobileStore.Controllers;

import com.OnlineMobileStore.Services.ICartService;
import com.OnlineMobileStore.Services.MobileService;
import com.OnlineMobileStore.Services.UserService;
import com.OnlineMobileStore.entities.CartModel;
import com.OnlineMobileStore.entities.MobileModel;
import com.OnlineMobileStore.entities.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    ICartService cartService;

    @Autowired
    UserService userService;

    @Autowired
    MobileService mobileService;


    @GetMapping("/addProduct")
    public ResponseEntity<?> addCartwithProduct(@RequestBody HashMap<String,String> addCartRequest) {
        try {
            int productId = Integer.parseInt(addCartRequest.get("productId"));
            int userId =  Integer.parseInt(addCartRequest.get("userId"));
            int qty =  Integer.parseInt(addCartRequest.get("qty"));
            //double price = Double.parseDouble(addCartRequest.get("price"));
            //c.setProduct(productId); find by product id
            //c.setUserid(userId);
            //c.setPrice(price);
            //c.setQuantity(qty);
            UserModel user= userService.getUserById(userId);
            MobileModel product = mobileService.getUserById(productId);
            cartService.findByUserAndProduct(userId,productId); //CHECK
            //c.setProduct(product);
            CartModel c=new CartModel(productId,qty,userId,(qty*product.getMobileCost()));
            cartService.save(c);
            return ResponseEntity.ok(c);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @GetMapping("/update")
    public ResponseEntity<?> getCartsByUserId(@RequestBody HashMap<String,String> getCartRequest) {
        try {int cId =  Integer.parseInt(getCartRequest.get("cId"));
            int qty =  Integer.parseInt(getCartRequest.get("qty"));
            Optional<CartModel> obj = cartService.findById(cId);
            obj.get().setQuantity(qty);
            cartService.save(obj.get());
            return ResponseEntity.ok(obj);
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/viewAll")
    public ResponseEntity<?> View() {
        try {
            List<CartModel> obj = cartService.findAll();
            return ResponseEntity.ok(obj);
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> View(@PathVariable int id) {
        try {
            List<CartModel> obj = cartService.findAllByUserid(id);
            return ResponseEntity.ok(obj);
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/view/delete/{cid}")
    public ResponseEntity<?> Delete(@PathVariable int cid) {
        try {
            Optional<CartModel> obj = cartService.findById(cid);
            cartService.delete(cid);
            return ResponseEntity.ok("Item has been remover"+obj);
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }





}
