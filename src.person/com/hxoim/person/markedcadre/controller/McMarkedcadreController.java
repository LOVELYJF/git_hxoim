package com.hxoim.person.markedcadre.controller;
/*
 * @description:我的名单
 * @author 杨波
 * @date:2019-07-03
 */

import com.hxoim.common.utils.*;
import com.hxoim.person.markedcadre.entity.McA01;
import com.hxoim.person.markedcadre.entity.McMarkedcadre;
import com.hxoim.person.markedcadre.entity.McMarkedcadreExample;
import com.hxoim.person.markedcadre.service.McMarkedCadreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Markedcadre")
public class McMarkedcadreController {

    @Autowired
    private McMarkedCadreService mcservice;
    /**
     * @description:通过主键删除名单
     * @author:杨波
     * @date:2019-07-03
     *  * @param id
     * @return:
     **/
    @RequestMapping("/deleteById")
    public Result deleteByPrimaryKey(String id) {
        mcservice.deleteByPrimaryKey(id);
        return Result.success();
    }

    /**
     * @description:插入名单
     * @author:杨波
     * @date:2019-07-03
     *  * @param record
     * @return:
     **/
    @RequestMapping("/insert")
    public Result insert(com.hxoim.person.markedcadre.entity.McMarkedcadre record) {
        mcservice.insert(record);
        return Result.success();
    }

    /**
     * @description:给名单的部分字段插入值
     * @author:杨波
     * @date:2019-07-03
     *  * @param record
     * @return:
     **/
    @RequestMapping("/insertSelective")
    public Result insertSelective(com.hxoim.person.markedcadre.entity.McMarkedcadre record) {
        mcservice.insertSelective(record);
        return Result.success();
    }

    /**
     * @description:查询名单
     * @author:杨波
     * @date:2019-07-03
     *  * @param example
     * @return:
     **/
    @RequestMapping("/selectByUserId")
    public Result selectByExample() {
        McMarkedcadreExample example=new McMarkedcadreExample();
        McMarkedcadreExample.Criteria criteria=example.createCriteria();
        criteria.andUseridEqualTo(UserInfoUtil.getUserInfo().getId());
        example.setOrderByClause("parentId asc,sequence asc");
        return Result.success(mcservice.selectByExample(example));
    }

    /**
     * @description:通过主键获取名单
     * @author:杨波
     * @date:2019-07-03
     * @param id
     * @return:
     **/
    @RequestMapping("/selectById")
    public Result selectByPrimaryKey(String id) {
        com.hxoim.person.markedcadre.entity.McMarkedcadre entity=mcservice.selectByPrimaryKey(id);
        return Result.success(entity);
    }
    /**
     * @description:查询当前登录用户的名单，以网页树要求的格式返回
     * @author:杨波
     * @date:2019-07-05
     *  * @param null
     * @return:
     **/
    @RequestMapping("/treeByUserId")
    public Result selectTree() {
        return Result.success(mcservice.selectTree());
    }
    /**
     * @description:通过主键修改名单部分字段
     * @author:杨波
     * @date:2019-07-03
     *  * @param record
     * @return:
     **/
    @RequestMapping("/updateSelective")
    public Result updateByPrimaryKeySelective(com.hxoim.person.markedcadre.entity.McMarkedcadre record) {
        mcservice.updateByPrimaryKeySelective(record);
        return Result.success();
    }

    /**
     * @description:通过主键修改名单
     * @author:杨波
     * @date:2019-07-03
     *  * @param record
     * @return:
     **/
    @RequestMapping("/update")
    public Result updateByPrimaryKey(com.hxoim.person.markedcadre.entity.McMarkedcadre record) {
        mcservice.updateByPrimaryKey(record);
        return Result.success();
    }
    /**
     * @description:获取指定名单分类下名单序号的最大值
     * @author:杨波
     * @date:2019-07-06
     *  * @param id 要获取下级名单最大序号的名单主键值
     * @return:
     **/
    @RequestMapping("/maxseq")
    public Result getMaxSequence(com.hxoim.person.markedcadre.entity.McMarkedcadre id)
    {
        return Result.success(mcservice.getMaxSequence(id));
    }

    /**
     * description: 通过父级查询下级映射信息
     * create by: sundeng
     * createDate: 2019/8/19
     */
    @RequestMapping("/selectMcByPid")
    public Result selectMcByPid(McMarkedcadre mcMarkedcadre){
        List<McMarkedcadre> list= mcservice.selectMcByPid(mcMarkedcadre);
        return Result.success(list);
    }

    /**
     * description:同级排序
     * create by: sundeng
     * createDate: 2019/8/19
     */
    @RequestMapping("/sortBySequence")
    public Result sortBySequence(String ids){
        mcservice.sortBySequence(ids);
        return Result.success();
    }

    /**
     * description:查询列表
     * create by: sundeng
     * createDate: 2019/8/19
     */
    @RequestMapping("/selectInfoByNodeId")
    public Result selectInfoByNodeId(Integer pageNum, Integer pageSize,String id){
        Map<String,Object> map = mcservice.selectInfoByNodeId(pageNum, pageSize, id);
        return Result.success(map);
    }

    /**
     * description:添加至名单
     * create by: sundeng
     * createDate: 2019/8/20
     */
    @RequestMapping("/insertToList")
    public Result insertToList(@RequestBody List<McA01> list){
        mcservice.insertToList(list);
        return Result.success();
    }

    /**
     * description:从名单中删除
     * create by: sundeng
     * createDate: 2019/8/19
     */
    @RequestMapping("/deleteForList")
    public Result deleteForList(String ids){
        mcservice.deleteForList(ids);
        return Result.success();
    }

    /**
     * description:根据id查询人员详细信息
     * create by: sundeng
     * createDate: 2019/8/19
     */
    @RequestMapping("/selectDetailedInfo")
    public Result selectDetailedInfo(String id){
        Map<String,Object> map = mcservice.selectDetailedInfo(id);
        return Result.success(map);
    }

    /**
     * description:导出任免表
     * create by: sundeng
     * createDate: 2019/8/26
     */
    @RequestMapping("/rmTableExportWord")
    public void rmTableExportWord(String id,String fileFlag){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> paramMap = new HashMap<String, Object>();

        //默认导出任免审批表
        int tableNum = 1;

        //模板路径
        String path = DomainObjectUtil.getRequest().getSession().getServletContext().getRealPath(Constants.TEMPLATE) + File.separator + "A4.docx";
        paramMap.put("id",id);
        paramMap.put("fileFlag", fileFlag);
        paramMap.put("path",path);

        try {
            resultMap = mcservice.rmTableExportWord(paramMap,tableNum);
            //返回文件名带后缀
            String outFileName = String.valueOf(resultMap.get("outFileName"));
            //判断浏览器
            outFileName = java.net.URLEncoder.encode(outFileName, "UTF-8");
            //返回文件路径加文件名称后缀
            String outFilePath = String.valueOf(resultMap.get("outFilePath"));
            ServletOutputStream outputStream = DomainObjectUtil.getResponse().getOutputStream();
            InputStream inStream = new FileInputStream(outFilePath);
            DomainObjectUtil.getResponse().reset();
            DomainObjectUtil.getResponse().setCharacterEncoding("utf-8");
            DomainObjectUtil.getResponse().setContentType("bin");
            DomainObjectUtil.getResponse().setHeader("Content-Disposition", "attachment;fileName=\"" + outFileName + "\"");
            DomainObjectUtil.getResponse().setHeader("Access-Control-Allow-Origin", "*");
            byte[] b = new byte[1024];
            int len;
            while ((len = inStream.read(b)) > 0) {
                outputStream.write(b, 0, len);
            }
            inStream.close();
            outputStream.close();
        } catch (Exception e) {
            resultMap.put("code", 1);
            resultMap.put("msg", "失败");
            Result.error(e.getMessage());
            e.printStackTrace();
        } finally {
            String exportPath = (String)resultMap.get("exportPath");
            FileUtil.delete(exportPath);
        }
    }
}
