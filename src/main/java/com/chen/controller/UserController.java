package com.chen.controller;

import com.chen.common.JsonResult;
import com.chen.model.User;
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
public class UserController {

    @GetMapping("/user")
    public JsonResult listAll() {
        User user = User.builder()
                .name("LeifChen")
                .password("123456")
                .age(28)
                .gmtModified(new Date())
                .build();
        return JsonResult.ok(user);
    }
}
