package com.hxoim.support.inforesource.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.tree.Tree;
import com.hxoim.common.tree.TreeUtil;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.common.utils.UtilDateTime;
import com.hxoim.support.inforesource.entity.Information;
import com.hxoim.support.inforesource.mapper.InformationMapper;
import com.hxoim.support.inforesource.service.InformationService;
import com.hxoim.support.sysdict.mapper.SysDictItemMapper;
import com.hxoim.support.sysdict.mapper.SysDictMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @description：信息资源项service实现类
 * @author ：张乾
 * @createDate ： 2019/5/29 10:57
 */
@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationMapper informationMapper;

    @Autowired
    private SysDictMapper sysDictMapper;

    @Autowired
    private SysDictItemMapper sysDictItemMapper;

    /**
     * 方法实现说明    新建表添加列,同时给信息项添加数据
     * @author      张乾
     * @date        2019/5/24 13:34
     */
    @Override
    @Transactional
    public void insertColumn(Information information) {
        if(information==null){
            throw new ParameterNullException("添加内容不能为空");
        }
            selectColumnName(information);
            Integer max=informationMapper.selectMaxOrderindex(information);
            if(max==null){
                information.setOrderindex(1);
            }else{
                information.setOrderindex(max);
            }
            information.setId(UUIDGenerator.getPrimaryKey());
            informationMapper.insertColumn(information);
            informationMapper.insertInformation(information);
    }

    /**
     * description:验证列名是否存在
     * create by: 张乾
     * createDate: 2019/5/28 11:08
     */
    @Override
    public void selectColumnName(Information information){
        if(information==null){
            throw new ParameterNullException("列名不能为空");
        }
        int count= informationMapper.selectColumnName(information);
        if(count>0){
            throw new ParameterNullException(information.getEnglishName()+"列名已存在");
        }
    }

    /**
     * description:修改列,修改信息项
     * create by: 张乾
     * createDate: 2019/5/28 9:43
     */
    @Override
    @Transactional
    public void updateColumn(Information information) {
        if(information==null){
            throw new ParameterNullException("保存内容不能为空");
        }
        selectColumnName(information);
        String oldEnglisnName=informationMapper.selectOldColumnName(information.getId());
        information.setOldEnglishName(oldEnglisnName);
        information.setModifyUser(UserInfoUtil.getUserInfo().getId());
        information.setModifyTime(UtilDateTime.toDateTimeString(new Date()));
        informationMapper.updateColumn(information);
        informationMapper.updateInformation(information);
    }

    /**
     * description:删除列
     * create by: 张乾
     * createDate: 2019/5/28 10:46
     */
    @Override
    @Transactional
    public void dropColumn(Information information) {
        if(information==null){
            throw new ParameterNullException("删除内容不能为空");
        }
            informationMapper.dropColumn(information);
            informationMapper.deleteInformation(information);
    }

    /**
     * description: 点击信息项维护显示页面
     * create by: 张乾
     * createDate: 2019/5/29 15:10
     */
    @Override
    public List<Information> selectInformation(String tableName) {
        if(StringUtils.isBlank(tableName)){
            throw new ParameterNullException("表名不能为空");
        }
        return informationMapper.selectInformation(tableName);
    }

    /**
     * description: 点击数据字典显示
     * create by: 张乾
     * createDate: 2019/5/29 15:26
     * @return
     */
    @Override
    public List<Tree> selectSysDictItem(String dictCode) {
        if(StringUtils.isBlank(dictCode)){
            throw new ParameterNullException("字典编码不能为空");
        }
        return TreeUtil.listToTreeJson(sysDictItemMapper.selectSysDictItem(dictCode));
    }

    /**
     * @ description: 排序
     * @ create by: 张乾
     * @ createDate: 2019/6/13 11:17
     */
    @Override
    public void sortInformations(String[] ids) {
        if(ids==null||ids.length==0){
            throw new ParameterNullException("排序字段不能为空");
        }
        for(int i=0;i<ids.length;i++){
            Information information=new Information();
            information.setId(ids[i]);
            information.setOrderindex(i+1);
            informationMapper.sortInformations(information);
        }
    }
}
