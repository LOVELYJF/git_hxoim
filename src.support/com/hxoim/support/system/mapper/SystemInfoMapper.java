package com.hxoim.support.system.mapper;

import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.UserInfo;
import com.hxoim.support.system.entity.SystemInfo;

import java.util.List;

/**
 * @ description：系统Mapper层
 * @ author：张乾
 * @ createDate ： 2019/5/30 14:49
 */
public interface SystemInfoMapper {

    int deleteByPrimaryKey(String id);

    int insert(SystemInfo record);

    int insertSelective(SystemInfo record);

    SystemInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SystemInfo record);

    int updateByPrimaryKey(SystemInfo record);

    /**
     * @ description: 通过业务系统id查询名称
     * @ create by: 张乾
     * @ createDate: 2019/5/30 15:35
     */
    SystemInfo selectSystemNamePid(String syId);

    /**
     * @ description:查询上级业务系统名称
     * @ create by: 张乾
     * @ createDate: 2019/6/3 9:09
     */
    String selectSystemNameByPid(String syId);

    List<Tree> selectSystemInfoTree();

    /**
     * @Author sunqian
     * @Desc 根据id查询子节点
     * @Date 2019/6/18 15:07
     */
    List<SystemInfo> selectKidsSysInfo(String id);

    Integer selectMaxIndex();
    /**
     * 获取机构具有的系统权限
     * 
     * @author sunqian
     * @date 2019/8/22 13:45
     */
    List<SystemInfo> selectOrgGrantSystemInfo(String orgId);

    List<SystemInfo> selectUserGrantSystemInfo(String userId);
}
