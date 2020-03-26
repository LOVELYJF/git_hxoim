package com.hxoim.notice.content.mapper;

import com.hxoim.notice.content.entity.NoticeContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 内容设置mapper接口
 *
 * @author sunqian
 * @date 2019/9/12 10:52
 */
public interface NoticeContentMapper {
    int deleteByPrimaryKey(String id);

    int insert(NoticeContent record);

    int insertSelective(NoticeContent record);

    NoticeContent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NoticeContent record);

    int updateByPrimaryKeyWithBLOBs(NoticeContent record);

    int updateByPrimaryKey(NoticeContent record);

    List<NoticeContent> selectContentByColumnId(Map<String,String> map);

    NoticeContent selectByPrimaryKeyNoContent(String id);

    /**
     * 保存排序
     *
     * @author sunqian
     * @date 2019/9/25 10:49
     */
    void saveSortContent(List<NoticeContent> list);

    /**
     * 根据关键字查询
     *
     * @author sunqian
     * @date 2019/9/25 18:29
     */
    List<NoticeContent> selectNoticeContentListByKeyWord(@Param("userId") String userId,@Param("keyWord") String keyWord, @Param("publishValue") String publishValue);
}