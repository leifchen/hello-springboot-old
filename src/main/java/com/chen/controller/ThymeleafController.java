package com.chen.controller;

import com.chen.config.ResourceSettings;
import com.chen.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ThymeleafController
 *
 * @Author LeifChen
 * @Date 2018-12-07
 */
@Controller
@RequestMapping("/th")
public class ThymeleafController {

    @Resource
    private ResourceSettings resourceSettings;

    @GetMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", resourceSettings.getName());
        map.addAttribute("website", resourceSettings.getWebsite());
        return "index";
    }

    @GetMapping("/center")
    public String center() {
        return "center/center";
    }

    @GetMapping("/test")
    public String test(ModelMap map) {
        User u = User.builder()
                .name("LeifChen")
                .password("123456")
                .age(18)
                .gmtModified(new Date())
                .remark("<font color='green'>Hello<b></b></font>")
                .build();
        map.addAttribute("user", u);

        User u1 = User.builder()
                .name("Chen")
                .age(20)
                .build();
        User u2 = User.builder()
                .name("Leif")
                .age(12)
                .build();
        List<User> userList = new ArrayList<>();
        userList.add(u);
        userList.add(u1);
        userList.add(u2);
        map.addAttribute("userList", userList);

        return "test";
    }

    @PostMapping("postform")
    public String postform(User u) {
        System.out.println(u.getName());
        System.out.println(u.getAge());
        return "redirect:/th/test";
    }
}
