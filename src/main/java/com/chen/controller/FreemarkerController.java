package com.chen.controller;

import com.chen.config.ResourceSettings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * FreemarkerController
 *
 * @Author LeifChen
 * @Date 2018-12-07
 */
@Controller
@RequestMapping("/ftl")
public class FreemarkerController {

    @Resource
    private ResourceSettings resourceSettings;

    @GetMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("resource", resourceSettings);
        return "index";
    }

    @GetMapping("/center")
    public String center() {
        return "center/center";
    }
}
