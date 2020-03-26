package com.hxoim.support.sysdict.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.tree.Tree;
import com.hxoim.common.tree.TreeUtil;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.support.sysdict.entity.SysDictItem;
import com.hxoim.support.sysdict.mapper.SysDictItemMapper;
import com.hxoim.support.sysdict.service.SysDictItemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description：字典管理映射service实现类
 * @author ：张乾
 * @createDate ： 2019/5/27 16:22
 */
@Service
public class SysDictItemServiceImpl implements SysDictItemService {

    @Autowired
    private SysDictItemMapper sysDictItemMapper;

    /**
     * 添加字典映射表信息
     */
    @Override
    public void insertSysDictItem(SysDictItem sysDictItem) {
        CheckInput(sysDictItem);
        sysDictItem.setId(UUIDGenerator.getPrimaryKey());
        sysDictItem.setTimeStamp(String.valueOf(System.currentTimeMillis()));
        Integer maxOrderIndex = sysDictItemMapper.selectMAXOrderIndex();
        if (maxOrderIndex == null) {
            maxOrderIndex = Integer.valueOf(1);
            sysDictItem.setOrderindex(maxOrderIndex);
        } else {
            maxOrderIndex += 1;
            sysDictItem.setOrderindex(maxOrderIndex);
        }
        sysDictItemMapper.insertSysDictItem(sysDictItem);
    }

    /**
     * 修改字典映射表信息
     */
    @Override
    public void updateSysDictItem(SysDictItem sysDictItem) {
        CheckInput(sysDictItem);
        sysDictItem.setModifyTime(new Date());
        sysDictItem.setModifyUser(UserInfoUtil.getUserInfo().getId());
        sysDictItemMapper.updateSysDictItem(sysDictItem);
    }
    /**
     * @description:检查必输项及字典编码重复
     * @author:杨波
     * @date:2019-07-27
     *  * @param SysDictItem sysDictItem
     * @return:void
     **/
    private void CheckInput(SysDictItem sysDictItem){
        if(sysDictItem==null){
            throw new ParameterNullException("参数不能为空");
        }
        if(StringUilt.stringIsNullOrEmpty(sysDictItem.getItemCode())){
            throw new ParameterNullException("字典项编码不能为空");
        }
        if(StringUilt.stringIsNullOrEmpty(sysDictItem.getItemName())){
            throw new ParameterNullException("字典项名称不能为空");
        }
        if(StringUilt.stringIsNullOrEmpty(sysDictItem.getDictCode())){
            throw new ParameterNullException("字典不能为空");
        }
        int count=sysDictItemMapper.doubleItemCode(sysDictItem);
        if(count>0)
        {
            throw new ParameterNullException("字典项编码重复");
        }
    }

    /**
     * 删除字典映射表信息
     */
    @Override
    public void deleteSysDictItem(SysDictItem sysDictItem) {
        if(sysDictItem==null){
            throw new ParameterNullException("删除内容不能为空");
        }
        //通过id查询code
        SysDictItem item = sysDictItemMapper.selectItemCodeById(sysDictItem.getId());
        this.selectItemByCode(item);
    }

    /**
     * 递归查询子code并删除
     */
    public void selectItemByCode(SysDictItem sysDictItem) {
        //通过Code查询子code
        List<SysDictItem> itemList = sysDictItemMapper.selectCodeByPcode(sysDictItem);
        //删除自己
        sysDictItemMapper.deleteSysDictItem(sysDictItem);
        if (itemList != null) {
            for (SysDictItem item : itemList) {
                selectItemByCode(item);
            }
        }
    }

    /**
     * 同级排序
     */
    @Override
    public void sortByOrderIndex(String ids) {
        if(StringUtils.isBlank(ids)){
            throw new ParameterNullException("排序参数不能为空");
        }
        String[] idArray = ids.split(",");
            sysDictItemMapper.sortByOrderIndex(idArray);
    }

    /**
     * description: 通过父级code查询下级映射信息
     * create by: 张乾
     * createDate: 2019/5/29 16:40
     */
    @Override
    public List<SysDictItem> selectDictItemByPCode(SysDictItem sysDictItem) {
        if(sysDictItem==null){
            throw new ParameterNullException("编码不能为空");
        }
        return sysDictItemMapper.selectDictItemByPCode(sysDictItem);
    }

    /**
     * @ description: 查询字典映射树
     * @ create by: 张乾
     * @ createDate: 2019/6/18 15:57
     */
    @Override
    public List<Tree> selectItemTree(SysDictItem sysDictItem) {
        if(sysDictItem==null){
            throw new ParameterNullException("字典不能为空");
        }
        return TreeUtil.listToTreeJson(sysDictItemMapper.selectItemTree(sysDictItem));
    }

    /**
     * @ description: 通过code查询信息
     * @ create by: 张乾
     * @ createDate: 2019/6/18 16:48
     */
    @Override
    public SysDictItem selectItemAllById(String id) {
        if(StringUtils.isBlank(id)){
            throw new ParameterNullException("字典不能为空");
        }
        return sysDictItemMapper.selectItemAllById(id);
    }

    /**
     * @ description: 根据dictCode查询字典映射信息
     * @ create by: 张乾
     * @ createDate: 2019/6/24 18:27
     */
    @Override
    public List<Tree> selectItemByDictCode(String dictCode) {
        if(StringUtils.isBlank(dictCode)){
            throw new ParameterNullException("字典不能为空");
        }
        return TreeUtil.listToTreeJson(sysDictItemMapper.selectItemByDictCode(dictCode));
    }

    @Override
    public List<Map<String, Object>> getDictInfoByDictCode(String dictCode, String itemCode) {
        if (StringUtils.isEmpty(dictCode)){
            throw new ParameterNullException("参数错误");
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("dict_code", dictCode);
        params.put("item_code", itemCode);
        List<Map<String, Object>> list = sysDictItemMapper.getDictInfoByDictCode(params);
        return list;
    }
}
