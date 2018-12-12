package com.chen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户
 * <p>
 * @Author LeifChen
 * @Date 2018-11-13
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String name;

    @JsonIgnore
    private String password;

    private Integer age;

    private String remark;

    private Date gmtModified;
}
