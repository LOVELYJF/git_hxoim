package com.hxoim.notice.query.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.notice.query.service.NoticeQueryLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 通知公告发布查看
 *
 * @author gaozhenyuan
 * @date 2019/12/16 14:23
 */
@RestController
@RequestMapping("/noticeQueryLog")
public class NoticeQueryLogController {

    @Resource
    private NoticeQueryLogService noticeQueryLogService;

    /**
     * 新增浏览记录
     *
     * @author gaozhenyuan
     * @date 2019/12/23 10:23
     */
    @RequestMapping("/insertQueryLog")
    public Result insertQueryLog(HttpServletRequest request,String contentId) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
          //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                ip = ip.substring(0,index);
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            ip = ip;
        }else{
            ip  = request.getRemoteAddr();
        }
        noticeQueryLogService.insertQueryLog(ip,contentId);
        return Result.success();
    }

    /**
     * 获取当前通知公告浏览记录列表
     * @author gaozhenyuan
     * @date 2019/12/23 10:23
     */
    @RequestMapping("/selectNoticeLogByContentId")
    public Result selectNoticeLogByContentId(Integer pageNum, Integer pageSize,String contentId) {
        Map<String,Object> map = noticeQueryLogService.selectNoticeLogByContentId(pageNum, pageSize,contentId);
        return Result.success(map);
    }

}
