package com.chen.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用Mapper工具类
 * <p>
 * @Author LeifChen
 * @Date 2018-12-12
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>{
}
