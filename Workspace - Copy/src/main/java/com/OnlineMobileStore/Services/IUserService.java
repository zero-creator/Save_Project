package com.OnlineMobileStore.Services;
import com.OnlineMobileStore.Exceptions.InvalidLoginDetails;
import com.OnlineMobileStore.Exceptions.MobileNotFoundException;
import com.OnlineMobileStore.entities.UserModel;
import com.OnlineMobileStore.Exceptions.InvalidLoginDetails;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    public UserModel validateUser(String username, String password);
    public UserModel addUser(UserModel user);
    public UserModel removeUser(UserModel user);
    public int Login_User(String userName, String userPassword)throws InvalidLoginDetails;
    public UserModel getUserById(int userId) throws MobileNotFoundException;
}