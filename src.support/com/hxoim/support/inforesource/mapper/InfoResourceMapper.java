package com.hxoim.support.inforesource.mapper;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.inforesource.entity.InfoResource;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: 张乾
 * @CreateDate: 2019/5/23$ 19:12$
 */
public interface InfoResourceMapper {

    int deleteByPrimaryKey(String id);

    int insert(InfoResource record);

    int insertSelective(InfoResource record);

    InfoResource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InfoResource record);

    int updateByPrimaryKey(InfoResource record);
    /**
     * description:查询信息资源
     * create by: 张乾
     * createDate: 2019/5/28 9:05
     */
    InfoResource selectInfoResourceById(InfoResource infoResource);

    void updateInfoResource(InfoResource infoResource);

    void deleteInfoResource(InfoResource infoResource);

    /**
     * description:排序
     * create by: 张乾
     * createDate: 2019/5/28 14:04
     */
    void sortOrderIndex(InfoResource infoResource);

    /**
     * description:点击节点查询其下面的所有表
     * create by: 张乾
     * createDate: 2019/5/28 19:48
     */
    List<InfoResource> selectTableByPid(InfoResource infoResource);


    /**
     * @ description: 修改表名
     * @ create by: 张乾
     * @ createDate: 2019/6/3 11:24
     */
    void updateTableName(InfoResource infoResource);

    /**
     * @ description: 查询信息资源树
     * @ create by: 张乾
     * @ createDate: 2019/6/4 14:09
     */
    List<Tree> selectInfoResourceTree();

    /**
     * @ description: 删除时查询有没有子节点
     * @ create by: 张乾
     * @ createDate: 2019/6/6 17:21
     */
    int selectCountIdByPid(InfoResource infoResource);

    int selectResourceCode(InfoResource infoResource);

    List<InfoResource> selectResourceType();

    List<InfoResource> selectInfoResourceByType(String resourceType);
}
