package com.chen.controller;

import com.chen.common.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ErrorController
 * <p>
 * @Author LeifChen
 * @Date 2018-12-11
 */
@Controller
@RequestMapping("/err")
public class ErrorController {

    @GetMapping("/page")
    public String error() {
        int a = 1 / 0;
        return "error";
    }

    @GetMapping("/ajax")
    public String ajax() {
        return "ajax";
    }

    @PostMapping("/ajaxError")
    public JsonResult ajaxError() {
        int a = 1 / 0;
        return JsonResult.ok();
    }
}
