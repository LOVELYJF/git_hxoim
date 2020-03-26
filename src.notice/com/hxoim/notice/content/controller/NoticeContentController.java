package com.hxoim.notice.content.controller;

import com.hxoim.common.utils.RequestList;
import com.hxoim.common.utils.Result;
import com.hxoim.notice.content.entity.NoticeContent;
import com.hxoim.notice.content.service.NoticeContentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import java.util.List;

/**
 * 通知公告内容设置
 *
 * @author sunqian
 * @date 2019/9/19 14:22
 */
@RestController
@RequestMapping("/noticeContent")
public class NoticeContentController {

    @Resource
    private NoticeContentService noticeContentService;

    /**
     * 新增或者更新通知内容
     *
     * @author sunqian
     * @date 2019/9/19 14:23
     */
    @RequestMapping("/insertOrUpdateContent")
    public Result insertOrUpdateContent(NoticeContent noticeContent, boolean isInsert) {
        String id = noticeContentService.insertOrUpdateContent(noticeContent, isInsert);
        return Result.success(id);
    }

    /**
     * 根据栏目id查询内容
     *
     * @author sunqian
     * @date 2019/9/19 16:55
     */
    @RequestMapping("/selectContentByColumnId")
    public Result selectContentByColumnId(String columnId) {
        List<NoticeContent> list = noticeContentService.selectContentByColumnId(columnId);
        return Result.success(list);
    }

    /**
     * 根据主键查询发布内容
     * 
     * @author sunqian
     * @date 2019/9/24 17:50
     */
    @RequestMapping("/selectContentPrimaryKey")
    public Result selectContentPrimaryKey(String id) {
        NoticeContent noticeContent = noticeContentService.selectContentPrimaryKey(id);
        return Result.success(noticeContent);
    }

    /**
     * 保存排序
     * 
     * @author sunqian
     * @date 2019/9/25 10:38
     */
    @RequestMapping("/saveSortContent")
    public Result saveSortContent(RequestList<NoticeContent> requestList){
        List<NoticeContent> list = requestList.getList(NoticeContent.class);
        noticeContentService.saveSortContent(list);
        return Result.success();
    }

    /**
     * 根据主键删除发布内容
     * 
     * @author sunqian
     * @date 2019/9/25 11:27
     */
    @RequestMapping("/deleteNoticeContentPrimaryKey")
    public Result deleteNoticeContentPrimaryKey(String id) {
        noticeContentService.deleteNoticeContentPrimaryKey(id);
        return Result.success();
    }

    /**
     * 根据主键更新状态(置顶、发布等)
     * 
     * @author sunqian
     * @date 2019/9/25 15:24
     */
    @RequestMapping("/updateStatusByType")
    public Result updateStatusByType(String id, String value, String type){
        noticeContentService.updateStatusByType(id, value, type);
        return Result.success();
    }

    /**
     * 根据关键字查询
     *
     * @author sunqian
     * @date 2019/9/25 18:29
     *
     */
    @RequestMapping("/selectNoticeContentListByKeyWord")
    public Result selectNoticeContentListByKeyWord(String keyWord, String publishValue){
        List<NoticeContent> list = noticeContentService.selectNoticeContentListByKeyWord(keyWord, publishValue);
        return Result.success(list);
    }
}
