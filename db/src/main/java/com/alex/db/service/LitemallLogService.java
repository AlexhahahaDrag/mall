package com.alex.db.service;

import com.alex.db.dao.LitemallLogMapper;
import com.alex.db.domain.LitemallLog;
import com.alex.db.domain.LitemallLogExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:
 * @Author:     alex
 * @CreateDate: 2019/8/5 11:55
 * @Version:    1.0
 *
*/
@Service
public class LitemallLogService {

    @Resource
    private LitemallLogMapper logMapper;

    public void deleteById(Integer id) {
        logMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LitemallLog litemallLog) {
        litemallLog.setAddTime(LocalDateTime.now());
        litemallLog.setUpdateTime(LocalDateTime.now());
        logMapper.insertSelective(litemallLog);
    }

    public List<LitemallLog> querySelective(String name, Integer page, Integer size, String sort, Integer order) {
        LitemallLogExample example = new LitemallLogExample();
        LitemallLogExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name))
            criteria.andAdminLike("%" + name + "%");
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order))
            example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(page, size);
        return  logMapper.selectByExample(example);
    }
}


