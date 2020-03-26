package com.hxoim.support.leaderInfo.controller;

import com.github.pagehelper.PageInfo;
import com.hxoim.common.utils.Result;
import com.hxoim.support.leaderInfo.service.LeaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/leaderInfo")
public class LeaderInfoController {

    @Autowired
    private LeaderInfoService leaderInfoService;

    /**
     * @desc: 根据id查询返回数据
     * @author: sundeng
     * @date: 2019/7/26
     */
    @RequestMapping("/selectBasicInfo")
    public Result selectBasicInfo(Integer pageNum, Integer pageSize,String orgId) {
        Map<String,Object> map = leaderInfoService.selectBasicInfo(pageNum, pageSize, orgId);
        return Result.success(map);
    }

    /**
     * @desc: 查询数据信息集
     * @author: sundeng
     * @date: 2019/7/26
     */
    @RequestMapping("/selectLeaderInfoData")
    public Result getUiSetingWithData(String tablecode, String id) {
        List<Map<String, Object>> a31s = leaderInfoService.selectLeaderInfoData(tablecode, id);
        return Result.success(a31s);
    }
}
