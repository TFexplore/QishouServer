package com.zhaishu.qishouserver.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.zhaishu.qishouserver.common.RedisUtil;
import com.zhaishu.qishouserver.entity.Employee;
import com.zhaishu.qishouserver.service.TokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("tokenService")
public class TokenServiceImpl implements TokenService {
    @Resource
    RedisUtil redisUtil;

    @Override
    public String getToken(Employee user) {

        Map<String, Object> claims=new HashMap<>();
        claims.put("userId",user.getEmployeeId());
        claims.put("phone_num",user.getPhoneNum());
        claims.put("userType",user.getEmployeeType());

        return JWT.create()
                .withClaim("userId",user.getEmployeeId())
                .withClaim("phone_num",user.getPhoneNum())
                .withClaim("userType",user.getEmployeeType())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 720))//过期时间,三天
                .sign(Algorithm.HMAC256(user.getPhoneNum())); //加密
    }

    @Override
    public int getUidByToken(String token) {
        String userId;
        userId = JWT.decode(token).getAudience().get(0);
        return Integer.valueOf(userId);
    }
}
