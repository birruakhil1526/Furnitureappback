package org.spring.course14sp1pc1.service;

import org.spring.course14sp1pc1.domain.User;
import org.spring.course14sp1pc1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        if(userRepository.findById(user.getEmail()).isPresent()){
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String delete(String email) {
        if(userRepository.findById(email).isEmpty()){
            return "user not found";
        }
        userRepository.deleteById(email);
        return "user successfully deleted";
    }

    @Override
    public User loginCheck(String email, String password) {

        if(userRepository.findById(email).isPresent()){
            // get userobjet by using emailId
            User user=userRepository.findById(email).get();
            //check password
            if(user.getPassword().equals(password)){
                user.setPassword("");
                return user;
            }else{
                //invalid user
                return null;
            }

        }else{
            //user not exits
            return null;
        }
    }
}
