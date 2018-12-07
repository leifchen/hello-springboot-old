package com.chen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * SysUser
 *
 * @Author LeifChen
 * @Date 2018-11-13
 */
@Builder
@Data
public class SysUser {

    private String name;

    @JsonIgnore
    private String password;

    private Integer age;

    private String remark;

    private Date gmtModified;
}
