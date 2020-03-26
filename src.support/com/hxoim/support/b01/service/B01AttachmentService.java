package com.hxoim.support.b01.service;

import com.hxoim.support.b01.entity.B01Attachment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @ description：机构关联附件Service
 * @ author：张乾
 * @ createDate ： 2019/6/10 9:30
 */
public interface B01AttachmentService {

    List<B01Attachment> selectAttachmentByB0111(B01Attachment b01Attachment);

    void deleteAttachmentById(B01Attachment b01Attachment);

    void uplodeB01Attachment(MultipartFile[] file, String orgCode,HttpServletRequest request);

    void selectFileExist(B01Attachment b01Attachment);

    /**
     * @ description: 下载附件
     * @ create by: 张乾
     * @ createDate: 2019/6/11 11:19
     */
    ResponseEntity<byte[]> downloadB01Attachment(B01Attachment b01Attachment) throws IOException;

}
