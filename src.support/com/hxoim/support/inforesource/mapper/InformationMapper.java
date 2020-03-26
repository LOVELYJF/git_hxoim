package com.hxoim.support.inforesource.mapper;

import com.hxoim.support.inforesource.entity.InfoResource;
import com.hxoim.support.inforesource.entity.Information;

import java.util.List;

public interface InformationMapper {

    void insertColumn(Information information);

    void insertInformation(Information information);

    void updateColumn(Information information);

    void updateInformation(Information information);

    void dropColumn(Information information);

    void deleteInformation(Information information);

    /**
     * description:验证列名是否存在
     * create by: 张乾
     * createDate: 2019/5/28 11:23
     */
    int selectColumnName(Information information) ;

    List<Information> selectInformation(String tableName);

    String selectOldColumnName(String id);

    void insertInformationId(Information information);

    void insertInformationModifyUser(Information information);

    void insertInformationModifyTime(Information information);

    void sortInformations(Information information);

    Integer selectMaxOrderindex(Information information);
}
