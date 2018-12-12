package com.chen.service;

import com.chen.model.SysUser;

import java.util.List;

/**
 * SysUserService
 * <p>
 * @Author LeifChen
 * @Date 2018-12-12
 */
public interface SysUserService {

    /**
     * 新增
     * @param user 用户
     */
    void save(SysUser user);

    /**
     * 更新
     * @param user 用户
     */
    void update(SysUser user);

    /**
     * 删除
     * @param id 主键
     */
    void delete(long id);

    /**
     * 根据主键查询单个用户
     * @param id 主键
     * @return
     */
    SysUser getById(long id);

    /**
     * 分页查询用户列表
     * @param user     参考用户
     * @param page     页码
     * @param pageSize 每页条数
     * @return
     */
    List<SysUser> listByPage(SysUser user, int page, int pageSize);

    /**
     * 批量新增
     * @param users 用户列表
     */
    void batchInsert(List<SysUser> users);

    /**
     * 事务回滚测试
     * @param user 用户
     */
    void saveError(SysUser user);

    /**
     * 根据id查询用户的简单信息
     * @param id 主键
     * @return
     */
    SysUser getUserSimpleInfoById(long id);
}
