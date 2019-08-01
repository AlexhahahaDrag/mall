package com.alex.db.service;

import com.alex.db.dao.LitemallRoleMapper;
import com.alex.db.domain.LitemallRole;
import com.alex.db.domain.LitemallRoleExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author:     alex
 * @CreateDate: 2019/8/1 17:04
 * @Version:    1.0
 *
*/
@Service
public class LitemallRoleService {

    @Resource
    private LitemallRoleMapper roleMapper;

    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<>();
        if (roleIds.length == 0)
            return roles;
        LitemallRoleExample example = new LitemallRoleExample();
        example.or().andIdIn(Arrays.asList(roleIds)).andEnabledEqualTo(true).andDeletedEqualTo(false);
        List<LitemallRole> roleList = roleMapper.selectByExample(example);
        for (LitemallRole role : roleList)
            roles.add(role.getName());
        return roles;
    }

    public List<LitemallRole> querySelective(String name, Integer page, Integer limit, String sort, String order) {
        LitemallRoleExample example = new LitemallRoleExample();
        LitemallRoleExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name))
            criteria.andNameLike("%" + name + "%");
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order))
            example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(page, limit);
        return roleMapper.selectByExample(example);
    }

    public LitemallRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void add(LitemallRole role) {
        role.setAddTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.insertSelective(role);
    }

    public void deleteById(Integer id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    public void updateById(LitemallRole role) {
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public boolean checkExists(String name) {
        LitemallRoleExample example = new LitemallRoleExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return roleMapper.countByExample(example) != 0;
    }

    public List<LitemallRole> queryAll() {
        LitemallRoleExample example = new LitemallRoleExample();
        example.or().andDeletedEqualTo(false);
        return roleMapper.selectByExample(example);
    }
}
