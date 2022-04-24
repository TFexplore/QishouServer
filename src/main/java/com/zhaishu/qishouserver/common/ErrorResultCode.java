package com.zhaishu.qishouserver.common;

public enum ErrorResultCode {


    SYSTEM_ERROR("500","系统异常"),

    PARAMETER_ERROR("0000", "参数有误"),
    

    USER_NOT_FOUND("1004","用户不存在"),

    PASSWORD_ERROR("1005","密码错误" ),

    TOKEN_MISS("1007","toekn缺失"),

    TOKEN_TIMEOUT("1006","无效token，请重新登陆" );

    /**
     * 结果码
     */
    private String code;

    /**
     * 结果码描述
     */
    private String msg;

    ErrorResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

