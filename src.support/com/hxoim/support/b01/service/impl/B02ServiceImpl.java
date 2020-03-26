package com.hxoim.support.b01.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.common.utils.UtilDateTime;
import com.hxoim.support.b01.entity.B02;
import com.hxoim.support.b01.mapper.B02Mapper;
import com.hxoim.support.b01.service.B02Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ description：机构编制Service实现类
 * @ author：张乾
 * @ createDate ： 2019/6/6 11:01
 */
@Service
public class B02ServiceImpl implements B02Service {

    @Autowired
    private B02Mapper b02Mapper;

    /**
     * @ description: 查询机构编制信息
     * @ create by: 张乾
     * @ createDate: 2019/6/7 16:05
     */
    @Override
    public B02 selectB02Byb0111(String b0111) {
        if(StringUtils.isBlank(b0111)){
            throw new ParameterNullException("机构代码不能为空");
        }
        return b02Mapper.selectB02Byb0111(b0111);
    }

    /**
     * @ description: 编辑编制信息
     * @ create by: 张乾
     * @ createDate: 2019/6/7 17:00
     */
    @Override
    public void updateB02(B02 b02) {
        b02=CheckInput(b02);
        b02Mapper.updateB02(b02);
    }

    /**
     * @ description: 删除编制信息
     * @ create by: 张乾
     * @ createDate: 2019/6/7 17:09
     */
    @Override
    public void deleteB02(String b0111) {
        if(StringUtils.isBlank(b0111)){
            throw new ParameterNullException("机构代码不能为空");
        }
        b02Mapper.deleteB02(b0111);
    }
    /**
     * @ description: 插入编制信息
     * @ create by: 杨波
     * @ createDate: 2019/7/25 09:38
     */
    @Override
    public void insertB02(B02 b02) {
        b02=CheckInput(b02);
        b02Mapper.insertB02(b02);
    }
    private B02 CheckInput(B02 b02)
    {
        if(b02==null){
            throw new ParameterNullException("机构编制信息不能为空");
        }

        b02.setModifyUser(UserInfoUtil.getUserInfo().getId());
        b02.setModifyTime(UtilDateTime.toDateTimeString(new Date()));

        return b02;
    }
}
