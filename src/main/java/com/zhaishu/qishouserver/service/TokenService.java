package com.zhaishu.qishouserver.service;


import com.zhaishu.qishouserver.entity.Employee;

public interface TokenService {
    public String getToken(Employee user);

    public int getUidByToken(String token);
}
