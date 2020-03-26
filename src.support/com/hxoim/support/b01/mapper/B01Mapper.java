package com.hxoim.support.b01.mapper;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.b01.entity.B01;

import java.util.List;

/**
 * @Description: 机构mapper接口
 * @Author: 张乾
 * @CreateDate: 2019/5/22$ 17:53$
 */
public interface B01Mapper {

    /**
     * description:查询机构
     * create by: 张乾
     * createDate: 2019/5/27 17:05
     */
    List<B01> selectAllB01();

    /**
     * 根据机构id查询机构树(机构授权使用)
     * 
     * @author sunqian
     * @date 2019/8/22 15:43
     */
    List<Tree> selectOrgGrantTree(String orgId);

    void updateOrg(B01 b01);

    void insertOrg(B01 b01);

    List<B01> selectOrg(B01 b01);

    void deleteOrg(String b0111);

    /**
     * @ description: 查询下级机构
     * @ create by: 张乾
     * @ createDate: 2019/6/5 15:53
     */
    int selectOrgByPid(String b0111);

    /**
     * @ description: 排序
     * @ create by: 张乾
     * @ createDate: 2019/6/5 16:25
     */
    void sortOrg(String[] array);

    List<B01> selectOrgById(B01 b01);

    B01 selectOrgByB0111(String b0111);

    /**
     * @ description: 获得下一个b0111
     * @ create by: 张乾
     * @ createDate: 2019/6/20 15:50
     */
    String getNextOrgCode(String pid);

    /**
     * @desc: 查询所有机构
     * @author: lijing
     * @date: 2019/7/24
     */
    List<B01> selectOrgAllList();

    /**
    * @description:判断是否有重复的机构名称
    * @author:杨波
    * @date:2019-07-27
    *  * @param B01 b01
    * @return:
    **/
    int doubleOrgName(B01 b01);

    /**
     * @description:判断是否有重复的机构编码
     * @author:杨波
     * @date:2019-07-27
     *  * @param B01 b01
     * @return:
     **/
    int doubleOrgCode(B01 b01);

    /**
     * 查询用户的机构权限
     *
     * @author sunqian
     * @date 2019/8/22 15:57
     */
    List<Tree> selectUserGrantTree(String userId);

    List<Tree> selectAllOrgTree();
}
