package com.hxoim.support.b01.service;

import com.hxoim.support.b01.entity.B02;

/**
 * @ description：机构编制Service
 * @ author：张乾
 * @ createDate ： 2019/6/6 11:01
 */
public interface B02Service {

    B02 selectB02Byb0111(String b0111);

    void updateB02(B02 b02);

    void deleteB02(String b0111);

    void insertB02(B02 b02);
}
