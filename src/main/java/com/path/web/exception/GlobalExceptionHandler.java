package com.path.web.exception;

import com.path.web.response.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    <T> BaseResponse<T> handleException(HttpServletRequest request, Exception ex) {
        return BaseResponse.buildFail("process fail");
    }

    @ExceptionHandler(PermissionException.class)
    @ResponseBody
    <T> BaseResponse<T> handlePermissionException(HttpServletRequest request, Exception ex) {
        return BaseResponse.buildFail(ex.getMessage());
    }
}
