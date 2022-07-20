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
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    @Autowired
    ICartService cartService;

    @Autowired
    UserService userService;

    @Autowired
    MobileService mobileService;


    @PostMapping("/addProduct")
    public ResponseEntity<?> addCartwithProduct(@RequestBody HashMap<String,String> addCartRequest) {
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
            return ResponseEntity.ok(cartService.addCart(c));

    }
    @PutMapping("/update")
    public ResponseEntity<?> getCartsByUserId(@RequestBody HashMap<String,String> getCartRequest) {
        int cId =  Integer.parseInt(getCartRequest.get("cId"));
        int qty =  Integer.parseInt(getCartRequest.get("qty"));
        CartModel obj = cartService.findById(cId);
        obj.setQuantity(qty);
        return ResponseEntity.ok(cartService.addCart(obj));

    }
    @GetMapping("/viewAll")
    public ResponseEntity<?> View() {
        List<CartModel> obj = cartService.findAll();
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> View(@PathVariable int id) {
            List<CartModel> obj = cartService.findAllByUserid(id);
            return ResponseEntity.ok(obj);
    }


    @GetMapping("/view/delete/{cid}")
    public ResponseEntity<?> Delete(@PathVariable int cid) {
            CartModel obj = cartService.findById(cid);
            cartService.delete(cid);
            return ResponseEntity.ok("Item has been remover"+obj);
        }
    }

