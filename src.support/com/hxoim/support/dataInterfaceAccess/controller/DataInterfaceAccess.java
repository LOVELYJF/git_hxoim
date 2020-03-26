package com.hxoim.support.dataInterfaceAccess.controller;

import com.alibaba.fastjson.JSONObject;
import com.hxoim.common.utils.CompressUtil;
import com.hxoim.common.utils.DomainObjectUtil;
import com.hxoim.common.utils.Result;
import com.hxoim.common.utils.RsaUtil;
import com.hxoim.support.dataInterfaceAccess.entity.DataInterfaceAccessLog;
import com.hxoim.support.dataInterfaceAccess.service.DataInterfaceAccessService;
import com.hxoim.support.dataServeApply.entity.DataServeApply;
import com.hxoim.support.dataServeApply.service.DataServeApplyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

@RestController
@RequestMapping("/dataInterfaceAccess")
public class DataInterfaceAccess {

    @Autowired
    private DataInterfaceAccessService dataInterfaceAccessService;
    @Autowired
    private DataServeApplyService dataServeApplyService;

    /**
     * 数据接口检验
     * @param params
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectDataInterfaceAccess")
    public Result selectDataInterfaceAccess(String params) throws Exception{
        //私钥解密
        params = RsaUtil.decryptPrivateKey(params);

        DataInterfaceAccessLog dataInterfaceAccessLog = JSONObject.parseObject(params,DataInterfaceAccessLog.class);
        if(dataInterfaceAccessLog == null || StringUtils.isEmpty(dataInterfaceAccessLog.getServeUsername()) || StringUtils.isEmpty(dataInterfaceAccessLog.getServePassword())
                || StringUtils.isEmpty(dataInterfaceAccessLog.getInterfaceAccessType()) || StringUtils.isEmpty(dataInterfaceAccessLog.getInterfaceAccessName())){

            String err = "访问传参格式错误，其传参属性应包含{'serveUsername':'...','servePassword':'...','interfaceAccessType':'...','interfaceAccessName':'...','accessCondition':'...'}" ;

            return Result.error(err);
        }
        //获取客户端ip
        String serveIp =dataInterfaceAccessLog.getServeIp();
        if(StringUtils.isEmpty(serveIp)){
            serveIp = DomainObjectUtil.getIpAddr();
            dataInterfaceAccessLog.setServeIp(serveIp);
        }

        DataServeApply dataServeApply = dataServeApplyService.selectValidateByParams(serveIp,dataInterfaceAccessLog.getServeUsername());
        if(dataServeApply == null){
            return Result.error("服务下用户不存在");
        }else{
            String servePassword = dataInterfaceAccessLog.getServePassword();
            if( !dataServeApply.getServePassword().equals(servePassword)){
                return Result.error("服务密码错误");
            }
        }
        String str = dataInterfaceAccessService.selectDataInterfaceAccess(dataInterfaceAccessLog);
        //私钥加密
        str = RsaUtil.encryptPrivateKey(str);
        return Result.success(str);

    }

    /**
     * 对数据进行加密，返回加密的数据
     * @param params
     * @return
     */
    @RequestMapping("/encryptData")
    public Result encryptData(String params){
        try {
            params = RsaUtil.encryptPublicKey(params);
            System.out.println(params);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("加密失效");
        }
        return Result.success(params);
    }

    @RequestMapping("/compressZip")
    public Result compressZip(String params, HttpServletRequest request, HttpServletResponse response){
        DataInterfaceAccessLog dataInterfaceAccessLog = JSONObject.parseObject(params,DataInterfaceAccessLog.class);
        if(dataInterfaceAccessLog == null || StringUtils.isEmpty(dataInterfaceAccessLog.getServeUsername()) || StringUtils.isEmpty(dataInterfaceAccessLog.getServePassword())
                || StringUtils.isEmpty(dataInterfaceAccessLog.getInterfaceAccessType()) || StringUtils.isEmpty(dataInterfaceAccessLog.getInterfaceAccessName())){

            String err = "访问传参格式错误，其传参属性应包含{'serveUsername':'...','servePassword':'...','interfaceAccessType':'...','interfaceAccessName':'...','accessCondition':'...'}" ;

            return Result.error(err);
        }
        //获取客户端ip
        String serveIp =dataInterfaceAccessLog.getServeIp();
        if(StringUtils.isEmpty(serveIp)){
            serveIp = DomainObjectUtil.getIpAddr();
            dataInterfaceAccessLog.setServeIp(serveIp);
        }

        DataServeApply dataServeApply = dataServeApplyService.selectValidateByParams(serveIp,dataInterfaceAccessLog.getServeUsername());
        if(dataServeApply == null){
            return Result.error("服务下用户不存在");
        }else{
            String servePassword = dataInterfaceAccessLog.getServePassword();
            if( !dataServeApply.getServePassword().equals(servePassword)){
                return Result.error("服务密码错误");
            }
        }
        String str = dataInterfaceAccessService.selectDataInterfaceAccess(dataInterfaceAccessLog);
        exportZip(str,request,response);
        return Result.success();
    }

    public void exportZip(String data,HttpServletRequest request, HttpServletResponse response){
//        String zipPassword="123456";
        String path = request.getServletContext().getRealPath("/upload");
        System.out.println("path------"+path);
        String fileName = path+"\\resultInfo"+ new Date().getTime()+".txt";
        String zipFile= fileName.substring(0,fileName.lastIndexOf("."))+".zip";
        File file =new File(fileName);
        //创建文件夹
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            //创建文件
            file.createNewFile();
            FileWriter fileWritter = new FileWriter(file.getAbsoluteFile());
            fileWritter.write(data);
            fileWritter.close();
            //转换为zip包
//            CompressUtil.zip(fileName,zipPassword);//加密压缩zip
            CompressUtil.zip(fileName);

            InputStream ins = new BufferedInputStream(new FileInputStream(zipFile));
            byte[] buffer = new byte[ins.available()];
            ins.read(buffer);
            ins.close();

            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String(zipFile.getBytes("UTF-8"), "UTF-8"));
            OutputStream out = new BufferedOutputStream(response.getOutputStream());
            out.write(buffer);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //删除文件和压缩包
            try {
                File f = new File(fileName);
                f.delete();

                File zf = new File(zipFile);
                zf.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}