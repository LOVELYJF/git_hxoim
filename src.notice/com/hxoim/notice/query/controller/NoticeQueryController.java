package com.hxoim.notice.query.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.notice.content.entity.NoticeContent;
import com.hxoim.notice.query.service.NoticeQueryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 通知公告发布查看
 *
 * @author gaozhenyuan
 * @date 2019/12/16 14:23
 */
@RestController
@RequestMapping("/noticeQuery")
public class NoticeQueryController {

    @Resource
    private NoticeQueryService noticeQueryService;

    /**
     * 根据栏目id查询内容
     *
     * @author gaozhenyuan
     * @date 2019/12/16 14:23
     */
    @RequestMapping("/selectNoticeByQuery")
    public Result selectNoticeByQuery(String columnId) {
        List<NoticeContent> list = noticeQueryService.selectNoticeByQuery(columnId);
        return Result.success(list);
    }

    /**
     * 根据栏目id查询内容
     *
     * @author gaozhenyuan
     * @date 2019/12/16 14:23
     */
    @RequestMapping("/selectNoticeByKeyWord")
    public Result selectNoticeByKeyWord(String keyWord) {
        List<NoticeContent> list = noticeQueryService.selectNoticeByKeyWord(keyWord);
        return Result.success(list);
    }

}
