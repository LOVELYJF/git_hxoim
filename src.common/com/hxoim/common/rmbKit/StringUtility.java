package com.hxoim.common.rmbKit;

public class StringUtility {

    public static boolean IsNullOrEmpty(String strobj) {
        if (strobj != null && !strobj.equals("")) {
            return false;
        } else {
            return true;
        }
    }
}
