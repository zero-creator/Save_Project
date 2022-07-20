package com.OnlineMobileStore.Controllers;


import com.OnlineMobileStore.Exceptions.UserNotFoundException;
import com.OnlineMobileStore.Services.UserService;
import com.OnlineMobileStore.common.LoginResponse;
import com.OnlineMobileStore.entities.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("User")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public LoginResponse regsiterUser( @RequestBody UserModel user) {
        LoginResponse userNew = userService.addUser(user);

        return userNew;
    }

    @PostMapping("/login")
        public ResponseEntity<?> getLogin(@RequestBody HashMap<String,String> Login_input){
             String email= Login_input.get("emailId");
             String userPassword= Login_input.get("userPassword");

             LoginResponse logres=userService.Login_User(email,userPassword);

             return new ResponseEntity<>(logres , HttpStatus.OK);
    }


    @GetMapping("/viewAllUsers")
    public ResponseEntity<List<UserModel>> showAllUsers(){
        List<UserModel> list=userService.showAllCustomers();
        if(list!=null){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/viewUserById/{id}")
    public UserModel showUserById(@PathVariable int id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteUserById(@PathVariable int id) throws UserNotFoundException {
        return userService.DeleteCustomerById(id);
    }

    @PutMapping("/update/{id}")
    public UserModel updateUser(@PathVariable int id,@RequestBody UserModel user) throws UserNotFoundException {
        return userService.updateCustomer(id,user);
    }





}
