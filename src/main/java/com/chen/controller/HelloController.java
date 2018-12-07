package com.chen.controller;

import com.chen.common.JsonResult;
import com.chen.config.ResourceSettings;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * HelloController
 *
 * @Author LeifChen
 * @Date 2018-12-07
 */
@RestController
public class HelloController {

    @Resource
    private ResourceSettings resourceSettings;

    @GetMapping("/hello")
    public JsonResult hello() {
        ResourceSettings bean = new ResourceSettings();
        BeanUtils.copyProperties(resourceSettings, bean);
        return JsonResult.ok(bean);
    }
}
