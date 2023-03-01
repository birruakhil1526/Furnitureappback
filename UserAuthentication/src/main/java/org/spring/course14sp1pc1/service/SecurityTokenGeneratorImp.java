package org.spring.course14sp1pc1.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.spring.course14sp1pc1.domain.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class SecurityTokenGeneratorImp implements ISecurityTokenGenerator {

    @Override
    public Map<String, String> tokenGenerator(User user) {
        String JwtToken;
        JwtToken= Jwts.builder().setSubject(user.getRole()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"authenticator").compact();
        Map<String,String> tokenMap=new HashMap<>();
        tokenMap.put("Token",JwtToken);
        tokenMap.put("role", user.getRole());
        tokenMap.put("message","User successfully loggedin");
        return tokenMap;
    }
}
