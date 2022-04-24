package com.zhaishu.qishouserver.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.zhaishu.qishouserver.entity.Employee;
import com.zhaishu.qishouserver.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("tokenService")
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(Employee user) {
        return JWT.create().withAudience(String.valueOf(user.getEmployeeId()))
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 72))//过期时间,三天
                .sign(Algorithm.HMAC256(user.getPassword()));
    }

    @Override
    public int getUidByToken(String token) {
        String userId;
        userId = JWT.decode(token).getAudience().get(0);
        return Integer.valueOf(userId);
    }
}
