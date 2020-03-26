package com.hxoim.support.customquery.controller;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.utils.Result;
import com.hxoim.support.customquery.entity.paramentity.CustomQueryParam;
import com.hxoim.support.customquery.service.PersonCustomQueryService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Map;

/**
 * @desc: 自定义查询
 * @author: lijing
 * @date: 2019/8/6
 */
@RestController
@RequestMapping("/personCustomQuery")
public class PersonCustomQueryController {
    @Autowired
    private PersonCustomQueryService personCustomQueryService;

    /**
     * @desc: 执行查询
     * @author: lijing
     * @date: 2019/8/13
     */
    @RequestMapping("/customQuery")
    public Result customQuery(@RequestBody CustomQueryParam customQueryParam){
        Map<String, Object> result = personCustomQueryService.customQuery(customQueryParam);
        return Result.success(result);
    }

    /**
     * @desc: 导出excel
     * @author: lijing
     * @date: 2019/8/13
     */
    @RequestMapping("/exportExcel")
    public void exportExcel(@RequestBody CustomQueryParam customQueryParam, HttpServletResponse response){
        HSSFWorkbook wb = personCustomQueryService.exportExcel(customQueryParam);
        //下载
        //excel文件名
        String fileName = "人员信息"+System.currentTimeMillis()+".xls";
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
