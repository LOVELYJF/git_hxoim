package com.hxoim.work.workinfo.service;

import com.hxoim.work.workinfo.entity.WorkProce;
import com.hxoim.work.workinfo.entity.WorkResponsible;

import java.util.List;

public interface WorkResponsibleService {

    /**
     * 新增工作责任
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    int insertWorkResponsible(WorkResponsible workResponsible);

    /**
     * 删除工作责任
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    int deleteByPrimaryKey(String id);

    /**
     * 修改工作责任
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    int updateWorkResponsible(WorkResponsible workResponsible);

    /**
     * 修改工作责任(可单项修改)
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    int updateByPrimaryKeySelective(WorkResponsible workResponsible);

    /**
     * 查询工作责任列表（根据userId）
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    List<WorkResponsible> selectListByUserId(String id);

    /**
     * 查询工作责任列表（根据我的工作Id）
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    List<WorkResponsible> selectListByWorkInfoId(String id);

    /**
     * 查询工作责任列表（根据我的工作Id）
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    List<WorkResponsible> selectAllListByWorkInfoId(String id);

    /**
     * 查询工作责任详情
     * @author gaozhenyuan
     * @date 2019/12/25 14:23
     */
    WorkResponsible selectWorkResponsibleById(String id);
    /**
    * @Author: jiayiwen
    * @Description:通过id修改状态
    * @Date: 15:30 2020/1/9
     */
    void updateStatusById(String id);
    /**
    * @Author: jiayiwen
    * @Description:添加过程
    * @Date: 15:35 2020/1/9
     */
    void insertWorkProce(WorkProce workProce);
    /**
    * @Author: jiayiwen
    * @Description:全部下发
    * @Date: 15:18 2020/1/10
     */
    void updateStatusByIds(String ids);
    /**
    * @Author: jiayiwen
    * @Description:确认
    * @Date: 11:14 2020/1/15
     */
    void updateByStatusSelective(WorkResponsible workResponsible);
}
