package com.hxoim.full.search.service.impl;

import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.tree.Tree;
import com.hxoim.common.utils.*;
import com.hxoim.full.search.entity.FullSearchSetting;
import com.hxoim.full.search.entity.PersonInfoIndex;
import com.hxoim.full.search.entity.PersonInfoResult;
import com.hxoim.full.search.mapper.FullSearchSettingMapper;
import com.hxoim.full.search.service.FullTextSearchService;
import com.hxoim.full.search.utils.IndexUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 全文检索
 *
 * @author sunqian
 * @date 2019/11/5 15:10
 */
@Service
public class FullTextSearchServiceImpl implements FullTextSearchService {

    @Resource
    private FullSearchSettingMapper fullSearchSettingMapper;

    @Override
    public List<Tree> selectPersonTableTree() {
        return fullSearchSettingMapper.selectPersonTableList();
    }

    @Override
    public Map<String, Object> selectColumnListByTabCode(String tabCode) {
        if (StringUtils.isBlank(tabCode)) {
            throw new ParameterNullException("表编码参数为空");
        }
        //已经索引的列
        List<String> indexCol = fullSearchSettingMapper.selectIndexColumnByTabCode(tabCode);
        //所有的列
        List<Map<String, Object>> colList = fullSearchSettingMapper.selectColumnListByTabCode(tabCode);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("colList", colList);
        resultMap.put("indexCol", indexCol);
        return resultMap;
    }

    @Override
    public void saveSearchIndexColumn(String tabCode, List<String> colList) {
        //清除索引列
        fullSearchSettingMapper.deleteByTabCode(tabCode);
        List<FullSearchSetting> list;
        if (colList != null && !colList.isEmpty()) {
            //data_table_col表中获取col的具体信息
            list = fullSearchSettingMapper.selectColumnInfo(tabCode, colList);
            //保存信息到全文检索设置表中
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    FullSearchSetting fullSearchSetting = list.get(i);
                    fullSearchSetting.setId(UUIDGenerator.getPrimaryKey());
                }
                fullSearchSettingMapper.insertBatch(list);
            }
        }
    }

    @Override
    public void creatSearcherIndex(String tabCode) {
        if (tabCode == null) {
            throw new ParameterNullException("表编码参数为空");
        }
        //获取列信息
        List<FullSearchSetting> list = fullSearchSettingMapper.selectIndexColumn(tabCode);
        creatSearcherIndex(list, tabCode);
    }

    @Override
    public List<PersonInfoResult> queryKeyword(String keyword, PageUtil<PersonInfoResult> pageUtil) {
        //获取已经索引的信息集编码
        String[] strings = fullSearchSettingMapper.selectTabCodes();
        if (strings == null || strings.length == 0) {
            return null;
        }
        int limit = pageUtil.getLimit();
        int page = pageUtil.getPage();
        if (limit == 0) {
            throw new ParameterNullException("分页limit不能为0！！！");
        }
        //根据关键字进行索引查询
        List<PersonInfoIndex> personInfoIndices = new IndexUtils().queryIndex(keyword, strings);
        //处理索引集合，人员id合并
        List<PersonInfoResult> personInfoResultList = getPersonInfoResults(personInfoIndices);
        //根据lucene的score进行排序
        Collections.sort(personInfoResultList);
        pageUtil.setTotal(personInfoResultList.size());
        personInfoResultList = personInfoResultList.subList((page - 1) * limit, limit * page);
        List<Map<String, Object>> personList = fullSearchSettingMapper.selectPersonInfo(personInfoResultList);
        handlerPersonIntroduction(personInfoResultList, personList);
        return personInfoResultList;
    }

    private void handlerPersonIntroduction(List<PersonInfoResult> personInfoResultList, List<Map<String, Object>> personList) {
        if (personInfoResultList == null || personInfoResultList.isEmpty() || personList == null || personList.isEmpty()) {
            return;
        }
        for (PersonInfoResult personInfoResult : personInfoResultList) {
            for (Map<String, Object> map : personList) {
                String a0100 = (String) map.get("A01000");
                if (a0100.equals(personInfoResult.getPersonId())) {
                    //姓名
                    Object a0101 = map.get("A0101");
                    //性别
                    Object a0104_a = map.get("A0104_A");
                    //民族
                    Object a0117_a = map.get("A0117_A");
                    //出生日期
                    Object a0107 = map.get("A0107");
                    //参加组织日期
                    Object a0144 = map.get("A0144");
                    //参加工作时间
                    Object a0134 = map.get("A0134");
                    //全日制学历
                    Object qrzxl = map.get("QRZXL");
                    //在职学历
                    Object zzxl = map.get("ZZXL");
                    //现任职务
                    Object a0192A = map.get("A0192A");
                    Object a5714 = map.get("A5714");

                    StringBuilder sb = new StringBuilder();
                    if (a0101 != null && StringUtils.isNotBlank((String) a0101)) {
                        sb.append(a0101 + "，");
                    }
                    if (a0104_a != null && StringUtils.isNotBlank((String) a0104_a)) {
                        sb.append(a0104_a + "，");
                    }
                    if (a0117_a != null && StringUtils.isNotBlank((String) a0117_a)) {
                        sb.append(a0117_a + "，");
                    }
                    if (a0107 != null && StringUtils.isNotBlank((String) a0107)) {
                        if (((String) a0107).length() == 4) {
                            sb.append(a0107).append("年生人，");
                        } else if (((String) a0107).length() >= 6) {
                            sb.append(((String) a0107).substring(0, 4)).append("年")
                                    .append(Integer.valueOf(((String) a0107).substring(4, 6))).append("月生人，");
                        }
                    }
                    if (a0144 != null) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
                        String format = sdf.format(a0144);
                        sb.append(format).append("加入中国共产党，");
                    }
                    if (a0134 != null) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
                        String format = sdf.format(a0134);
                        sb.append(format).append("参加工作，");
                    }
                    if (qrzxl != null && StringUtils.isNotBlank((String) qrzxl)) {
                        sb.append("全日制").append(qrzxl);
                        if (((String) qrzxl).lastIndexOf("学历") > 0) {
                            sb.append("，");
                        } else {
                            sb.append("学历，");
                        }
                    }
                    if (zzxl != null && StringUtils.isNotBlank((String) zzxl)) {
                        sb.append("在职").append(zzxl);
                        if (((String) zzxl).lastIndexOf("学历") > 0) {
                            sb.append("，");
                        } else {
                            sb.append("学历，");
                        }
                    }
                    if (a0192A != null && StringUtils.isNotBlank((String) a0192A)) {
                        sb.append(a0192A + "，");
                    }
                    personInfoResult.setIntroduction(sb.replace(sb.length() - 1, sb.length(), "。").toString());
                    personInfoResult.setName((String) a0101);
                    personInfoResult.setBirthday((String) a0107);
                    if (a5714 != null && StringUtils.isNotEmpty(a5714.toString())) {
                        HttpServletRequest request = DomainObjectUtil.getRequest();
//                        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
                        String filePath = request.getServletContext().getRealPath(Constants.PHOTOS_PATH) + File.separator + a5714;
                        if (new File(filePath).exists()) {
                            personInfoResult.setPhotoURL(Constants.PHOTOS_PATH + File.separator + a5714);
                        }
                    }
                    break;
                }
            }
        }
    }

    private List<PersonInfoResult> getPersonInfoResults(List<PersonInfoIndex> personInfoIndices) {
        List<PersonInfoResult> personInfoResultList = new ArrayList<>();
        for (int i = 0; i < personInfoIndices.size(); i++) {
            boolean flag = false;
            PersonInfoIndex personInfoIndex = personInfoIndices.get(i);
            if (!personInfoResultList.isEmpty()) {
                for (int j = 0; j < personInfoResultList.size(); j++) {
                    PersonInfoResult personInfoResult = personInfoResultList.get(j);
                    if (personInfoResult.getPersonId().equals(personInfoIndex.getPersonId())) {
                        personInfoResult.setScore((personInfoResult.getScore() == null ? 0 : personInfoResult.getScore())
                                + (personInfoIndex.getScore() == null ? 0 : personInfoIndex.getScore()));
                        personInfoResult.getSearchInfos().add(personInfoIndex.getDescription() + ":" + personInfoIndex.getContent());
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                PersonInfoResult personInfoResult = new PersonInfoResult();
                personInfoResult.setPersonId(personInfoIndex.getPersonId());
                personInfoResult.getSearchInfos().add(personInfoIndex.getDescription() + ":" + personInfoIndex.getContent());
                personInfoResult.setScore((personInfoResult.getScore() == null ? 0 : personInfoResult.getScore())
                        + (personInfoIndex.getScore() == null ? 0 : personInfoIndex.getScore()));
                personInfoResultList.add(personInfoResult);
            }
        }
        return personInfoResultList;
    }

    /**
     * 根据表和列创建检索索引
     *
     * @author sunqian
     * @date 2019/11/7 8:56
     */
    private void creatSearcherIndex(List<FullSearchSetting> list, String tabCode) {
        List<PersonInfoIndex> personInfoIndices = null;
        IndexUtils indexUtils = new IndexUtils();
        //删除索引
        indexUtils.deleteIndex(tabCode);
        if (list != null && !list.isEmpty() && StringUtils.isNotBlank(tabCode)) {
            //拼接sql
            String sql;
            if (!"A57".equalsIgnoreCase(tabCode)) {
                sql = creatQuerySql(list, tabCode);
            } else {
                sql = "select a57.A01000,a57.A5714,a57.FILE_NAME from A57 inner join A01 on a57.a0100=a01.a0100 where a57.a5701!='1'";
            }
            //查询信息
            List<Map<String, Object>> resultList = fullSearchSettingMapper.executeSelectSql(sql);
            if (!"A57".equalsIgnoreCase(tabCode)) {
                //生成索引信息集合，不是多媒体的信息集
                personInfoIndices = handlerPersonInfoIndexList(list, resultList);
            } else {
                //A57生成索引信息集合
                personInfoIndices = handlerA57File(resultList);
            }
        }
        if (personInfoIndices != null && !personInfoIndices.isEmpty()) {
            //创建索引
            indexUtils.creatIndex(personInfoIndices, tabCode);
        }
    }

    private List<PersonInfoIndex> handlerA57File(List<Map<String, Object>> searchResultList) {
        List<PersonInfoIndex> list = new ArrayList<>();
        if (searchResultList != null && !searchResultList.isEmpty()) {
            FileParseTextUtil parseUtil = new FileParseTextUtil();
            for (Map<String, Object> map : searchResultList) {
                Object object = map.get("A5714");
                Object object1 = map.get("A01000");
                Object object2 = map.get("FILE_NAME");
                if (object == null || object1 == null) {
                    continue;
                }
                String basePath = DomainObjectUtil.getRequest().getServletContext().getRealPath(Constants.PERSON_FILE_PATH);
                String filePath = basePath + File.separator + object;
                String content = null;
                try {
                    content = parseUtil.parseText(filePath);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                if (StringUtils.isEmpty(content)) {
                    continue;
                }
                PersonInfoIndex personInfoIndex = new PersonInfoIndex();
                personInfoIndex.setContent(content);
                personInfoIndex.setPersonId(object1.toString());
                personInfoIndex.setColumnCode("FILE_NAME");
                personInfoIndex.setDescription(object2.toString());
                list.add(personInfoIndex);
            }
        }
        return list;
    }

    private List<PersonInfoIndex> handlerPersonInfoIndexList(List<FullSearchSetting> list, List<Map<String, Object>> resultList) {
        List<PersonInfoIndex> personInfoIndices = new ArrayList<>();
        //设置personinfos
        for (Map<String, Object> map : resultList) {
            if (map == null) {
                continue;
            }
            String a0100 = (String) map.get("A01000");
            if (StringUtils.isBlank(a0100)) {
                throw new NullPointerException("人员id不能为空");
            }
            Set<Map.Entry<String, Object>> entrySet = map.entrySet();
            for (Map.Entry<String, Object> stringObjectEntry : entrySet) {
                String key = stringObjectEntry.getKey();
                Object value = stringObjectEntry.getValue();

                if ("A01000".equals(key) || value == null) {
                    continue;
                }
                for (FullSearchSetting setting : list) {
                    if (setting.getColumnCode().toUpperCase().equals(key.toUpperCase())) {
                        PersonInfoIndex personInfoIndex = map2PersonInfoIndex(a0100, key, value, setting);
                        personInfoIndices.add(personInfoIndex);
                        break;
                    }
                }
            }
        }
        return personInfoIndices;
    }

    private PersonInfoIndex map2PersonInfoIndex(String a0100, String key, Object value, FullSearchSetting setting) {
        PersonInfoIndex personInfoIndex = new PersonInfoIndex();
        personInfoIndex.setPersonId(a0100);
        personInfoIndex.setColumnCode(key);
        personInfoIndex.setContent(value.toString());
        personInfoIndex.setDescription(setting.getColumnName());
        return personInfoIndex;
    }

    private String creatQuerySql(List<FullSearchSetting> list, String tabCode) {
        StringBuilder sb = new StringBuilder("select ");
        for (int i = 0; i < list.size(); i++) {
            FullSearchSetting fullSearchSetting = list.get(i);
            sb.append(fullSearchSetting.getColumnCode() + ",");
        }
        return sb.append("A01000 from ").append(tabCode).toString();
    }
}
