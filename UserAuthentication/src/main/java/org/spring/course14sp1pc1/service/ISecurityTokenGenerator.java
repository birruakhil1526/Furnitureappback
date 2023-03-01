package org.spring.course14sp1pc1.service;

import org.spring.course14sp1pc1.domain.User;

import java.util.Map;

public interface ISecurityTokenGenerator {
    Map<String,String> tokenGenerator(User user);
}
