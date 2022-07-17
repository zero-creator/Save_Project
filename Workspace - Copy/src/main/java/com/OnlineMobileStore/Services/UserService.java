package com.OnlineMobileStore.Services;

import com.OnlineMobileStore.Exceptions.InvalidLoginDetails;
import com.OnlineMobileStore.Exceptions.MobileNotFoundException;
import com.OnlineMobileStore.Repositories.UserRepo;
import com.OnlineMobileStore.entities.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepo userRepository;

    public UserModel getUserById(int userId) throws MobileNotFoundException { //Need to Change
        Optional<UserModel> optionalProduct = userRepository.findById(userId);
        if (!optionalProduct.isPresent())
            throw new MobileNotFoundException("User id is invalid " + userId);
        return optionalProduct.get();
    }

    @Override
    public UserModel validateUser(String username, String password) {
        return null;
    }

    @Override
    public UserModel addUser(UserModel user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public UserModel removeUser(UserModel user) {
        return null;
    }


    public int Login_User(String userName, String userPassword)throws InvalidLoginDetails {


        Optional<UserModel> optionalProduct = userRepository.findByUserNameAndUserPassword(userName,userPassword);
        if (!optionalProduct.isPresent())
            throw new InvalidLoginDetails("user details are invalid ");
        return optionalProduct.get().getUserID();
    }


}
