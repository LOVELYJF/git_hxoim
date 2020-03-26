package com.hxoim.kettle.jobandtrans.mapper;

import com.hxoim.kettle.jobandtrans.entity.Transformation;
import com.hxoim.kettle.jobandtrans.entity.TransformationWithBLOBs;
import com.hxoim.kettle.jobandtrans.entity.custom.TransformationCustom;

import java.util.List;
import java.util.Map;

public interface TransformationMapper {
    int deleteByPrimaryKey(Long idTransformation);

    int insert(TransformationWithBLOBs record);

    int insertSelective(TransformationWithBLOBs record);

    TransformationWithBLOBs selectByPrimaryKey(Long idTransformation);

    int updateByPrimaryKeySelective(TransformationWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TransformationWithBLOBs record);

    int updateByPrimaryKey(Transformation record);

    /**
     * @desc: 转换数，运行中转换数
     * @author: lijing
     * @date: 2019/7/12
     */
    Map<String, Object> accountTrans(Map<String, Object> params);

    /**
     * @desc: 转换列表
     * @author: lijing
     * @date: 2019/7/12
     */
    List<TransformationCustom> selectTransList(Map<String, Object> params);

    /**
     * @desc: 该转换是否已经启动
     * @author: lijing
     * @date: 2019/7/16
     */
    int selectIsStartTranByName(String transName);
}