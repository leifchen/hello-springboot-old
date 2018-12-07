package com.chen.controller;

import com.chen.common.JsonResult;
import com.chen.model.SysUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * UserController
 *
 * @Author LeifChen
 * @Date 2018-12-07
 */
@RestController
@RequestMapping("/admin")
public class SysUserController {

    @GetMapping("/user")
    public JsonResult listAll() {
        SysUser user = SysUser.builder()
                .name("LeifChen")
                .password("123456")
                .age(28)
                .gmtModified(new Date())
                .build();
        return JsonResult.ok(user);
    }
}
