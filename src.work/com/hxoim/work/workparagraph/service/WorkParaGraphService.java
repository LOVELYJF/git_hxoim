package com.hxoim.work.workparagraph.service;

import com.hxoim.work.workparagraph.entity.WorkParaGraph;

import java.util.List;
import java.util.Map;

public interface WorkParaGraphService {
    /**
    * @Author: jiayiwen
    * @Description: 查询状态为进行中的事项
    * @Date: 11:15 2019/12/30
     */
    Map<String,Object> selectWorkParagraph(Integer pageNum, Integer pageSize,String workTitle,String startTime);



    /**
    * @Author: jiayiwen
    * @Description:通过id查询事项详情
    * @Date: 11:15 2019/12/30
     */
    WorkParaGraph selectWorkParagraphById(String id);



    /**
    * @Author: jiayiwen
    * @Description:转办
    * @Date: 11:15 2019/12/30
     */
    void insertWorkParagraph(WorkParaGraph workParaGraph,String pid);



    /**
    * @Author: jiayiwen
    * @Description: 查询状态为已完成的事项
    * @Date: 11:15 2019/12/30
     */
    Map<String,Object>  selectWorkParagraphByStatus(Integer pageNum, Integer pageSize,String workTitle, String startTime);
  /**
  * @Author: jiayiwen
  * @Description: 查询责任人列表
  * @Date: 14:35 2019/12/31
   */
  List<Map<String,Object>> selectTodoPersonList(String id);

    /**
     * @Author: jiayiwen
     * @Description:修改完成情况
     * @Date: 9:23 2020/1/2
     */
    void updateFinishdescById(String id, String finishiedesc);
}
