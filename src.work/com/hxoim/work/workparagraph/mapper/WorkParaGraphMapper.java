package com.hxoim.work.workparagraph.mapper;

import com.hxoim.support.indexTemp.entity.IndexTemp;
import com.hxoim.work.workparagraph.entity.WorkParaGraph;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WorkParaGraphMapper {

    List<WorkParaGraph> selectWorkParagraph(Map<String,String> parm);

    WorkParaGraph selectWorkParagraphById(String id);


    int insertSelective(WorkParaGraph record);

    List<WorkParaGraph> selectWorkParagraphByStatus(Map<String,String> parm);

    List<Map<String,Object>> selectTodoPersonList(String id);

    void updateFinishdescById(@Param("id") String id, @Param("finishiedesc") String finishiedesc);
}
