package com.zhaishu.qishouserver.common;

public class ResultResponse {
    private String code;
    private String msg;
    private Object data;

    public ResultResponse() {

    }

    public ResultResponse(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static ResultResponse resultSuccess(Object data) {
        return new ResultResponse("200", "success", data);
    }

    public static ResultResponse error(String msg) {
        return new ResultResponse("400", msg, null);
    }
    public static ResultResponse error(String code,String msg) {
        return new ResultResponse(code, msg, null);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
