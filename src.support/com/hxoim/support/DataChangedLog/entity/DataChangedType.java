package com.hxoim.support.DataChangedLog.entity;/*
 * @description:
 * @author 杨波
 * @date:2019-06-10
 */

public enum DataChangedType {
    Add(1), Edit(2), Delete(3);

    private int dct;
    DataChangedType(int i) {
        dct=i;
    }
    public int getDataChangedType()
    {
        return dct;
    }

}