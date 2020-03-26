package com.hxoim.kettle.directory.service;


import com.hxoim.kettle.directory.entity.Directory;

import java.util.List;

public interface DirectoryService {
    /**
     * 查询目录
     * @return
     */
    List<Directory> selectDirectoryList();
}
