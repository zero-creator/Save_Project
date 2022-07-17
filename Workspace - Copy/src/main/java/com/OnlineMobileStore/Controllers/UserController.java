package com.OnlineMobileStore.Controllers;


import com.OnlineMobileStore.Exceptions.InvalidLoginDetails;
import com.OnlineMobileStore.Services.UserService;
import com.OnlineMobileStore.entities.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("User")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserModel> regsiterUser( @RequestBody UserModel user) {
        UserModel userNew = userService.addUser(user);

        return new ResponseEntity<>(userNew, HttpStatus.CREATED);
    }

    @PostMapping("/login")
        public ResponseEntity<Map<String,String>> getLogin(@RequestBody HashMap<String,String> Login_input) throws InvalidLoginDetails {
             Map<String,String> response = new HashMap<String,String>();
             String userName= Login_input.get("userName");
             String userPassword= Login_input.get("userPassword");
             //response.put("status","unsuccessful");
             int userId=userService.Login_User(userName,userPassword);

                 response.put("status","successful");
                 response.put("userId",Integer.toString(userId));

             return new ResponseEntity<Map<String,String>>(response,HttpStatus.OK);
    }


}
