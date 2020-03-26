package com.hxoim.support.b01.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.support.b01.entity.B01Attachment;
import com.hxoim.support.b01.service.B01AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @ description：机构关联附件Controller
 * @ author：张乾
 * @ createDate ： 2019/6/10 9:28
 */
@RestController
@RequestMapping("/b01Attachment")
public class B01AttachmentController {

    @Autowired
    private B01AttachmentService b01AttachmentService;

    /**
     * @ description: 查询机构关联附件
     * @ create by: 张乾
     * @ createDate: 2019/6/10 11:15
     */
    @RequestMapping("/selectAttachmentByB0111")
    public Result selectAttachmentByB0111(B01Attachment b01Attachment){
        List<B01Attachment> list=b01AttachmentService.selectAttachmentByB0111(b01Attachment);
        return Result.success(list);
    }

    /**
     * @ description: 删除附件
     * @ create by: 张乾
     * @ createDate: 2019/6/10 11:24
     */
    @RequestMapping("/deleteAttachmentById")
    public Result deleteAttachmentById(B01Attachment b01Attachment){
        b01AttachmentService.deleteAttachmentById(b01Attachment);
        return Result.success();
    }

    /**
     * @ description: 机构附件上传,可多上传
     * @ create by: 张乾
     * @ createDate: 2019/6/10 11:29
     */
    @RequestMapping("/uplodeB01Attachment")
    public Result uplodeB01Attachment(@RequestParam("files") MultipartFile[] files,
                                      @RequestParam("orgCode") String orgCode,
                                      HttpServletRequest request){
        b01AttachmentService.uplodeB01Attachment(files,orgCode,request);
        return Result.success();
    }

    /**
     * @ description: 验证文件名称是否重复
     * @ create by: 张乾
     * @ createDate: 2019/6/11 9:56
     */
    @RequestMapping("/selectFileExist")
    public Result selectFileExist(B01Attachment b01Attachment){
        b01AttachmentService.selectFileExist(b01Attachment);
        return Result.success();
    }

    /**
     * @ description:下载附件
     * @ create by: 张乾
     * @ createDate: 2019/6/11 10:22
     */
    @RequestMapping("/downloadB01Attachment")
    public ResponseEntity<byte[]> downloadB01Attachment(B01Attachment b01Attachment) throws IOException {
        ResponseEntity<byte[]> file=b01AttachmentService.downloadB01Attachment(b01Attachment);
        return file;
    }
}
