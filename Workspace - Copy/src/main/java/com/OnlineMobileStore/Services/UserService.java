package com.OnlineMobileStore.Services;

import com.OnlineMobileStore.Exceptions.UserAllreadyException;
import com.OnlineMobileStore.Exceptions.UserNotFoundException;
import com.OnlineMobileStore.Repositories.UserRepo;
import com.OnlineMobileStore.common.LoginResponse;
import com.OnlineMobileStore.entities.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepo userRepository;

    public UserModel getUserById(int userId) throws UserNotFoundException {
        Optional<UserModel> optionalProduct = userRepository.findById(userId);
        if (!optionalProduct.isPresent())
            throw new UserNotFoundException("User id " + userId+" is Invalid");
        return optionalProduct.get();
    }
    @Override
    public LoginResponse addUser(UserModel user) {
        LoginResponse res=new LoginResponse();
        Optional<UserModel> optionalEmail = userRepository.findByEmailId(user.getEmailId());
        if (optionalEmail.isEmpty()) {
            res.setUser(userRepository.save(user));
            res.setMessage("Successful registered.");
            return res;
        }
        res.setMessage("You are already registered. Please log in.");
        return res;
    }

    public List<UserModel> showAllCustomers() {
        List<UserModel> users = userRepository.findAll();
        List<UserModel> userModels = new ArrayList<>();
        for(UserModel user : users) {
            userModels.add(user);
        }
        return userModels;
    }


    public LoginResponse Login_User(String email, String userPassword) {
        LoginResponse res=new LoginResponse();
        Optional<UserModel> optionalEmail = userRepository.findByEmailId(email);
        if (optionalEmail.isEmpty()) {
            res.setMessage("You are not Registered with us.Please sign up");
            return res;
        }
        if(!optionalEmail.get().getUserPassword().equals(userPassword)){
            res.setMessage("Your email or password is incorrect"+optionalEmail.get().getUserPassword());
            return res;
        }
        res.setUser(optionalEmail.get());
        res.setMessage("Log in Successful");

        return res;
    }

    public String DeleteCustomerById(Integer userId) throws UserNotFoundException {
        Optional<UserModel> optional = userRepository.findById(userId);
        if (!optional.isPresent())
            throw new UserNotFoundException("User id is invalid " + userId);
        UserModel user=optional.get();
        userRepository.delete(user);
        return "User "+userId+" is Successfully Deleted";
    }

    public UserModel updateCustomer(Integer userId, UserModel user)  throws UserNotFoundException{
        Optional<UserModel> optional = userRepository.findById(userId);
        if (!optional.isPresent())
            throw new UserNotFoundException("User id is invalid " + userId);
        UserModel user1 = userRepository.findById(userId).get();
        user1.setUserName(user.getUserName());
        user1.setEmailId(user.getEmailId());
        user1.setMobileNumber(user.getMobileNumber());
        user1.setUserPassword(user.getUserPassword());

        userRepository.save(user1);
        return user1;
    }

}
