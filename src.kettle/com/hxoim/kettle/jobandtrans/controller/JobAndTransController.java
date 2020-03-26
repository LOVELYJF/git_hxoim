package com.hxoim.kettle.jobandtrans.controller;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.ExcelUtil;
import com.hxoim.common.utils.Result;
import com.hxoim.kettle.jobandtrans.entity.custom.JobCustom;
import com.hxoim.kettle.jobandtrans.entity.custom.TransformationCustom;
import com.hxoim.kettle.jobandtrans.entity.paramentity.KettleParam;
import com.hxoim.kettle.jobandtrans.service.JobAndTransService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @desc: 作业，转换管理
 * @author: lijing
 * @date: 2019/7/12
 */
@RestController
@RequestMapping("/jobAndTrans")
public class JobAndTransController {

    @Autowired
    private JobAndTransService jobAndTransService;

    /**
     * @desc: 统计作业转换执行情况
     * @author: lijing
     * @date: 2019/7/12
     */
    @RequestMapping("/accountJobAndTrans")
    public Result accountJobAndTrans(String dirID) {
        Map<String, Object> data = jobAndTransService.accountJobAndTrans(dirID);
        return Result.success(data);
    }

    /**
     * @desc: 作业列表
     * @author: lijing
     * @date: 2019/7/12
     */
    @RequestMapping("/selectJobList")
    public Result selectJobList(String dirID, String name) {
        List<JobCustom> jobs = jobAndTransService.selectJobList(dirID, name);
        return Result.success(jobs);
    }

    /**
     * @desc: 转换列表
     * @author: lijing
     * @date: 2019/7/12
     */
    @RequestMapping("/selectTransList")
    public Result selectTransList(String dirID, String name) {
        List<TransformationCustom> transformations = jobAndTransService.selectTransList(dirID, name);
        return Result.success(transformations);
    }

    /**
     * @desc: 启动转换
     * @param kettleParam
     * @author: lijing
     * @date: 2019/7/16
     */
    @RequestMapping("/transStart")
    public Result transStart(KettleParam kettleParam) {
        jobAndTransService.transStart(kettleParam);
        return Result.success();
    }

    /**
     * @desc: 停止转换
     * @param kettleParam
     * @author: lijing
     * @date: 2019/7/16
     */
    @RequestMapping("/transStop")
    public Result transStop(KettleParam kettleParam) {
        jobAndTransService.transStop(kettleParam);
        return Result.success();
    }

    /**
     * @desc: 启动作业
     * @param kettleParam
     * @author: lijing
     * @date: 2019/7/16
     */
    @RequestMapping("/jobStart")
    public Result jobStart(KettleParam kettleParam) {
        jobAndTransService.jobStart(kettleParam);
        return Result.success();
    }

    /**
     * @desc: 停止作业
     * @param kettleParam
     * @author: lijing
     * @date: 2019/7/16
     */
    @RequestMapping("/jobStop")
    public Result jobStop(KettleParam kettleParam) {
        jobAndTransService.jobStop(kettleParam);
        return Result.success();
    }

    /**
     *
     * @param paramDatas
     * @param paramDatas
     * @param response
     */
    @RequestMapping("/exportExcel")
    public void exportExcel(@RequestBody Param paramDatas, HttpServletResponse response){
        //下载
        //excel文件名
        String fileName = "报表信息"+System.currentTimeMillis()+".xls";
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(fileName,paramDatas.getTableHeaders(),paramDatas.getParamDatas(),null);

//        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbookMap(fileName,tableHeaders,paramDatas,null);
        try {
            fileName = new String(fileName.getBytes(),"ISO8859-1");
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            OutputStream os;
            os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ParameterNullException("导出失败");
        }
    }

}

class Param{
    private List<String> tableHeaders;

    private List<List<String>> paramDatas;

    public List<String> getTableHeaders() {
        return tableHeaders;
    }

    public void setTableHeaders(List<String> tableHeaders) {
        this.tableHeaders = tableHeaders;
    }

    public List<List<String>> getParamDatas() {
        return paramDatas;
    }

    public void setParamDatas(List<List<String>> paramDatas) {
        this.paramDatas = paramDatas;
    }
}