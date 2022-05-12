package com.zhaishu.qishouserver.Security;


import org.springframework.stereotype.Component;

@Component
public class HashPasswordEncoder  {


    public String encode(CharSequence charSequence) {
        return Md5Utils.code( charSequence.toString());
    }


    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(Md5Utils.code(charSequence .toString()));
    }
}
