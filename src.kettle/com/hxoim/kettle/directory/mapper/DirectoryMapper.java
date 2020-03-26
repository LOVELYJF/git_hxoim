package com.hxoim.kettle.directory.mapper;

import com.hxoim.kettle.directory.entity.Directory;

import java.util.List;

public interface DirectoryMapper {
    int deleteByPrimaryKey(Long idDirectory);

    int insert(Directory record);

    int insertSelective(Directory record);

    Directory selectByPrimaryKey(Long idDirectory);

    int updateByPrimaryKeySelective(Directory record);

    int updateByPrimaryKey(Directory record);

    /**
     * 查询目录列表
     * @return
     */
    List<Directory> selectDirectoryList();
}