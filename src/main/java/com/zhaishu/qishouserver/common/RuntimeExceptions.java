package com.zhaishu.qishouserver.common;

public class RuntimeExceptions extends RuntimeException{
    /**
     * 结果码
     */
    private String code;

    /**
     * 结果码描述
     */
    private String msg;

    /**
     * 结果码枚举
     */
    private ErrorResultCode resultCode;

    public RuntimeExceptions(ErrorResultCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.resultCode = resultCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ErrorResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ErrorResultCode resultCode) {
        this.resultCode = resultCode;
    }


}
