package com.hxoim.full.search.mapper;

import com.hxoim.common.tree.Tree;
import com.hxoim.full.search.entity.FullSearchSetting;
import com.hxoim.full.search.entity.PersonInfoResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FullSearchSettingMapper {
    int deleteByPrimaryKey(String id);

    int insert(FullSearchSetting record);

    int insertSelective(FullSearchSetting record);

    FullSearchSetting selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FullSearchSetting record);

    int updateByPrimaryKey(FullSearchSetting record);

    /**
     * 人员基本信息集列表
     *
     * @author sunqian
     * @date 2019/11/6 15:37
     */
    List<Tree> selectPersonTableList();

    /**
     * 人员基本信息集对应的列信息
     *
     * @author sunqian
     * @date 2019/11/6 15:43
     */
    List<Map<String, Object>> selectColumnListByTabCode(String tabCode);

    /**
     * 索引列
     *
     * @author sunqian
     * @date 2019/11/6 15:37
     */
    List<String> selectIndexColumnByTabCode(String tabCode);

    List<FullSearchSetting> selectColumnInfo(@Param("tabCode") String tabCode, @Param("list") List<String> colList);

    void deleteByTabCode(String tabCode);

    void insertBatch(List<FullSearchSetting> list);

    List<Map<String, Object>> executeSelectSql(String sql);

    List<FullSearchSetting> selectIndexColumn(String tabCode);

    String[] selectTabCodes();

    List<Map<String, Object>> selectPersonInfo(List<PersonInfoResult> personInfoResultList);
}