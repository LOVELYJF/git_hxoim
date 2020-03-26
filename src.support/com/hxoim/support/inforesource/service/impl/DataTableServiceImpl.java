package com.hxoim.support.inforesource.service.impl;

import com.hxoim.common.Reflector.ReflectHelpper;
import com.hxoim.general.select.mapper.SelectMapper;
import com.hxoim.general.select.entity.SqlVo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.support.inforesource.entity.DataTable;
import com.hxoim.support.inforesource.entity.DataTableCol;
import com.hxoim.support.inforesource.entity.DataTableExample;
import com.hxoim.support.inforesource.mapper.DataTableColMapper;
import com.hxoim.support.inforesource.mapper.DataTableMapper;
import com.hxoim.support.inforesource.service.DataTableService;
import com.hxoim.support.sysdict.service.SysDictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/*
 * @description:信息资源表
 * @author 杨波
 * @date:2019-07-17
 */
@Service
public class DataTableServiceImpl implements DataTableService {
    @Autowired
    private DataTableMapper mapper = null;

    @Autowired
    private DataTableColMapper dataTableColMapper;
    @Autowired
    private SysDictItemService sysDictItemService;
    @Autowired
    private SelectMapper selectMapper ;
    /**
     * @description:通过主键删除信息资源表
     * @author:杨波
     * @date:2019-07-17 * @param String id
     * @return:
     **/
    @Override
    public int deleteByPrimaryKey(String id) {
        if (StringUilt.stringIsNullOrEmpty(id)) {
            throw new ParameterNullException("参数不能为空");
        }
        DataTable dataTable = selectByPrimaryKey(id);
        if (dataTable == null) {
            throw new ParameterNullException("该表不存在！");
        }
        int result = mapper.deleteByPrimaryKey(id);
        dataTableColMapper.deleteByTabCode(dataTable.getTabCode());
        mapper.deleteTable(dataTable);
        return result;
    }

    @Override
    public int insert(DataTable record) {
        CheckInput(record);
        record = DefaultDataTable(record);
        int result = mapper.insert(record);
        CreateTable(record);
        return result;
    }

    @Override
    public int insertSelective(DataTable record) {

        CheckInput(record);
        record = DefaultDataTable(record);
        int result = mapper.insertSelective(record);
        CreateTable(record);

        return result;
    }

    private DataTable DefaultDataTable(DataTable record) {
        record.setId(UUIDGenerator.getPrimaryKey());
        ReflectHelpper.setModifyFields(record);
        return record;
    }

    private void CreateTable(DataTable dataTable) {
        //创建表
        mapper.createTable(dataTable);

        //将创建好表的id,modify_user,modify_time 字段添加到资源项
        DataTableCol information = new DataTableCol();
        information.setTabCode(dataTable.getTabCode());

        information.setId(UUIDGenerator.getPrimaryKey());
        information.setColCode("Id");
        information.setColName("主键");
        information.setDataType("VARCHAR");
        information.setLength1(36);
        information.setIsDeleted("0");
        information.setIsPk("1");
        information.setIsNecessary("1");
        information.setIsSystem("1");
        dataTableColMapper.insertSelective(information);  //资源项添加id

        information.setId(UUIDGenerator.getPrimaryKey());
        information.setColCode("modify_user");
        information.setColName("修改人");
        information.setIsPk("0");
        dataTableColMapper.insertSelective(information);//资源项添加修改人

        information.setId(UUIDGenerator.getPrimaryKey());
        information.setColCode("modify_time");
        information.setColName("修改时间");
        information.setDataType("DATETIME");
        dataTableColMapper.insertSelective(information);//资源项添加修改时间
    }

    @Override
    public List<DataTable> selectByExample(DataTableExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public DataTable selectByPrimaryKey(String id) {
        if (StringUilt.stringIsNullOrEmpty(id)) {
            throw new ParameterNullException("参数不能为空");
        }
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * @description:通过表名查找信息资源表
     * @author:杨波
     * @date:2019-07-17 * @param String tableCode
     * @return:
     **/
    public DataTable selectByTableCode(String tableCode) {

        DataTableExample example = new DataTableExample();
        DataTableExample.Criteria criteria = example.createCriteria();
        if (StringUilt.stringIsNullOrEmpty(tableCode)) {
            throw new ParameterNullException("表名不能为空！");
        }
        criteria.andTabCodeEqualTo(tableCode);
        List<DataTable> dataTables = mapper.selectByExample(example);
        if (dataTables.size() > 0) {
            return dataTables.get(0);
        }
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(DataTable record) {

        CheckInput(record);
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DataTable record) {

        CheckInput(record);
        return mapper.updateByPrimaryKey(record);
    }

    /**
     * @description:保存表的排序
     * @author:杨波
     * @date:2019-07-22 * @param ids
     * @return:void
     **/
    @Override
    public void sortOrderIndex(String[] ids) {
        if (ids == null || ids.length == 0) {
            throw new ParameterNullException("排序内容不能为空");
        }
        for (int i = 0; i < ids.length; i++) {
            DataTable dataTable = new DataTable();
            dataTable.setId(ids[i]);
            dataTable.setOrderIndex(i + 1);
            mapper.sortOrderIndex(dataTable);
        }
    }

    /**
     * @description:获取指定分类下数据库表序号的最大值
     * @author:杨波
     * @date:2019-07-19 * @param id 要获取数据库表最大序号的分类主键值
     * @return:
     **/
    @Override
    public int getMaxSequence(DataTable record) {
        return mapper.getMaxSequence(record);
    }

    @Override
    public List<DataTable> selectDataTable() {
        return mapper.selectDataTable();
    }

    private void CheckInput(DataTable record) {
        if (record == null) {
            throw new ParameterNullException("参数不能为空");
        }
        if (StringUilt.stringIsNullOrEmpty(record.getTabCode())) {
            throw new ParameterNullException("表名不能为空");
        }
        if (StringUilt.stringIsNullOrEmpty(record.getTabName())) {
            throw new ParameterNullException("表中文名不能为空");
        }

        DataTable dataTable = selectByTableCode(record.getTabCode());
        if (dataTable != null && dataTable.getId().equals(record.getId()) == false) {
            throw new ParameterNullException("该表已经存在！");
        }
        int count = mapper.selectTableName(record);
        if (count > 0) {
            throw new ParameterNullException("该表已经存在！");
        }
    }

    /**
     * 查询侧边列表
     *
     * @return
     * @author:孙登
     * @date:2019-08-05
     */
    @Override
    public List selectTableTree() {
        List list = new ArrayList<>();
        List<Map<String, String>> list1 = mapper.selectTableTree();
        for (Map map : list1) {
            map.put("temp", "1");
        }
        List<Map<String, String>> list2 = mapper.selectByCatalogId();
        for (Map map : list2) {
            map.put("temp", "2");
        }
        list.addAll(list1);
        list.addAll(list2);

        return list;
    }

    /**
     * 根据id查询表名
     *
     * @return
     * @author:孙登
     * @date:2019-08-06
     */
    @Override
    public List<Map<String, Object>> selectById(String id) {
        return mapper.selectById(id);
    }

    @Override
    public List<Tree> selectDataTableTree() {
        return null;
    }

    /**
     * @desc: 查询表信息，因为前端按照孙登的方式获取数据绘制页面，没时间改，先沿用，后续再优化
     * @author: 杨波
     * @date: 2019/8/1
     */
    @Override
    public List<Map<String, Object>> selectTableInfo(String tablecode) {
        return mapper.selectTableInfo(tablecode);
    }

    /**
     * @desc: 查询表列名，因为前端按照孙登的方式获取数据绘制页面，没时间改，先沿用，后续再优化
     * @author: 杨波
     * @date: 2019/8/1
     */
    @Override
    public List<Map<String, Object>> selectTableCol(String tablecode) {
        Map<String, Object> resultMap = new LinkedHashMap<>();

        List<Map<String, Object>> tableCol = mapper.selectTableCol(tablecode);
        resultMap.put("tableCol", tableCol);

        //查询列相关字典
        Map<String, Object> dicCodeItemMap = new LinkedHashMap<>();
        for (Map<String, Object> map : tableCol) {

            String controlType = (String) map.get("CONTROL_TYPE");

            if (map.get("DIC_CODE") == null || map.get("DIC_CODE").toString().length()==0) continue;
            if ("2".equals(controlType) == false && "14".equals(controlType) == false) continue;
            if (dicCodeItemMap.containsKey(map.get("DIC_CODE"))) continue;

            List<Map<String, Object>> dicCodeItems = sysDictItemService.getDictInfoByDictCode((String) map.get("DIC_CODE"), null);
            dicCodeItemMap.put((String) map.get("DIC_CODE"), dicCodeItems);

            resultMap.put("dicCodeItems", dicCodeItemMap);
        }

        //处理外键表，当作数据字典处理
        for (Map<String, Object> map : tableCol) {
            String controlType = (String) map.get("CONTROL_TYPE");
            if ("4".equals(controlType) ==false) continue;

            if (map.get("LINK_TABLE") != null && map.get("LINK_VALUECOLUMN") != "" && map.get("LINK_LABELCOLUMN") != "") {
                if (dicCodeItemMap.containsKey(map.get("LINK_TABLE"))) continue;

                SqlVo sql = SqlVo.getInstance("select "+
                        ((map.get("LINK_PARENTCOLUMN")==null||StringUilt.stringIsNullOrEmpty(map.get("LINK_PARENTCOLUMN").toString()))?"":
                        map.get("LINK_PARENTCOLUMN") + " as pid,") +
                        map.get("LINK_VALUECOLUMN") + " as id," +
                        map.get("LINK_LABELCOLUMN") + " as name from " + map.get("LINK_TABLE"));
                List<LinkedHashMap<String, Object>> foreignKeys = selectMapper.select(sql);
                List<dictionaryItem> dicCodeItems = new ArrayList<>();
                for (LinkedHashMap<String, Object> foreignKey : foreignKeys) {
                    dictionaryItem sdi=new dictionaryItem();
                    sdi.setId(foreignKey.get("id").toString());
                    sdi.setName(foreignKey.get("name").toString());
                    if(map.get("LINK_PARENTCOLUMN")!=null&&
                            StringUilt.stringIsNullOrEmpty(map.get("LINK_PARENTCOLUMN").toString())==false)
                    {
                        sdi.setpId(foreignKey.get("pid").toString());
                        sdi.setIsParent(StringUilt.stringIsNullOrEmpty(foreignKey.get("pid").toString())?"true":"false");
                    }
                    dicCodeItems.add(sdi);
                }
                dicCodeItemMap.put((String) map.get("LINK_TABLE"), dicCodeItems);
            }
        }
        resultMap.put("dicCodeItems", dicCodeItemMap);

        return Collections.singletonList(resultMap);
    }
    private class dictionaryItem
    {
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getpId() {
            return pId;
        }

        public void setpId(String pId) {
            this.pId = pId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIsParent() {
            return isParent;
        }

        public void setIsParent(String isParent) {
            this.isParent = isParent;
        }

        private String id;
        private String pId;
        private String name;
        private String isParent;
    }
}
