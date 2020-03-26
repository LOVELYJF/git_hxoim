package com.hxoim.support.inforesource.service.impl;

import com.hxoim.common.Reflector.ReflectHelpper;
import com.hxoim.common.exceptions.ParameterNullException;
import com.hxoim.common.tree.Tree;
import com.hxoim.common.tree.TreeUtil;
import com.hxoim.common.utils.*;
import com.hxoim.support.inforesource.entity.DataTable;
import com.hxoim.support.inforesource.entity.DataTableExample;
import com.hxoim.support.inforesource.entity.InfoResource;
import com.hxoim.support.inforesource.mapper.InfoResourceMapper;
import com.hxoim.support.inforesource.service.DataTableService;
import com.hxoim.support.inforesource.service.InfoResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 信息资源管理
 * @Author: 张乾
 * @CreateDate: 2019/5/23$ 19:14$
 */
@Service
public class InfoResourceServiceImpl implements InfoResourceService {

    @Autowired
    private InfoResourceMapper infoResourceMapper;

    @Autowired
    private DataTableService dataTableService;

    /**
     * 方法实现说明   查询信息资源列表
     *
     * @author 张乾
     * @date 2019/5/23 19:47
     */
    @Override
    public InfoResource selectInfoResourceById(InfoResource infoResource) {
        if (infoResource == null) {
            throw new ParameterNullException("内容不能为空");
        }
        return infoResourceMapper.selectInfoResourceById(infoResource);
    }

    /**
     * 方法实现说明   添加信息资源,创建表
     *
     * @author 张乾
     * @date 2019/5/23 20:17
     */
    @Override
    @Transactional
    public void insertInfoResource(InfoResource infoResource) {
        if (infoResource == null) {
            throw new ParameterNullException("添加内容不能为空");
        }
        selectResourceCode(infoResource);
        ReflectHelpper.setModifyFields(infoResource);
        infoResource.setId(UUIDGenerator.getPrimaryKey());

        infoResourceMapper.insertSelective(infoResource);
    }

    /**
     * 方法实现说明   修改信息资源
     *
     * @author 张乾
     * @date 2019/5/23 20:22
     */
    @Override
    public void updateInfoResource(InfoResource infoResource) {
        if (infoResource == null) {
            throw new ParameterNullException("修改内容不能为空");
        }

        ReflectHelpper.setModifyFields(infoResource);
        infoResourceMapper.updateByPrimaryKeySelective(infoResource);
    }

    /**
     * 方法实现说明   删除信息资源表数据，同时删除表。
     *
     * @author 张乾
     * @date 2019/5/23 20:45
     */
    @Override
    @Transactional
    public void deleteInfoResource(InfoResource infoResource) {
        if (infoResource == null) {
            throw new ParameterNullException("删除内容不能为空");
        }
        InfoResource info = infoResourceMapper.selectInfoResourceById(infoResource);
        if(info==null)
        {
            throw new ParameterNullException("该资源目录已经被删除！");
        }
        if(info.getResourceType().equals("1"))
        {
            throw new ParameterNullException("系统资源目录不能被删除！");
        }
        int count = infoResourceMapper.selectCountIdByPid(infoResource);
        if (count > 0) {
            throw new ParameterNullException("该资源有子节点，无法删除");
        }

        DataTableExample example=new DataTableExample();
        DataTableExample.Criteria criteria = example.createCriteria();
        if(StringUilt.stringIsNullOrEmpty(infoResource.getId())==false)
        {
            criteria.andCatalogidEqualTo(infoResource.getId());
        }
        List<DataTable> dataTables = dataTableService.selectByExample(example);
        if(dataTables.size()>0)
        {
            throw new ParameterNullException("该资源目录下还有表，不能删除！");
        }

        //删除信息资源
        infoResourceMapper.deleteInfoResource(infoResource);
    }

    /**
     * description:排序
     * create by: 张乾
     * createDate: 2019/5/28 14:02
     */
    @Override
    public void sortOrderIndex(String[] resourceIds) {
        if (resourceIds == null || resourceIds.length == 0) {
            throw new ParameterNullException("排序内容不能为空");
        }
        for (int i = 0; i < resourceIds.length; i++) {
            InfoResource infoResource = new InfoResource();
            infoResource.setId(resourceIds[i]);
            infoResource.setOrderindex(i + 1);
            infoResourceMapper.sortOrderIndex(infoResource);
        }
    }

    /**
     * description:点击分类查询其下面的所有表
     * create by: 张乾
     * createDate: 2019/5/28 19:45
     */
    @Override
    public List<InfoResource> selectTableByPid(InfoResource infoResource) {
        if (infoResource == null) {
            throw new ParameterNullException("信息资源id不能为空");
        }
        return infoResourceMapper.selectTableByPid(infoResource);
    }

    /**
     * @ description: 查询信息资源树
     * @ create by: 张乾
     * @ createDate: 2019/6/4 14:04
     */
    @Override
    public List<Tree> selectInfoResourceTree() {
        return TreeUtil.listToTreeJson(infoResourceMapper.selectInfoResourceTree());
    }

    /**
     * @ description: 验证资源编码是否重复
     * @ create by: 张乾
     * @ createDate: 2019/6/7 13:01
     */
    @Override
    public void selectResourceCode(InfoResource infoResource) {
        if (infoResource == null) {
            throw new ParameterNullException("信息资源编码不能为空");
        }
        int count = infoResourceMapper.selectResourceCode(infoResource);
        if (count > 0) {
            throw new ParameterNullException("信息资源编码重复！");
        }
    }

    /**
     * @ description: 查询所有分类
     * @ create by: 张乾
     * @ createDate: 2019/6/11 15:02
     */
    @Override
    public List<InfoResource> selectResourceType() {
        return infoResourceMapper.selectResourceType();
    }

    @Override
    public List<InfoResource> selectInfoResourceByType(String resourceType) {
        return infoResourceMapper.selectInfoResourceByType(resourceType);
    }
}
