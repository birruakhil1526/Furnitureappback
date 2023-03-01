package org.spring.course14sp1pc1.service;

import org.spring.course14sp1pc1.domain.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> getAllUsers();
    String delete(String email);
    User loginCheck(String email,String password);
}

