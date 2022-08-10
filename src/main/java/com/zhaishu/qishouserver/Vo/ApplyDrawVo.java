package com.zhaishu.qishouserver.Vo;

import com.zhaishu.qishouserver.entity.ApplyWithdraw;

public class ApplyDrawVo extends ApplyWithdraw {
    String name;
    String checkName;


    public String getCheckName() {
        return checkName;
    }
    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
