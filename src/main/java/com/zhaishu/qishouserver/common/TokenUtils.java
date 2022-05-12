package com.zhaishu.qishouserver.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;

public class TokenUtils {


    public static String getStringValus(String key,String token){
        String v;
        try {
          v= JWT.decode(token).getClaim(key).asString();
         } catch (JWTDecodeException j)
       {
        throw new RuntimeExceptions(ErrorResultCode.SYSTEM_ERROR);
       }

        return v;

    }
    public static Integer getIntegerValus(String key,String token){
        Integer v;
        try {
            v= JWT.decode(token).getClaim(key).asInt();
        } catch (JWTDecodeException j)
        {
            throw new RuntimeExceptions(ErrorResultCode.SYSTEM_ERROR);
        }

        return v;

    }

}
