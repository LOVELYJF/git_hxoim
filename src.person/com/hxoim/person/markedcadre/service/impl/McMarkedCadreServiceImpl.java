package com.hxoim.person.markedcadre.service.impl;
/*
 * @description:名单管理实现类
 * @author 杨波
 * @date:2019-07-03
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxoim.common.Reflector.ReflectHelpper;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.rmbKit.ClassConvertHelper;
import com.hxoim.common.rmbKit.MergeDOC;
import com.hxoim.common.rmbKit.RmbConvertHelper;
import com.hxoim.common.rmbKit.models.A17;
import com.hxoim.common.rmbKit.models.Family;
import com.hxoim.common.rmbKit.models.RmTable;
import com.hxoim.common.tree.Tree;
import com.hxoim.common.tree.TreeUtil;
import com.hxoim.common.utils.*;
import com.hxoim.person.markedcadre.entity.McA01;
import com.hxoim.person.markedcadre.entity.McMarkedcadre;
import com.hxoim.person.markedcadre.entity.McMarkedcadreExample;
import com.hxoim.person.markedcadre.mapper.McMarkedcadreMapper;
import com.hxoim.person.markedcadre.service.McMarkedCadreService;
import com.hxoim.support.inforesource.entity.DataTableCol;
import com.hxoim.support.leaderInfo.mapper.A01Mapper;
import com.hxoim.support.leaderInfo.util.LowerKeyMap;
import com.hxoim.support.sysdict.service.SysDictItemService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class McMarkedCadreServiceImpl implements McMarkedCadreService {
    @Autowired
    private McMarkedcadreMapper mapper;
    @Autowired
    private SysDictItemService sysDictItemService;
    @Autowired
    private A01Mapper a01Mapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(com.hxoim.person.markedcadre.entity.McMarkedcadre record) {
        ReflectHelpper.setModifyFields(record);
        record.setId(UUIDGenerator.getPrimaryKey());
        record.setUserid(UserInfoUtil.getUserInfo().getId());
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(com.hxoim.person.markedcadre.entity.McMarkedcadre record) {
        ReflectHelpper.setModifyFields(record);
        return mapper.insertSelective(record);
    }

    @Override
    public List<com.hxoim.person.markedcadre.entity.McMarkedcadre> selectByExample(McMarkedcadreExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public com.hxoim.person.markedcadre.entity.McMarkedcadre selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }
    @Override
    public List<Tree> selectTree() {
        String userId=UserInfoUtil.getUserInfo().getId();
        List<Tree> treeList = TreeUtil.listToTreeJson(mapper.selectTree(userId));
        return treeList;
    }
    @Override
    public int updateByPrimaryKeySelective(com.hxoim.person.markedcadre.entity.McMarkedcadre record)
    {
        ReflectHelpper.setModifyFields(record);
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(com.hxoim.person.markedcadre.entity.McMarkedcadre record) {
        ReflectHelpper.setModifyFields(record);
        return mapper.updateByPrimaryKey(record);
    }
    /**
     * @description:获取指定名单分类下名单序号的最大值
     * @author:杨波
     * @date:2019-07-06
     *  * @param id 要获取下级名单最大序号的名单主键值
     * @return:
     **/
    @Override
    public int getMaxSequence(com.hxoim.person.markedcadre.entity.McMarkedcadre id)
    {
        return mapper.getMaxSequence(id);
    }

    /**
     * description: 通过父级查询下级映射信息
     * create by: sundeng
     * createDate: 2019/8/19
     */
    @Override
    public List<McMarkedcadre> selectMcByPid(McMarkedcadre mcMarkedcadre) {
//        if(StringUilt.stringIsNullOrEmpty(mcMarkedcadre.getId())){
        if(StringUilt.stringIsNullOrEmpty(mcMarkedcadre.getParentid())){
           return mapper.selectAllMc();
        }
        return mapper.selectMcByPid(mcMarkedcadre);
    }

    /**
     * description:同级排序
     * create by: sundeng
     * createDate: 2019/8/19
     */
    @Override
    public void sortBySequence(String ids) {
        if(StringUtils.isBlank(ids)){
            throw new ParameterNullException("排序参数不能为空");
        }
        String[] idArray = ids.split(",");
        mapper.sortBySequence(idArray);
    }

    /**
     * description:根据id查询列表
     * create by: sundeng
     * createDate: 2019/8/19
     */
    @Override
    public Map<String,Object> selectInfoByNodeId(Integer pageNum, Integer pageSize, String id) {

        //结果map
        Map<String, Object> resultMap = new LinkedHashMap<>();

        //查询动态表头信息
        List<DataTableCol> dataTableColList = mapper.selectDynamicColumn();
        resultMap.put("dataCol", dataTableColList);

        //查询列相关字典
        Map<String, Object> dicCodeItemMap = new LinkedHashMap<>();
        for (DataTableCol dataTableCol : dataTableColList) {
            String controlType = dataTableCol.getControlType();
            if ("2".equals(controlType) || "14".equals(controlType)) {
                if (!dicCodeItemMap.containsKey(dataTableCol.getDicCode())) {
                    List<Map<String, Object>> dicCodeItems = sysDictItemService.getDictInfoByDictCode(dataTableCol.getDicCode(), null);
                    dicCodeItemMap.put(dataTableCol.getDicCode(), dicCodeItems);
                }
            }
        }
        resultMap.put("dicCodeItems", dicCodeItemMap);

        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        if (id == null || id == ""){
            List<LowerKeyMap<String, Object>> list1 = mapper.selectAllInfo();
            PageInfo info1 = new PageInfo(list1);
            resultMap.put("info",info1);
            return resultMap;
        }else {
            List<LowerKeyMap<String, Object>> list2 = mapper.selectInfoByNodeId(id);
            PageInfo info2 = new PageInfo(list2);
            resultMap.put("info", info2);
            return resultMap;
        }
    }

    /**
     * description:添加至名单
     * create by: sundeng
     * createDate: 2019/8/20
     */
    @Override
    public void insertToList(List<McA01> list) {
        for (McA01 mcA01 : list){
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("a01Id", mcA01.getA01Id());
            paramMap.put("mcId", mcA01.getMcId());
            int count = mapper.selectByNodeIdAndMc(paramMap);
            if (count == 0){
                mapper.insertToList(mcA01);
            }
        }
    }

    /**
     * description:从名单中删除
     * create by: sundeng
     * createDate: 2019/8/19
     */
    @Override
    public void deleteForList(String ids) {
        if(StringUtils.isBlank(ids)){
            throw new ParameterNullException("参数不能为空");
        }
        String[] idArray = ids.split(",");
        mapper.deleteForList(idArray);
    }

    /**
     * description:根据id查询人员详细信息
     * create by: sundeng
     * createDate: 2019/8/19
     */
    @Override
    public Map<String,Object> selectDetailedInfo(String id) {
        if (StringUilt.stringIsNullOrEmpty(id)){
            throw new ParameterNullException("参数不能为空");
        }
        Map<String, Object> map = new LinkedHashMap<>();

        //查询拼接信息
        String info = mapper.selectAppendInfo();

        //查询特征信息
        List<LinkedHashMap<String,Object>> trait = mapper.selectTrait();

        List<String> traitList = new ArrayList<>();
        for (LinkedHashMap traitmap:trait) {
            String name = (String) traitmap.get("name");

            Pattern pattern = Pattern.compile(name);
            Matcher matcher = pattern.matcher(info);

            int num = 0;
            while(matcher.find()) {
                num++;
            }
            System.out.println("次数为："+ name +":"+ num);

           if (num > 1){
               traitList.add(name);
           }
        }

        //查询基本描述
        List<LinkedHashMap<String, Object>> description = mapper.selectDescription(id);

        //查询职务变迁
        List<LinkedHashMap<String, Object>> jobChanges = mapper.selectJobChanges(id);

        //查询学历情况
        List<LinkedHashMap<String, Object>> educationInfo = mapper.selectEducationInfo(id);

        //查询考核情况
        List<LinkedHashMap<String, Object>> assessInfo = mapper.selectAssessInfo(id);

        //查询工作经历
        List<LinkedHashMap<String, Object>> workExperience = mapper.selectWorkExperience(id);

        map.put("traitInfo",traitList);
        map.put("description",description);
        map.put("jobChanges",jobChanges);
        map.put("educationInfo",educationInfo);
        map.put("assessInfo",assessInfo);
        map.put("workExperience",workExperience);
        return map;
    }

    @Override
    public Map<String, Object> rmTableExportWord(Map<String, Object> paramMap, int tableNum) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        String id = String.valueOf(paramMap.get("id"));

        //模板路径
        String path = String.valueOf(paramMap.get("path"));
        //导出为单文件还是多文件oneFile/moreFile
        String fileFlag = String.valueOf(paramMap.get("fileFlag"));

        resultMap.put("code", 0);
        resultMap.put("msg", "导出成功");

        if (id != null && !"".equals(id)){
            String[] idArray = id.split(",");
            //word待压缩文件List
            List<File> zipWordFileList = new ArrayList<File>();
            //word待合并文件List
            List<String> mergeWordFileList = new ArrayList<String>();
            if (idArray != null && idArray.length > 0) {
                String tableName = tableNum == 1 ? "任免审批表" : "";
                String exportPath = DomainObjectUtil.getRequest().getSession().getServletContext().getRealPath(Constants.RMB_EXPORT_PATH) + File.separator + new Date().getTime();
                File dir = new File(exportPath);
                if (!dir.exists()) dir.mkdirs();
                String oneWordName = "";
                String outPutPath = "";
                int i = 1;
                int fileNum = 1;
                for (String employId : idArray) {
                    if (employId == null || "".equals(employId)){
                        continue;
                    }
                    //查询返回任免表对象
                    RmTable rmb =  getRmbById(employId);
                    String zhaoPianPath = DomainObjectUtil.getRequest().getSession().getServletContext().getRealPath(Constants.PHOTOS_PATH) + File.separator + employId + ".jpg";
                    if (!(new File(zhaoPianPath).exists())) {
                        zhaoPianPath = "";
                    }
                    //设置人员头像图片路径
                    rmb.setZhaoPianPath(zhaoPianPath);
                    //入党时间格式
                    if (rmb.getRuDangShiJian()!=null&&!"".equals(rmb.getRuDangShiJian())){
                        String ruDangShiJian = rmb.getRuDangShiJian();
                        ruDangShiJian=ruDangShiJian.replace(".", "");
                        String strValue="";
                        if (ruDangShiJian!=null){
                            strValue=ruDangShiJian.substring(0, 4)+"."+ruDangShiJian.toString().substring(4, ruDangShiJian.length());
                        }
                        rmb.setRuDangShiJian(strValue);
                    }
                    //设置参加工作时间
                    if(StringUtils.isNotEmpty(rmb.getCanJiaGongZuoShiJian())){
                        String canJiaGongZuoShiJian = rmb.getCanJiaGongZuoShiJian();
                        canJiaGongZuoShiJian = canJiaGongZuoShiJian.replaceAll("-","");
                        canJiaGongZuoShiJian = canJiaGongZuoShiJian.substring(0,4)+"."+ canJiaGongZuoShiJian.substring(4,6);
                        rmb.setCanJiaGongZuoShiJian(canJiaGongZuoShiJian);
                    }
                    //设置年龄格式
                    if(StringUtils.isNotEmpty(rmb.getChuShengNianYue())){
                        String chuShengNianYue = rmb.getChuShengNianYue();
                        chuShengNianYue = chuShengNianYue.substring(0,4)+"."+ chuShengNianYue.substring(4,6);
                        rmb.setChuShengNianYue(chuShengNianYue);
                    }

                    //将任免表对象写入word
                    XWPFDocument xwpfDocument = new XWPFDocument(new FileInputStream(path));

                    XWPFDocument returnDoc = RmbConvertHelper.GetRBMDoc(xwpfDocument, rmb);

                    if(fileFlag != null && "moreFile".equals(fileFlag)){
                        oneWordName = fileNum++ + "_" +rmb.getXingMing() + "的任免审批表" + ".docx";
                    }
                    outPutPath =  exportPath + File.separator + oneWordName;

                    if (new File(outPutPath).exists()) {
                        i++;
                        outPutPath = exportPath + File.separator + rmb.getXingMing() + i + "的"+tableName+".docx";
                    }

                    OutputStream out = new FileOutputStream(outPutPath);
                    returnDoc.write(out);
                    returnDoc.close();
                    out.close();
                    zipWordFileList.add(new File(outPutPath));
                    mergeWordFileList.add(outPutPath);
                }
                //多文件：打压缩包
                if (fileFlag != null && "moreFile".equals(fileFlag)) {
                    if (zipWordFileList.size() > 1) {
                        //1个以上的文件打压缩包
                        String zipfileName = tableName + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".zip";
                        String zipPath = exportPath + File.separator + zipfileName;
                        //压缩
                        ZIPUtils.zipFiles(zipWordFileList, new File(zipPath));
                        resultMap.put("outFileName", zipfileName);
                        resultMap.put("outFilePath", zipPath);
                    } else {
                        //1个文件直接返回下载
                        resultMap.put("outFileName", oneWordName);
                        resultMap.put("outFilePath", outPutPath);
                    }
                }
                //单文件：导出为单文件合并word
                else if (fileFlag != null && "oneFile".equals(fileFlag)) {
                    if (mergeWordFileList.size() > 1) {
                        String docFileName = tableName + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".docx";
                        String docFilePath = exportPath + File.separator + docFileName;
                        //合并
                        MergeDOC.mergeDoc(mergeWordFileList, docFilePath);
                        resultMap.put("outFileName", docFileName);
                        resultMap.put("outFilePath", docFilePath);
                    } else {
                        resultMap.put("outFileName", oneWordName);
                        resultMap.put("outFilePath", outPutPath);
                    }
                } else {
                    resultMap.put("outFileName", oneWordName);
                    resultMap.put("outFilePath", outPutPath);
                }
                resultMap.put("code", 0);
                resultMap.put("msg", "导出成功");
                resultMap.put("exportPath", exportPath);
            } else {
                resultMap.put("code", 2);
                resultMap.put("msg", "请选择要导出的用户");
            }
        } else {
            resultMap.put("code", 2);
            resultMap.put("msg", "请选择要导出的用户");
        }
        return resultMap;
    }

    private RmTable getRmbById(String id) {
        Map<String, Object> rmbMap = null;
        List<Map<String, Object>> jtcyMapList = null;
        List<A17> a17List = null;

        //查询任免表基本信息
        rmbMap = mapper.queryRmbDetail(id);

        //查询家庭成员情况
        jtcyMapList = a01Mapper.selectFamily(id);

        //查询简历信息
        a17List = mapper.getResumeList(id);

        //任免表对象
        RmTable rmb = (RmTable) ClassConvertHelper.map2Object(rmbMap, RmTable.class);
        rmb.setQrzhiJiaoYuBiYeYuanXiao(rmb.getQrzhiJiaoYuBiYeYuanXiao() != null ? rmb.getQrzhiJiaoYuBiYeYuanXiao().replaceAll("\n", "<br/>") : "");
        rmb.setZaiZhiJiaoYuBiYeYuanXiao(rmb.getZaiZhiJiaoYuBiYeYuanXiao() != null ? rmb.getZaiZhiJiaoYuBiYeYuanXiao().replaceAll("\n", "<br/>") : "");

        if (jtcyMapList != null && jtcyMapList.size() > 0) {
            Object jtcy = ClassConvertHelper.mapList2ObjectList(jtcyMapList, Family.class);
            List<Family> jtcyList = (List<Family>) jtcy;
            rmb.setJiaTingChengYuanList(jtcyList);
        }

        if (rmb.getA1701_a() != null && !"".equals(rmb.getA1701_a())) {
            if (a17List != null && a17List.size() > 0) {
                A17 a17 = a17List.get(a17List.size() - 1);
                if (a17 != null) {
                    a17.setA1703(a17.getA1703() + "\n\n" + rmb.getA1701_a());
                }
            } else {
                A17 a17 = new A17();
                a17.setA1703(rmb.getA1701_a());
                a17List.add(a17);
            }
        }

        //开始时间--结束时间+两空格+职务
        List<String> jianliList = new ArrayList<String>();
        if (a17List != null && a17List.size() > 0) {
            rmb.setA17List(a17List);
            for (A17 a17 : a17List) {
                if (a17 != null) {
                    String a1701 = (a17.getA1701() != null && !"".equals(a17.getA1701())) ? a17.getA1701() : "       ";
                    String a1702 = (a17.getA1702() != null && !"".equals(a17.getA1702())) ? a17.getA1702() : "       ";
                    String a1703 = (a17.getA1703() != null && !"".equals(a17.getA1703())) ? a17.getA1703().replaceAll("\r\n", "\r").replaceAll("\n", "\r").replaceAll("\r", "<br/>") : "";
                    a17.setA1703(a1703);
                    if ("".equals(a1703.trim()) && "".equals(a1702.trim()) && "".equals(a1701.trim())) {
                    } else if (!"".equals(a1703.trim()) && "".equals(a1702.trim()) && "".equals(a1701.trim())) {
                        String oneJianli = "                  " + a17.getA1703();
                        jianliList.add(oneJianli);
                    } else {
                        String oneJianli = a1701 + "--" + a1702 + "  " + a17.getA1703();
                        jianliList.add(oneJianli);
                    }
                }
            }
        }
        rmb.setJianLiList(jianliList);
        String chuShengNianYue = rmb.getChuShengNianYue();
        String nianLing = rmb.getNianLing();
        if (chuShengNianYue != null && !"".equals(chuShengNianYue) && nianLing != null && !"".equals(nianLing)) {
            rmb.setChuShengNianYue(chuShengNianYue + "\r" + "(" + nianLing + "岁)");
        }
        return rmb;
    }
}
