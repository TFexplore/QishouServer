package com.zhaishu.qishouserver.common;


import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionsResolver {//全局异常处理

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultResponse MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return ResultResponse.error(objectError.getDefaultMessage());
    }
    /**
     * 处理所有不可知异常
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(Exception.class)
    public ResultResponse handleException(Exception e) {
        e.printStackTrace();
        return ResultResponse.error(ErrorResultCode.SYSTEM_ERROR.getCode(),e.getMessage());
    }

    /**
     * 处理所有业务异常
     * @param e 业务异常
     * @return  json结果
     */
    @ExceptionHandler(RuntimeExceptions.class)
    public ResultResponse handleOpdRuntimeException(RuntimeExceptions e) {

        e.printStackTrace();
        return ResultResponse.error(e.getCode(),e.getMessage());
    }







}
