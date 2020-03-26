package com.hxoim.kettle.directory.service.impl;

import com.hxoim.kettle.directory.entity.Directory;
import com.hxoim.kettle.directory.mapper.DirectoryMapper;
import com.hxoim.kettle.directory.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc: kettle目录
 * @author: lijing
 * @date: 2019/7/17
 */
@Service
public class DirectoryServiceImpl implements DirectoryService {
    @Autowired
    private DirectoryMapper directoryMapper;
    public static final String rootDirectoryName="主目录";

    @Override
    public List<Directory> selectDirectoryList() {
        //根目录
        Directory directory = new Directory();
        directory.setDirectoryName(rootDirectoryName);
        directory.setIdDirectory(0L);
        directory.setIdDirectoryParent(-1);
        List<Directory> directories = directoryMapper.selectDirectoryList();
        directories.add(directory);
        return directories;
    }
}
