package com.hxoim.support.DataChangedLog.entity;
/*
 * @description:
 * @author 杨波
 * @date:2019-06-10
 */
public enum OperatorType {
    Add(1), Edit(2), Delete(3),Search(4),Print(5),Export(6),Import(7),Download(8),OpenForm(9),Login(10),Logout(11);

    private  int ot=1;
    OperatorType(int i) {
        ot=i;
    }
    public int getOperatorType()
    {
        return ot;
    }
}

