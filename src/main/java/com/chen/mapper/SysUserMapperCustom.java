package com.chen.mapper;

import com.chen.common.BaseMapper;
import com.chen.model.SysUser;
import org.springframework.stereotype.Repository;

/**
 * SysUserMapperCustom
 * <p>
 * @Author LeifChen
 * @Date 2018-12-12
 */
@Repository
public interface SysUserMapperCustom extends BaseMapper<SysUser> {

    /**
     * 根据id查询用户的简单信息
     * @param id
     * @return
     */
    SysUser getUserSimpleInfoById(long id);
}