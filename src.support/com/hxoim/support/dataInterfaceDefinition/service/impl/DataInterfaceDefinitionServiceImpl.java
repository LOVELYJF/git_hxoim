package com.hxoim.support.dataInterfaceDefinition.service.impl;

import com.hxoim.general.select.mapper.SelectMapper;
import com.hxoim.general.select.entity.SqlVo;
import com.hxoim.common.tree.Tree;
import com.hxoim.common.tree.TreeUtil;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.support.dataInterfaceDefinition.entity.DataInterfaceDefinition;
import com.hxoim.support.dataInterfaceDefinition.mapper.DataInterfaceDefinitionMapper;
import com.hxoim.support.dataInterfaceDefinition.service.DataInterfaceDefinitionService;
import com.hxoim.support.inforesource.entity.DataTableCol;
import com.hxoim.support.inforesource.mapper.DataTableColMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DataInterfaceDefinitionServiceImpl implements DataInterfaceDefinitionService {

    @Autowired
    private DataInterfaceDefinitionMapper dataInterfaceDefinitionMapper;

    @Autowired
    private DataTableColMapper dataTableColMapper;

    @Autowired
    private SelectMapper selectMapper;

    @Override
    public List<DataInterfaceDefinition> selectByInfoResourceId(String infoResourceId) {
        return dataInterfaceDefinitionMapper.selectByInfoResourceId(infoResourceId);
    }

    @Override
    public DataInterfaceDefinition selectDataInterfaceDefinitionByKey(String id) {
        return dataInterfaceDefinitionMapper.selectById(id);
    }

    @Override
    public int insertDataInterfaceDefinition(DataInterfaceDefinition dataInterfaceDefinition) {
        dataInterfaceDefinition.setId(UUIDGenerator.getPrimaryKey());
        dataInterfaceDefinition.setModifyUser(UserInfoUtil.getUserInfo().getId());
        dataInterfaceDefinition.setModifyTime(new Date());
        return dataInterfaceDefinitionMapper.insertSelective(dataInterfaceDefinition);
    }

    @Override
    public int updateDataInterfaceDefinition(DataInterfaceDefinition dataInterfaceDefinition) {
        dataInterfaceDefinition.setModifyUser(UserInfoUtil.getUserInfo().getId());
        dataInterfaceDefinition.setModifyTime(new Date());
        return dataInterfaceDefinitionMapper.updateSelective(dataInterfaceDefinition);
    }

    @Override
    public int deleteDataInterfaceDefinition(String id) {
        return dataInterfaceDefinitionMapper.deleteById(id);
    }

    @Override
    public boolean updateEnableOrdisableStatus(String id, String status) {
        boolean flag = false;
        DataInterfaceDefinition dataInterfaceDefinition =this.selectDataInterfaceDefinitionByKey(id);
        if(dataInterfaceDefinition != null){
            dataInterfaceDefinition.setStatus(status);
            this.updateDataInterfaceDefinition(dataInterfaceDefinition);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<DataInterfaceDefinition> selectUndistributedInterface(String infoResourceIds[],String serveId) {
        return dataInterfaceDefinitionMapper.selectUndistributedInterface(infoResourceIds,serveId);
    }

    @Override
    public String selectTransformDataDesc(String[] params) {
        List<DataTableCol> dataTableColList =dataTableColMapper.selectDataTableColByIds(params);
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<Fields>");
        for(DataTableCol dataTableCol:dataTableColList){
            sb.append("\n\t<Field>");
            sb.append("\n\t\t<EnglishName>"+dataTableCol.getColCode()+"</EnglishName>");
            sb.append("\n\t\t<ChineseName>"+dataTableCol.getColName()+"</ChineseName>");
            sb.append("\n\t\t<Description>"+dataTableCol.getColNameShow()+"</Description>");
            sb.append("\n\t\t<DataType>"+dataTableCol.getDataType()+"</DataType>");
            sb.append("\n\t\t<DataLength>"+dataTableCol.getLength1()+"</DataLength>");
            sb.append("\n\t\t<Precision>"+dataTableCol.getDecimalPlace()+"</Precision>");
            sb.append("\n\t\t<Dictionary>"+dataTableCol.getDicCode()+"</Dictionary>");
            sb.append("\n\t<Field>");
        }
        sb.append("\n</Fields>");
//        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public List<DataInterfaceDefinition> selectDataInterface() {
        return dataInterfaceDefinitionMapper.selectDataInterface();
    }

    @Override
    public List<Tree> selectResourceTree() {
        String sql = "select m.id,m.pid,m.label from (\n" +
                "select id,pid,resource_name as label, orderindex  from info_resource \n" +
                "union all\n" +
                "select id,CatalogId as pid,TAB_NAME as label,ORDER_INDEX  as orderindex from data_table where is_deleted=0 ) m order by m.orderindex\n";
        SqlVo sqlVo = SqlVo.getInstance(sql);
        List<Tree> trees = TreeUtil.listToTreeJson(selectMapper.selectTree(sqlVo));
        return trees;
    }

}
