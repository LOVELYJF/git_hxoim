package com.hxoim.support.b01.service.impl;

import com.hxoim.common.Reflector.ReflectHelpper;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.DomainObjectUtil;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UtilDateTime;
import com.hxoim.support.b01.entity.B01Attachment;
import com.hxoim.support.b01.mapper.B01AttachmentMapper;
import com.hxoim.support.b01.service.B01AttachmentService;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sun.reflect.misc.ReflectUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * @ description：机构关联附件Service实现类
 * @ author：张乾
 * @ createDate ： 2019/6/10 9:30
 */
@Service
public class B01AttachmentServiceImpl implements B01AttachmentService {

    @Autowired
    private B01AttachmentMapper b01AttachmentMapper;

    /**
     * @ description: 查询机构关联附件
     * @ create by: 张乾
     * @ createDate: 2019/6/10 11:18
     */
    @Override
    public List<B01Attachment> selectAttachmentByB0111(B01Attachment b01Attachment) {
        if (b01Attachment == null) {
            throw new ParameterNullException("机构不能为空");
        }
        return b01AttachmentMapper.selectAttachmentByB0111(b01Attachment);
    }

    /**
     * @ description: 删除附件
     * @ create by: 张乾
     * @ createDate: 2019/6/10 11:25
     */
    @Override
    public void deleteAttachmentById(B01Attachment b01Attachment) {
        if (b01Attachment == null) {
            throw new ParameterNullException("机构不能为空");
        }
        String fileName= DomainObjectUtil.getRequest().getSession()
                .getServletContext().getRealPath(b01Attachment.getFileUrl());
        File delFile = new File(fileName);
        if (delFile.isFile() && delFile.exists()) {
            delFile.delete();
        } else {
            throw new ParameterNullException("没有该文件，删除失败");
        }
        b01AttachmentMapper.deleteAttachmentById(b01Attachment);
    }

    /**
     * @ description: 机构附件上传
     * @ create by: 张乾
     * @ createDate: 2019/6/10 11:31
     */
    @Override
    public void uplodeB01Attachment(MultipartFile[] files, String orgCode, HttpServletRequest request) {
        if (StringUilt.stringIsNullOrEmpty(orgCode)) {
            throw new ParameterNullException("机构不能为空");
        }
        String url = "upload/org/" + orgCode;
        //文件存储路径
        String path = request.getSession().getServletContext().getRealPath(url);
        File newDir = new File(path);
        if (!newDir.exists()) {
            newDir.mkdirs(); // 目录不存在的情况下，创建目录
        }
        if (null != files && files.length > 0) {
            int count = 0;
            //遍历并保存文件
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {

                    String fileName=file.getOriginalFilename();

                    B01Attachment b01Attachment = new B01Attachment();
                    b01Attachment.setB0111(orgCode);
                    b01Attachment.setFileName(fileName);

                    //验证文件名称是否重复
                    count = b01AttachmentMapper.selectFileExist(b01Attachment);
                    if (count > 0) {
                        //throw new ParameterNullException("附件名称已存在！");
                        continue;
                    }
                    try {
                        //通过CommonsMultipartFile的方法直接写文件
                        file.transferTo(new File(path + File.separator + b01Attachment.getFileName()));

                        b01Attachment.setFileUrl(url+"/"+b01Attachment.getFileName());
                        b01Attachment.setId(UUIDGenerator.getPrimaryKey());
                        b01Attachment.setUploadTime(UtilDateTime.toDateTimeString(new Date()));
                        b01Attachment.setFileSize(String.valueOf(file.getSize()));
                        ReflectHelpper.setModifyFields(b01Attachment);

                        b01AttachmentMapper.uplodeB01Attachment(b01Attachment);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            throw new ParameterNullException("附件不能为空");
        }

    }

    /**
     * @ description: 验证文件名称是否重复
     * @ create by: 张乾
     * @ createDate: 2019/6/11 9:58
     */
    @Override
    public void selectFileExist(B01Attachment b01Attachment) {
        int count = b01AttachmentMapper.selectFileExist(b01Attachment);
        if (count > 0) {
            throw new ParameterNullException("附件名称已存在！");
        }
    }

    /**
     * @ description: 文件下载
     * @ create by: 张乾
     * @ createDate: 2019/6/11 10:29
     */
    @Override
    public ResponseEntity<byte[]> downloadB01Attachment(B01Attachment b01Attachment) throws IOException {
        String path = b01Attachment.getFileUrl();  //获取文件所在路径
        String filename = null;
        try {
            //设置jsp的请求参数charset=utf-8
            filename = new String((b01Attachment.getFileName()).getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        path=DomainObjectUtil.getRequest().getSession().getServletContext().getRealPath(path);
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        String downloadFileName = null;
        try {
            //下载中文文件名的文档
            downloadFileName = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        headers.setContentDispositionFormData("attachment", downloadFileName);//告知浏览器以下载方式打开
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//设置MIME类型
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);//
        //用FileUpload组件的FileUtils读取文件，并构建成ResponseEntity<byte[]>返回给浏览器
        //HttpStatus.CREATED是HTTP的状态码201
    }
}
