package com.hxoim.support.dataInterfaceAccess.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.support.dataInterfaceAccess.entity.DataInterfaceAccessLog;
import com.hxoim.support.dataInterfaceAccess.mapper.DataInterfaceAccessLogMapper;
import com.hxoim.support.dataInterfaceAccess.service.DataInterfaceAccessService;
import com.hxoim.support.dataServeAuth.entity.DataServeAuthVO;
import com.hxoim.support.dataServeAuth.mapper.DataServeAuthMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class DataInterfaceAccessServiceImpl implements DataInterfaceAccessService {

    @Autowired
    private DataInterfaceAccessLogMapper dataInterfaceAccessLogMapper;

    @Autowired
    private DataServeAuthMapper dataServeAuthMapper;

    @Override
    public String selectDataInterfaceAccess(DataInterfaceAccessLog dataInterfaceAccessLog) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("serveUsername",dataInterfaceAccessLog.getServeUsername());
        map.put("serveIp",dataInterfaceAccessLog.getServeIp());
        map.put("dataInterface",dataInterfaceAccessLog.getInterfaceAccessName());

        //查询接口定义的sql
        DataServeAuthVO dataServeAuthVO =dataServeAuthMapper.selectDataInterfaceByParam(map);
        if(dataServeAuthVO == null){
            return "此服务未分配该接口访问权限";
        }
        if(dataServeAuthVO.getDataInterfaceStatus().equals("1")){
            return "该接口已停用，暂停访问";
        }
        if(dataInterfaceAccessLog.getInterfaceAccessType().equals("0")){
            return dataServeAuthVO.getDataDesc();
        }
        //拼接sql
        String sql="select * from ( "+dataServeAuthVO.getDataSql()+" ) a ";
        if(StringUtils.isNotEmpty(dataInterfaceAccessLog.getAccessCondition())){
            sql += " where "+ dataInterfaceAccessLog.getAccessCondition();
        }
        List<Map<String, Object>> resultList = null;
        try {
            resultList = dataInterfaceAccessLogMapper.executeSql(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return "sql查询异常，请检查数据接口定义sql语句及查询条件";
        }
        //记录日志
        dataInterfaceAccessLog.setId(UUIDGenerator.getPrimaryKey());
        dataInterfaceAccessLog.setModifyTime(new Date());
        dataInterfaceAccessLogMapper.insertSelective(dataInterfaceAccessLog);

        return resultList.size()>0 ? JSONArray.parseArray(JSON.toJSONString(resultList)).toJSONString(): "";
    }
}
