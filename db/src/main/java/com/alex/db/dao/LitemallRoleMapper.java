package com.alex.db.dao;

import com.alex.db.domain.LitemallRole;
import com.alex.db.domain.LitemallRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author:     alex
 * @CreateDate: 2019/8/1 16:48
 * @Version:    1.0
 *
*/
public interface LitemallRoleMapper {

    long countByExample(LitemallRoleExample example);

    int deleteByExample(LitemallRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallRole record);

    int insertSelective(LitemallRole record);

    LitemallRole selectOneByExample(LitemallRoleExample example);

    LitemallRole selectOneByExampleSelective(@Param("example") LitemallRoleExample example, @Param("selective") LitemallRole.Column ... selective);

    List<LitemallRole> selectByExampleSelective(@Param("example") LitemallRoleExample example, @Param("selective") LitemallRole.Column ... selective);

    List<LitemallRole> selectByExample(LitemallRoleExample example);

    LitemallRole selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallRole.Column ... selective);

    LitemallRole selectByPrimaryKey(Integer id);

    LitemallRole selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSeletive(@Param("record") LitemallRole record, @Param("example") LitemallRoleExample example);

    int updateByExample(@Param("record") LitemallRole record, @Param("example") LitemallRoleExample example);

    int updateByPrimaryKeySelective(LitemallRole record);

    int updateByPrimaryKey(LitemallRole record);

    int logicalDeleteByExample(@Param("example") LitemallRoleExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}
