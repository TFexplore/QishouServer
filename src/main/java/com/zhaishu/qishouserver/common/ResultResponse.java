package com.zhaishu.qishouserver.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        //判断data是否为字符串类型
        if(!(data instanceof String)){
            Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
          data = gson.toJson(data);
        }


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
