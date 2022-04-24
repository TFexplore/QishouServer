package com.zhaishu.qishouserver.Security;

import com.zhaishu.qishouserver.common.ErrorResultCode;
import com.zhaishu.qishouserver.common.RuntimeExceptions;
import com.zhaishu.qishouserver.entity.Employee;
import com.zhaishu.qishouserver.service.EmployeeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    EmployeeService userService;

    private static final Log log = LogFactory.getLog(UserDetailsServiceImpl.class);


    HashPasswordEncoder passwordEncoder=new HashPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String phone_num) throws UsernameNotFoundException {
        Employee user = userService.queryByTel(phone_num);
        if (user == null) {

           throw new RuntimeExceptions(ErrorResultCode.USER_NOT_FOUND);
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        int roleType =user.getEmployeeType();
        System.out.println("------------------------");
        switch (roleType) {
            case 1:
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                break;
            case 4:
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                break;
            default:
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                break;
        }

        org.springframework.security.core.userdetails.User userdetail
                = new org.springframework.security.core.userdetails.User(
                        user.getName(),
               user.getPassword(),
                authorities);
        System.out.println("管理员信息："+user.getName()+"   "+
                passwordEncoder.encode(user.getPassword())+"  "
                +userdetail.getAuthorities());
        //通过客户端输入的用户名查询，若数据库有该用户名则查出该用户名对应的Hash密码，然后进行原字符加密(加密后字符不变),与客户端输入密码Hash后比较
        return userdetail;
    }
}
