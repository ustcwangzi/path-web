package com.path.web.response;

public class BaseResponse<T> {
    public static final int SUCCESS = 200;
    public static final int INVALID = 400;
    public static final int FAIL = 500;
    private int code;
    private String msg;
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> BaseResponse<T> buildSuccess(T data) {
        return new BaseResponse<>(SUCCESS, "success", data);
    }

    public static <T> BaseResponse<T> buildInvalid(String msg) {
        return new BaseResponse<>(INVALID, msg);
    }

    public static <T> BaseResponse<T> buildFail(String msg) {
        return new BaseResponse<>(FAIL, msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return this.code == SUCCESS;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
