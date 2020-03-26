package com.hxoim.support.b01.mapper;

import com.hxoim.support.b01.entity.B02;

/**
 * @ description：机构编制Mapper接口
 * @ author：张乾
 * @ createDate ： 2019/6/6 10:59
 */
public interface B02Mapper {

    B02 selectB02Byb0111(String b0111);

    void updateB02(B02 b02);

    void deleteB02(String b0111);

    void insertB02(B02 b02);
}
