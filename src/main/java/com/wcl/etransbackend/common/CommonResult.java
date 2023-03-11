package com.wcl.etransbackend.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult { //通用结果类
    private static final String CODE_SUCCESS = "200";
    private static final String CODE_SYS_ERROR = "500";

    private String code;
    private String msg;
    private Object data;

    public static CommonResult success() {
        return new CommonResult(CODE_SUCCESS, "操作成功", null);
    }

    public static CommonResult success(Object data) {
        return new CommonResult(CODE_SUCCESS, "操作成功", data);
    }

    public static CommonResult error(String code, String msg) {
        return new CommonResult(code, msg, null);
    }

    public static CommonResult error(String msg) {
        return new CommonResult(CODE_SYS_ERROR, msg, null);
    }

    public static CommonResult error() {
        return new CommonResult(CODE_SYS_ERROR, "系统错误", null);
    }
}
