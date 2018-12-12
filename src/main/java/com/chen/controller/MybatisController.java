package com.chen.controller;

import com.chen.common.JsonResult;
import com.chen.model.SysUser;
import com.chen.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * MybatisController
 * <p>
 * @Author LeifChen
 * @Date 2018-12-12
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    private final SysUserService userService;

    public MybatisController(SysUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/save")
    public JsonResult save() {
        SysUser user = new SysUser();
        user.setName("LeifChen");
        user.setPassword("123456");
        user.setStatus(1);
        user.setGmtCreate(new Date());

        userService.save(user);
        return JsonResult.ok(user, "保存成功");
    }

    @GetMapping("/update")
    public JsonResult update() {
        SysUser user = userService.getById(1L);
        user.setAge(28);

        userService.update(user);
        return JsonResult.ok(user, "更新成功");
    }

    @GetMapping("/delete")
    public JsonResult delete() {
        userService.delete(4L);
        return JsonResult.ok("删除成功");
    }

    @GetMapping("/list")
    public JsonResult list(@RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {

        List<SysUser> userList = userService.listByPage(page, pageSize);
        return JsonResult.ok(userList);
    }

    @GetMapping("/saveError")
    public JsonResult saveError() {
        SysUser user = new SysUser();
        user.setName("Transaction");
        user.setStatus(1);
        user.setGmtCreate(new Date());

        userService.saveError(user);
        return JsonResult.ok(user, "事务回滚");
    }
}
