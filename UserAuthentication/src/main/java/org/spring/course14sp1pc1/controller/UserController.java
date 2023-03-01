package org.spring.course14sp1pc1.controller;

import org.spring.course14sp1pc1.domain.User;
import org.spring.course14sp1pc1.service.ISecurityTokenGenerator;
import org.spring.course14sp1pc1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ISecurityTokenGenerator iSecurityTokenGenerator;

    @PostMapping("register")
    public ResponseEntity<?> save(@RequestBody User user){

        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
    @GetMapping("users")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    @DeleteMapping("user/{Id}")
    public ResponseEntity<?> deleteUser(String email){
        return new ResponseEntity<>(userService.delete(email),HttpStatus.OK);
    }
    @PostMapping("login")
    public ResponseEntity<?> loginCheck(@RequestBody User user){
        User login=userService.loginCheck(user.getEmail(),user.getPassword());
        if(login!=null){
            Map<String,String>loginMap=iSecurityTokenGenerator.tokenGenerator(login);
            return new ResponseEntity<>(loginMap,HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid User",HttpStatus.NOT_FOUND);
    }
}
