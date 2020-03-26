package com.hxoim.support.leadertype.service;

import com.hxoim.support.inforesource.entity.DataTable;

import java.util.List;

public interface LeaderTypeService {
    /**
     * 当前用户权限所具有的信息集
     *
     * @author sunqian
     * @date 2019/8/21 16:15
     */
    List<DataTable> selectGrantLeaderTypeInfo(String leaderTypeId);
}
