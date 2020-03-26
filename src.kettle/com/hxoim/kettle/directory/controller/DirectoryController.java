package com.hxoim.kettle.directory.controller;

import com.hxoim.common.utils.Result;
import com.hxoim.kettle.directory.entity.Directory;
import com.hxoim.kettle.directory.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @desc: kettle目录
 * @author: lijing
 * @date: 2019/7/17
 */
@RestController
@RequestMapping("/directory")
public class DirectoryController {
    @Autowired
    DirectoryService directoryService;

    /**
     * @desc: 目录列表
     * @author: lijing
     * @date: 2019/7/17
     */
    @RequestMapping("/selectDirectoryList")
    public Result selectDirectoryList() {
        List<Directory> directorieList = directoryService.selectDirectoryList();
        return Result.success(directorieList);
    }
}
