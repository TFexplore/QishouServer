package com.zhaishu.qishouserver.common;

import com.google.gson.Gson;
import com.zhaishu.qishouserver.entity.Employee;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public final class RedisUtil {

    private final RedisTemplate<String, String> redisTemplate;

    private Gson gson = new Gson();

    public RedisUtil(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //保存用户信息
    public Boolean savePhonenum(Employee employee) {
        String pkey = "token" + employee.getId();
        redisTemplate.opsForValue().set(pkey, employee.getPhoneNum());
        return true;
    }

    //读取Player信息
    public String  readPhonenum(int key) {
        String pkey = "token" + key;
        return redisTemplate.opsForValue().get(pkey);
    }

}