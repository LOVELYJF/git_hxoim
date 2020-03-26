package com.hxoim.support.dataInterfaceDefinition.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.dataInterfaceDefinition.entity.DataInterfaceDefinition;

import java.util.List;

public interface DataInterfaceDefinitionService {

    public abstract List<DataInterfaceDefinition> selectByInfoResourceId(String infoResourceId);

    public abstract DataInterfaceDefinition selectDataInterfaceDefinitionByKey(String id);

    public abstract int insertDataInterfaceDefinition(DataInterfaceDefinition dataInterfaceDefinition);

    public abstract int updateDataInterfaceDefinition(DataInterfaceDefinition dataInterfaceDefinition);

    public abstract int deleteDataInterfaceDefinition(String id);

    public abstract  boolean updateEnableOrdisableStatus(String id,String status);

    public abstract List<DataInterfaceDefinition> selectUndistributedInterface(String infoResourceIds[],String serveId);

    public abstract String selectTransformDataDesc(String params[]);

    public abstract List<DataInterfaceDefinition> selectDataInterface();

    public abstract List<Tree> selectResourceTree();
}
