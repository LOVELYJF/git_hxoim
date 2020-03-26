package com.hxoim.support.customquery.service;

import com.hxoim.support.customquery.entity.paramentity.CustomQueryParam;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.Map;

/**
 * @desc: 自定义查询
 * @author: lijing
 * @date: 2019/8/6
 */
public interface PersonCustomQueryService {

    /**
     * 自定义查询sql执行
     * @param customQueryParam
     * @return
     */
    Map<String, Object> customQuery(CustomQueryParam customQueryParam);

    /**
     * 导出excel
     * @param customQueryParam
     * @return
     */
    HSSFWorkbook exportExcel(CustomQueryParam customQueryParam);
}
