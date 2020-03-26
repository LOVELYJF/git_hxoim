package com.hxoim.work.workparagraph.controller;


import com.hxoim.common.utils.Result;

import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.work.workparagraph.entity.WorkParaGraph;
import com.hxoim.work.workparagraph.service.WorkParaGraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workParaGraph")
public class WorkParaGraphController {

    @Autowired
    private WorkParaGraphService workParaGraphService;

    /**
    * @Author: jiayiwen
    * @Description: 查询状态为进行中的事项
    * @Date: 11:10 2019/12/30
     */
    @RequestMapping("/selectWorkParagraph")
    public Result selectWorkParagraph(Integer pageNum, Integer pageSize,String workTitle,String startTime){
        //查询状态为进行中的事项
        Map<String,Object> map  = workParaGraphService.selectWorkParagraph(pageNum,pageSize,workTitle,startTime);
        return Result.success(map);
    }

    /**
    * @Author: jiayiwen
    * @Description: 通过id查询事项详情
    * @Date: 11:10 2019/12/30
     */
    @RequestMapping("/selectWorkParagraphById")
    public  Result  selectWorkParagraphById(String id){
        WorkParaGraph workParaGraph=workParaGraphService.selectWorkParagraphById(id);
        return Result.success(workParaGraph);
    }
    /**
    * @Author: jiayiwen
    * @Description:查询责任人列表
    * @Date: 14:32 2019/12/31
     */
    @RequestMapping("/selectTodoPersonList")
    public Result selectTodoPersonList(String id){
        List<Map<String,Object>> list  = workParaGraphService.selectTodoPersonList(id);
        return Result.success(list);
    }

    /**
    * @Author: jiayiwen
    * @Description: 转办
    * @Date: 11:10 2019/12/30
     */
    @RequestMapping("/insertWorkParagraph")
    public Result insertWorkParagraph(WorkParaGraph WorkParaGraph,String pid){
        workParaGraphService.insertWorkParagraph(WorkParaGraph,pid);
        return Result.success();
    }
     /**
     * @Author: jiayiwen
     * @Description: 查询状态为已完成的事项
     * @Date: 11:11 2019/12/30
      */
    @RequestMapping("/selectWorkParagraphByStatus")
    public Result selectWorkParagraphByStatus(Integer pageNum, Integer pageSize,String workTitle,String startTime){
        //查询状态为已完成的事项
        Map<String,Object> map  = workParaGraphService.selectWorkParagraphByStatus(pageNum,pageSize,workTitle,startTime);
        return Result.success(map);
    }

    /**
    * @Author: jiayiwen
    * @Description:查询发起人
    * @Date: 9:21 2020/1/2
     */

    @RequestMapping("/selectUserById")
    public  Result  selectUserById(){
        String userId = UserInfoUtil.getUserInfo().getId();
        String userName = UserInfoUtil.getUserInfo().getName();
        Map<String,String> map = new HashMap<>();
        map.put("userId",userId);
        map.put("userName",userName);
        return Result.success(map);
    }

    /**
    * @Author: jiayiwen
    * @Description:修改当前责任人的完成情况
    * @Date: 8:57 2020/1/3
     */
    @RequestMapping("/updateFinishdescById")
    public  Result  updateFinishdescById(String id ,String finishiedesc){
        workParaGraphService.updateFinishdescById(id,finishiedesc);
        return Result.success();
    }
}
