package com.zhaishu.qishouserver.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.zhaishu.qishouserver.common.ErrorResultCode;
import com.zhaishu.qishouserver.common.RedisUtil;
import com.zhaishu.qishouserver.common.RuntimeExceptions;
import com.zhaishu.qishouserver.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Resource
    EmployeeService userService;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest
                .getHeader("token");// 从 http 请求头中取出 token
        //从http中获取phone——num
        String phoneNum = httpServletRequest.getHeader("phone_num");

        // 如果不是映射到方法直接通过
        log.info("token:"+token);

        if (!(object instanceof HandlerMethod)) {
           log.info("不是方法");
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        if (method.getName().equals("errorHtml")){
            return true;
        }



        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(UserToken.PassToken.class)) {
            UserToken.PassToken passToken = method.getAnnotation(UserToken.PassToken.class);
            if (passToken.required()) {
                String requestURI = httpServletRequest.getRequestURI();
                String requestMethod = httpServletRequest.getMethod();
                String requestTime = String.valueOf(System.currentTimeMillis());
                String record = requestTime +" " + " "+requestURI +" "+ requestMethod ;
                log.info(record);

                return true;
            }
        }

        Map<String, Object> map = isValid(token);
        String num=(String) map.get("phone_num");
        Integer type=(Integer) map.get("userType");


        //字符串拼接，将时间，用户id，请求uri拼接成字符串
        String requestURI = httpServletRequest.getRequestURI();
        String requestMethod = httpServletRequest.getMethod();
        String requestTime = String.valueOf(System.currentTimeMillis());
        String record = requestTime +" "+ map.get("userId") + " "+requestURI +" "+ requestMethod ;
        log.info(record);

        if (method.isAnnotationPresent(UserToken.Admin.class)){
            UserToken.Admin admin = method.getAnnotation(UserToken.Admin.class);
            if (admin.required()){
                if (type<1||type>5){

                  throw new RuntimeExceptions(ErrorResultCode.TOKEN_ERROR_ROLE);
                }

                return true;
            }

        }
        if (method.isAnnotationPresent(UserToken.HR.class)){
            UserToken.HR admin = method.getAnnotation(UserToken.HR.class);
            if (admin.required()){
                if (type<1||type>2){

                    throw new RuntimeExceptions(ErrorResultCode.TOKEN_ERROR_ROLE);
                }

                return true;
            }

        }
        if (method.isAnnotationPresent(UserToken.Sales.class)){
            UserToken.Sales admin = method.getAnnotation(UserToken.Sales.class);
            if (admin.required()){
                if ((type<1||type>5)||type==2){

                    throw new RuntimeExceptions(ErrorResultCode.TOKEN_ERROR_ROLE);
                }

                return true;
            }

        }
        if (method.isAnnotationPresent(UserToken.SuperAdmin.class)){
            UserToken.SuperAdmin superAdmin = method.getAnnotation(UserToken.SuperAdmin.class);
            if (superAdmin.required()){
                if (type!=1){

                    throw new RuntimeExceptions(ErrorResultCode.TOKEN_ERROR_ROLE);
                }

                return true;
            }

        }


        return true;
    }





    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
    /**
     * 验证token是否有效
     * @param token
     * @param
     * @return
     */
    public Map<String,Object> isValid(String token){
        // 执行认证
        if (token == null) {
            throw new RuntimeExceptions(ErrorResultCode.TOKEN_MISS);
        }
        // 获取 token 中的 user id
        Integer userId;
        Integer type;
        String snum;
        Map<String ,Object> map=new HashMap<>();
        try {
            userId = JWT.decode(token).getClaim("userId").asInt();
            type   = JWT.decode(token).getClaim("userType").asInt();
            snum   = JWT.decode(token).getClaim("phone_num").asString();
            map.put("userId",userId);
            map.put("userType",type);
            map.put("phone_num",snum);
        } catch (JWTDecodeException j) {
            throw new RuntimeExceptions(ErrorResultCode.SYSTEM_ERROR);
        }

        if (snum == null) {
            throw new RuntimeExceptions(ErrorResultCode.USER_NOT_FOUND);
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(snum)).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new RuntimeExceptions(ErrorResultCode.TOKEN_TIMEOUT);
        }


        return map;
    }

}
