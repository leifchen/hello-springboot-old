package com.chen.enums;

import lombok.Getter;

/**
 * ResultCodeEnum
 *
 * @Author LeifChen
 * @Date 2018-12-07
 */
@Getter
public enum ResultCodeEnum {
    /**
     * 成功
     */
    SUCCESS(200,"成功"),
    /**
     * 失败
     */
    ERROR(500,"失败");

    private Integer code;
    private String msg;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
