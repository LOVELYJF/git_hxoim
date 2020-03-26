package com.hxoim.support.b01.mapper;

import com.hxoim.support.b01.entity.B01Attachment;

import java.util.List;

/**
 * @ description：机构关联附件Mapper接口
 * @ author：张乾
 * @ createDate ： 2019/6/10 9:30
 */
public interface B01AttachmentMapper {

    List<B01Attachment> selectAttachmentByB0111(B01Attachment b01Attachment);

    void deleteAttachmentById(B01Attachment b01Attachment);

    void uplodeB01Attachment(B01Attachment b01Attachment);

    int selectFileExist(B01Attachment b01Attachment);
}
