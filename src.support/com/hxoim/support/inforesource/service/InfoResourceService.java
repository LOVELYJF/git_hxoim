package com.hxoim.support.inforesource.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.inforesource.entity.InfoResource;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: 张乾
 * @CreateDate: 2019/5/23$ 19:13$
 */
public interface InfoResourceService {

    /**
     * description:查询信息资源列表
     * create by: 张乾
     * createDate: 2019/5/27 17:00
     */
    InfoResource selectInfoResourceById(InfoResource infoResource);

    void insertInfoResource(InfoResource infoResource);

    void updateInfoResource(InfoResource infoResource);

    void deleteInfoResource(InfoResource infoResource);

    /**
     * description:排序
     * create by: 张乾
     * createDate: 2019/5/28 14:01
     */
    void sortOrderIndex(String[] resourceIds);

    /**
     * description:点击节点查询其下面的所有表
     * create by: 张乾
     * createDate: 2019/5/28 19:45
     */
    List<InfoResource> selectTableByPid(InfoResource infoResource);

    /**
     * @ description: 查询信息资源树
     * @ create by: 张乾
     * @ createDate: 2019/6/4 14:06
     */
    List<Tree> selectInfoResourceTree();

    void selectResourceCode(InfoResource infoResource);

    List<InfoResource> selectResourceType();

    List<InfoResource> selectInfoResourceByType(String resourceType);
}
