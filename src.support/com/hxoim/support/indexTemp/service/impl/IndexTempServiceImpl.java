package com.hxoim.support.indexTemp.service.impl;

import com.hxoim.general.select.mapper.SelectMapper;
import com.hxoim.general.select.entity.SqlVo;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.tree.Tree;
import com.hxoim.common.tree.TreeUtil;
import com.hxoim.common.utils.UUIDGenerator;
import com.hxoim.common.utils.UserInfo;
import com.hxoim.common.utils.UserInfoUtil;
import com.hxoim.support.indexTemp.entity.IndexTemp;
import com.hxoim.support.indexTemp.entity.SysTempModule;
import com.hxoim.support.indexTemp.mapper.IndexTempMapper;
import com.hxoim.support.indexTemp.mapper.SysTempModuleMapper;
import com.hxoim.support.indexTemp.service.IndexTempService;
import com.hxoim.support.usergroup.entity.UserGroupUser;
import com.hxoim.support.usergroup.mapper.UserGroupMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class IndexTempServiceImpl implements IndexTempService {

    @Autowired
    private IndexTempMapper indexTempMapper;

    @Autowired
    private UserGroupMapper userGroupMapper;

    @Autowired
    private SelectMapper selectMapper;

    @Autowired
    private SysTempModuleMapper sysTempModuleMapper;

    @Override
    public boolean insertBatchSelective(IndexTemp indexTemps[]) {
        boolean flag =true;
        try {
            UserInfo userInfo = UserInfoUtil.getUserInfo();
            //查询处室
            UserGroupUser userGroupUser = userGroupMapper.selectUserGroupUser(userInfo.getId());
            if(userGroupUser == null){
                throw new ParameterNullException("该用户没有分配处室权限");
            }
            for (IndexTemp indexTemp:indexTemps ) {
                if(StringUtils.isEmpty(indexTemp.getId())){
                    indexTemp.setId(UUIDGenerator.getPrimaryKey());
                    indexTemp.setOrgId(userGroupUser.getUgId());
                    indexTemp.setModifyUser(userInfo.getId());
                    indexTemp.setModifyTime(new Date());
                    indexTempMapper.insertSelective(indexTemp);
                }else{
                    indexTemp.setModifyUser(userInfo.getId());
                    indexTemp.setModifyTime(new Date());
                    indexTempMapper.updateSelective(indexTemp);
                }
            }
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public void deleteIndexTempById(String id) {
        sysTempModuleMapper.deleteByPrimaryKey(id);
        indexTempMapper.deleteIndexTempById(id);
    }

    @Override
    public List<IndexTemp> selectIndexTempByOrg() {
        UserInfo userInfo = UserInfoUtil.getUserInfo();
        if (userInfo == null){
            throw new ParameterNullException("用户信息获取失败");
        }
        //查询处室
        UserGroupUser userGroupUser = userGroupMapper.selectUserGroupUser(userInfo.getId());
        if(userGroupUser == null){
            throw new ParameterNullException("该用户没有分配处室权限");
        }
        return indexTempMapper.selectIndexTempByOrg(userGroupUser.getUgId());
    }

    @Override
    public List selectSysTempModule() {
        UserInfo userInfo = UserInfoUtil.getUserInfo();
        if (userInfo == null){
            throw new ParameterNullException("用户信息获取失败");
        }
        //查询处室
        UserGroupUser userGroupUser = userGroupMapper.selectUserGroupUser(userInfo.getId());
        if(userGroupUser == null){
            throw new ParameterNullException("该用户没有分配处室权限");
        }
        List<IndexTemp> indexTemps = indexTempMapper.selectIndexTempByOrg(userGroupUser.getUgId());

        for (IndexTemp temp: indexTemps) {
            String table = temp.getTableCode();
            List<SysTempModule> stms = temp.getStms();
            if(stms!=null && stms.size()>0){
                String moduleId="";
                for (SysTempModule stm:stms ) {
                    moduleId += "'"+stm.getModuleId()+"',";
                }
                moduleId = moduleId.substring(0,moduleId.length()-1);

                String sql = "select * from "+table +" where id in ( "+moduleId+" )";

                 /*String sql = "select * from "+table +" where id in ( "+moduleId+" )";*/
                // if(table.equals("sys_decision_analysis")){
                // sql = "select *,mu_name as node_name from cf_module where id in ("+moduleId +")";
                // }
                if(table.equals("notice_content")){
                    sql="select id,modify_user,modify_time,pid,notice_title as node_name,r_type,sort_id as order_index,att_content from "+table +" where id in ( "+moduleId+" )";
                }
                sql = getSqlByTableName(table,sql,"selectSysTempModule",moduleId);
                SqlVo instance = SqlVo.getInstance(sql);
                List<LinkedHashMap<String, Object>> select = selectMapper.select(instance);

                List<LinkedHashMap<String,Object>> newSelect =  new ArrayList<LinkedHashMap<String,Object>>();

                String singlemoduleId ="";

                for (SysTempModule stm:stms ) {
                    singlemoduleId = stm.getModuleId()!=null? stm.getModuleId():"";

                    for(LinkedHashMap lk:select){

                        String sid = lk.get("id")!=null?  lk.get("id").toString():"";

                        if(StringUtils.isNotEmpty(sid)){
                            if(singlemoduleId.equals(sid)){

                                newSelect.add(lk);

                            }
                        }




                    }



                }

                temp.setModuleObj(newSelect);
            }
        }
        return indexTemps;
    }

    @Override
    public boolean insertSysTempModule(IndexTemp indexTemps[]) {
        boolean flag = true;
        UserInfo userInfo = UserInfoUtil.getUserInfo();
        //查询处室
        UserGroupUser userGroupUser = userGroupMapper.selectUserGroupUser(userInfo.getId());
        if(userGroupUser == null){
            throw new ParameterNullException("该用户没有分配处室权限");
        }
        try {
            for (IndexTemp temp:indexTemps) {
                if(StringUtils.isEmpty(temp.getId())){
                    temp.setId(UUIDGenerator.getPrimaryKey());
                    temp.setOrgId(userGroupUser.getUgId());
                    temp.setModifyUser(userInfo.getId());
                    temp.setModifyTime(new Date());
                    indexTempMapper.insertSelective(temp);
                }else{
                    temp.setModifyUser(userInfo.getId());
                    temp.setModifyTime(new Date());
                    indexTempMapper.updateSelective(temp);
                }

                List<SysTempModule> stms = temp.getStms();
                for (SysTempModule stm: stms ) {
                    stm.setId(UUIDGenerator.getPrimaryKey());
                    stm.setTempId(temp.getId());
                    sysTempModuleMapper.insertSelective(stm);
                }
            }
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateSysTempModule(IndexTemp[] record) {
        boolean flag = true;
        try {
            for (IndexTemp temp:record) {
                sysTempModuleMapper.deleteByPrimaryKey(temp.getId());
            }
            this.insertSysTempModule(record);
        } catch (Exception e) {
            flag =false;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<LinkedHashMap<String, Object>> selectIndexTempTable() {
        String sql="select t.* from data_table t where t.IS_INDEX_TEMP = '1' ";
        SqlVo instance = SqlVo.getInstance(sql);
        List<LinkedHashMap<String, Object>> select = selectMapper.select(instance);
        LinkedHashMap<String,Object> map = new LinkedHashMap();
        map.put("TAB_CODE","homeMyWork");
        map.put("TAB_NAME","首页我的工作");
        LinkedHashMap<String,Object> map1 = new LinkedHashMap();
        map1.put("TAB_CODE","homeTodoList");
        map1.put("TAB_NAME","首页待办事项");
        select.add(map);
        select.add(map1);
        return select;
    }

    @Override
    public Map selectTree(String tableName,String tempId) {
        Map map = new HashMap();
        String sql = "select id,pid,node_name as label from "+tableName +" order by order_index ";

        if(tableName.equals("sys_business_module")){
            sql = "select c.* from ( \n" +
                    " select id,system_name as label,'' as pid from cf_system where system_type='2' \n" +
                    " union all \n" +
                    " select id,node_name as label,system_id as pid from sys_business_module \n" +
                    " ) c ";
        }
        if(tableName.equals("notice_content")){
            //sql="select id,notice_title as label from "+tableName +"  order by sort_id";
            String userId = UserInfoUtil.getUserInfo().getId();
            sql = "select * from( " +
                    "select a.id,notice_title as label,is_publish,start_time,end_time,publish_time,sort_id" +
                    " from notice_content a" +
                    " where a.modify_user = '"+ userId +"'" +
                    " union" +
                    " select a.id,notice_title as label,is_publish,start_time,end_time,publish_time,sort_id" +
                    " from notice_content a" +
                    " left join notice_content_role r on a.id = r.content_id" +
                    " left join cf_user u on r.org_id = u.org_id" +
                    " left join b01 b on u.org_id = b.b0111" +
                    " where u.id = '"+userId+"'" +
                    ") t" +
                    " where t.is_publish = '1' and NOW() >= t.start_time and NOW() <= t.end_time" +
                    " order by t.publish_time desc,t.sort_id ";
        }

        // 我的工作  代码重构
        sql =  getSqlByTableName(tableName,sql,"selectTree",null);


        // if(tableName.equals("sys_decision_analysis")){
        // sql = "select id,p_id,mu_name as label from cf_module where p_id = \"AAA300F8-6857-4905-A6D0-239C91B20339\"";
        // }
        SqlVo instance = SqlVo.getInstance(sql);
        List<Tree> trees = TreeUtil.listToTreeJson(selectMapper.selectTree(instance));
        map.put("trees",trees);

        UserInfo userInfo = UserInfoUtil.getUserInfo();
        String sqlCk= "select m.module_id  from index_temp t \n" +
                " LEFT JOIN sys_temp_module m on t.id = m.temp_id \n" +
                " where t.table_code = '"+tableName+"' and t.id ='"+tempId+"' " +
                " and t.modify_user = '"+userInfo.getId()+"'";
        SqlVo instanceCk = SqlVo.getInstance(sqlCk);
        List<LinkedHashMap<String, Object>> select = selectMapper.select(instanceCk);
        map.put("checked",select);
        return map;
    }

    private String getSqlByTableName(String tableName,String sql,String method,String moduleId) {

/**

        if("work_info".equals(tableName)){

            String userId = UserInfoUtil.getUserInfo().getId();



            sql = "select  " +
                    " id, modify_user, modify_time, p_id,work_title " +
                    "as  " ;

            if("selectTree".equals(method)){

                sql+=" label ";
            }else{

                sql+=" node_name ";

            }

            sql+=        ",work_content,user_id,status,start_time,plan_finished_time,real_finished_time " +
                    " from work_info t where t.user_id = '"+userId+"' " ;

            if(moduleId!=null){

                sql+= " and t.id in ("+moduleId+") ";

            }

            sql+=
//                    " and t.status in ("+ WorkInfoMapper.WORKINFO_UNDERWAY+","+WorkInfoMapper.WORKINFO_FINISHED+") "+
                    " order by t.start_time desc  ";

        }

 */
        Properties prop = null;
        try {
             prop = PropertiesLoaderUtils.loadAllProperties("work.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }


          String realTableName = "cf_module";
//
//        String condition = "";
//
//        condition+= "'" + prop.getProperty("work.name")+ "'"+ "," + "'"+prop.getProperty("work.name1")+"'";
//
//        if("work_info".equals(tableName)){
//
//
//            sql = "select cm.*,mu_name as  ";
//
//            if("selectTree".equals(method)){
//
//                sql+=" label ";
//            }else{
//
//                sql+=" node_name ";
//
//            }
//
//            sql += " from "+realTableName+" cm where 1=1  and mu_code in ("+ condition +") ";
//
//
//        }

        if(prop.getProperty("work.homeMyWork").equals(tableName)||prop.getProperty("work.homeTodoList").equals(tableName)){

            sql = "select cm.*,mu_name as  ";

            if("selectTree".equals(method)){

                sql+=" label ";
            }else{

                sql+=" node_name ";

            }

            sql += " from "+realTableName+" cm where 1=1  and mu_code = '"+ tableName +"' ";


        }

        return  sql;

    }

    @Override
    public List<Tree> selectTree(String tableName) {
        if (StringUtils.isEmpty(tableName)){
            throw new ParameterNullException("参数不能为空");
        }
        String sql = "select id,pid,node_name as label from "+tableName +" order by order_index ";
        if("CF_SYSTEM".equals(tableName.toUpperCase())){
            sql = "SELECT id,system_name as label,p_id as pid FROM cf_system order by order_index";
        }
        if(tableName.equals("notice_content")){
            //sql="select id,notice_title as label from "+tableName +"  order by sort_id";
            String userId = UserInfoUtil.getUserInfo().getId();
            sql = "select * from( " +
                    "select a.id,notice_title as label,is_publish,start_time,end_time,publish_time,sort_id" +
                    " from notice_content a" +
                    " where a.modify_user = '"+ userId +"'" +
                    " union" +
                    " select a.id,notice_title as label,is_publish,start_time,end_time,publish_time,sort_id" +
                    " from notice_content a" +
                    " left join notice_content_role r on a.id = r.content_id" +
                    " where a.modify_user = '"+userId+"'" +
                    ") t" +
                    " where t.is_publish = '1' and NOW() >= t.start_time and NOW() <= t.end_time" +
                    " order by t.publish_time desc,t.sort_id ";
        }
        SqlVo instance = SqlVo.getInstance(sql);
        List<Tree> trees = TreeUtil.listToTreeJson(selectMapper.selectTree(instance));
        return trees;
    }

    @Override
    public List selectSystemInfo() {
        String sql="select * from cf_system where system_type='2'";
        SqlVo instanceCk = SqlVo.getInstance(sql);
        List<LinkedHashMap<String, Object>> select = selectMapper.select(instanceCk);
        return select;
    }

    @Override
    public List<Tree> selectSystemModule() {
        String sql = "select c.* from ( \n" +
                " select id,system_name as label,'' as pid from cf_system where system_type='2' \n" +
                " union all \n" +
                " select id,node_name as label,system_id as pid from sys_business_module \n" +
                " ) c ";
        SqlVo instance = SqlVo.getInstance(sql);
        List<Tree> trees = TreeUtil.listToTreeJson(selectMapper.selectTree(instance));
        return trees;
    }


    @Override
    public Map selectTableList(Integer pageSize, Integer pageNum, String tableName) {
        if (StringUtils.isEmpty(tableName)){
            throw new ParameterNullException("参数错误");
        }
        Map<String, Object> resultMap = new HashMap<>();
        //查询数据
        String sql = "select * from " + tableName;
        int page = (pageNum - 1) * pageSize;
        sql += " limit " + page + "," + pageSize;
        List<LinkedHashMap<String, Object>> dataList = selectMapper.select(SqlVo.getInstance(sql));
        //统计数量
        String sqlCount = "select count(0) as count from "+ tableName;
        List<LinkedHashMap<String, Object>> dataCount = selectMapper.select(SqlVo.getInstance(sqlCount));

        //结果集封装
        resultMap.put("total", dataCount.get(0).get("count"));
        resultMap.put("data", dataList);
        resultMap.put("pageIndex", pageNum);
        resultMap.put("pageSize", pageSize);
        return resultMap;
    }

    @Override
    public List<LinkedHashMap<String, Object>> selectSysModule(String tableName,String ids[]) {

        String  exclude[] = {"notice_content","work_info","homeMyWork","homeTodoList"};

        StringBuffer sb = new StringBuffer();
        for (String param : ids ) {
            sb.append("'").append(param).append("'").append(",");
        }
        String params = sb.toString();
        params = params.substring(0,params.length()-1);
        String sql ="select * from "+ tableName + " where id in ("+params +")";
        if(tableName.equals("notice_content")){
            sql = "select id,notice_title as node_name   from notice_content where id in ("+params +")";
        }

        if(tableName.equals("work_info") ||tableName.equals("homeMyWork") || tableName.equals("homeTodoList")){

         //   sql = "select id,work_title as node_name  from work_info where id in ("+params +")  ";
           sql = "select id,mu_name as node_name ,url,assembly,mu_code  from cf_module where id in ("+params +")  ";

        }

//         if(!tableName.equals("notice_content")){
        if(!Arrays.asList(exclude).contains(tableName)){
            sql+="and if(pid = '',1,pid)!=1";
        }

        SqlVo sqlVo =new SqlVo();
        sqlVo.setSql(sql);
        List<LinkedHashMap<String, Object>> select = selectMapper.select(sqlVo);
        return select;
    }

    @Override
    public void executeSysModule(String params) {
        SqlVo sqlVo = SqlVo.getInstance(params);
        selectMapper.insert(sqlVo);
    }
}
