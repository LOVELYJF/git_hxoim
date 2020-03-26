package com.hxoim.support.sysdict.mapper;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.sysdict.entity.SysDictItem;

import java.util.List;
import java.util.Map;

/**
 * @description：字典管理映射类Mapper接口
 * @author ：张乾
 * @createDate ： 2019/5/27 16:22
 */
public interface SysDictItemMapper {

    void insertSysDictItem(SysDictItem sysDictItem);

    /**
     * description:查询最大的排序字段值
     * create by: 张乾
     * createDate: 2019/5/27 16:31
     */
    Integer selectMAXOrderIndex();

    void updateSysDictItem(SysDictItem sysDictItem);

    void deleteSysDictItem(SysDictItem sysDictItem);

    /**
     * description:通过id查询code
     * create by: 张乾
     * createDate: 2019/5/27 16:33
     */
    SysDictItem selectItemCodeById(String itemId);

    /**
     * description:通过pid查询子id
     * create by: 张乾
     * createDate: 2019/5/27 16:36
     */
    List<SysDictItem> selectCodeByPcode(SysDictItem sysDictItem);

    /**
     * description:通过字典管理code查询映射code
     * create by: 张乾
     * createDate: 2019/5/27 16:38
     */
    List<SysDictItem> selectItemCodeByDictCode(String dictCode);

    /**
     * description:排序
     * create by: 张乾
     * createDate: 2019/5/27 16:39
     */
    void sortByOrderIndex(String[] array);

    /**
     * description: 点击资源信息项页面数据字典显示
     * create by: 张乾
     * createDate: 2019/5/29 15:31
     * @return
     */
    List<Tree> selectSysDictItem(String dictCode);

    /**
     * description: 通过父级code查询下级映射信息
     * create by: 张乾
     * createDate: 2019/5/29 16:40
     */
    List<SysDictItem> selectDictItemByPCode(SysDictItem sysDictItem);

    List<Tree> selectItemTree(SysDictItem sysDictItem);

    SysDictItem selectItemAllById(String id);

    void deleteItemByDictCode(String dictCode);

    List<Tree> selectItemByDictCode(String dictCode);
    /**
    * @description:判断字典编码是否重复
    * @author:杨波
    * @date:2019-07-27
    *  * @param SysDictItem sysDictItem
    * @return:
    **/
    int doubleItemCode(SysDictItem sysDictItem);

    /**
     * @desc: 查询字典树
     * @author: lijing
     * @date: 2019/8/8
     */
    List<Map<String,Object>> getDictInfoByDictCode(Map<String,String> params);

    /**
     * 根据dictCode查询字典项列表(is_use=1)
     *
     * @author sunqian
     * @date 2019/8/27 14:12
     */
    List<SysDictItem> selectSysdictItemListByDictCode(String dictCode);
}
