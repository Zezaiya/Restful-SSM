package com.zezai.controller;

public class Code {//定义Code,将增删查改的状态码定义出来
    public static final Integer SAVE_OK=20011;
    public static final Integer DELETE_OK=20021;
    public static final Integer UPDATE_OK=20031;
    public static final Integer GET_OK=20041;

    public static final Integer SAVE_ERR=20010;
    public static final Integer DELETE_ERR=20020;
    public static final Integer UPDATE_ERR=20030;
    public static final Integer GET_ERR=20040;

    public static final Integer SYSTEM_ERR=50001;
    public static final Integer SYSTEM_TIMEOUT_ERR=50002;
    public static final Integer SYSTEM_UNKNOWN_ERR=59999;  //未知异常
    public static final Integer BUSINESS_ERR=60002;   //业务层异常
}
