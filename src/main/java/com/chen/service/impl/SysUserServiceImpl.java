package com.chen.service.impl;

import com.chen.mapper.SysUserMapper;
import com.chen.model.SysUser;
import com.chen.service.SysUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * SysUserServiceImpl
 * <p>
 * @Author LeifChen
 * @Date 2018-12-12
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private final SysUserMapper userMapper;

    public SysUserServiceImpl(SysUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void save(SysUser user) {
        userMapper.insert(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void update(SysUser user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void delete(long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.SUPPORTS)
    public SysUser getById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.SUPPORTS)
    public List<SysUser> listByPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        Example example = new Example(SysUser.class);
        example.orderBy("gmtCreate").asc();
        return userMapper.selectByExample(example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void batchInsert(List<SysUser> users) {
        userMapper.insertList(users);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void saveError(SysUser user) {
        userMapper.insert(user);

        int a = 1 / 0;

        user.setStatus(0);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
