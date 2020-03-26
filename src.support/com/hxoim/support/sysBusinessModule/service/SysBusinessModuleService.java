package com.hxoim.support.sysBusinessModule.service;

import com.hxoim.common.tree.Tree;
import com.hxoim.support.sysBusinessModule.entity.SysBusinessModule;

import java.util.List;

public interface SysBusinessModuleService {
    /**
     *
     * @return
     */
    public abstract List<SysBusinessModule> selectSysBusinessModuleByPid(String pid);

    /**
     *
     * @param id
     * @return
     */
    public abstract SysBusinessModule selectSysBusinessModuleById(String id);

    /**
     *
     * @param sysBusinessModule
     */
    public abstract void insertSysBusinessModule(SysBusinessModule sysBusinessModule);

    /**
     *
     * @param sysBusinessModule
     */
    public abstract void updateSysBusinessModule(SysBusinessModule sysBusinessModule);

    /**
     *
     * @param id
     */
    public abstract void deleteSysBusinessModule(String id);

    /**
     *
     * @return
     */
    public abstract List<Tree> selectSysBusinessModuleTree(String systemId);

    /**
     *
     * @param ids
     */
    public abstract void updateSortSysBusinessModule(String ids[]);
}
