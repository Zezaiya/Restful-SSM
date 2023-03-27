package com.zezai.controller;

public class Result {
    private Object data;
    private Integer code;     //字段不是固定的,不同的公司不同的人定义的都不同
    private String msg;

    public Result() {
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(Integer code) {
        this.code = code;
    }

    public Result(String msg) {
        this.msg = msg;
    }

    public Result(Integer code, Object data, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, Object data) {
        this.data = data;
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
