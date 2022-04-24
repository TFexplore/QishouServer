package com.zhaishu.qishouserver;

import com.github.houbb.data.factory.core.util.DataUtil;
import com.google.gson.Gson;
import com.zhaishu.qishouserver.entity.Rider;
import com.zhaishu.qishouserver.service.EmployeeService;
import com.zhaishu.qishouserver.service.impl.RiderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class QishouServerApplicationTests {

    @Autowired
    EmployeeService riderService;

    @Test
    void contextLoads() {
        //riderService.updateTypeByTel(1,"17823224725");
        int x = 1 ,y = 2 , z = 3;
        System.out.println(y+=z--/++x);

    }

}
