package com.hxoim.support.inforesource.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.inforesource.entity.Information;

import java.util.List;

/**
 * description:信息资源项service层
 * create by: 张乾
 * createDate: 2019/5/29 10:56
 */
public interface InformationService {

    void insertColumn(Information information);

    void updateColumn(Information information);

    void dropColumn(Information information);

    /**
     * description:验证列名是否存在
     * create by: 张乾
     * createDate: 2019/5/28 11:07
     */
    void selectColumnName(Information information);

    List<Information> selectInformation(String tableName);

    /**
     * description: 点击数据字典显示
     * create by: 张乾
     * createDate: 2019/5/29 15:26
     * @return
     */
    List<Tree> selectSysDictItem(String dictCode);

    void sortInformations(String[] ids);
}
