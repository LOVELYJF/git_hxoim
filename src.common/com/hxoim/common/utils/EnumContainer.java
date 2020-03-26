package com.hxoim.common.utils;

/*
 * @description:枚举存放处
 * @author 杨波
 * @date:2019-07-18
 */
public class EnumContainer {
    /**
     * @description:代表ETL产生的异常数据状态
     * @author:杨波
     * @date:2019-07-18
     **/
    public enum EWrongRecordState {
        wrsNew,//新产生的异常
        wrsSendMessage,//已经发送消息的异常数据
        wrsDealed//已经处理过的异常数据
    }

    /**
     * @description:操作日志的操作类型
     * @author:杨波
     * @date:2019-08-03
     **/
    public enum EOperateType {
        otNew("新增", 1),
        otEdit("修改", 2),
        otDel("删除", 3),
        otSearch("查询", 4),
        otPrint("打印", 5),
        otExport("导出", 6),
        otImport("导入", 7),
        otDownload("下载", 8),
        otOpenUrl("打开页面", 9),
        otLogin("登录", 10),
        otLogout("退出", 11);

        private String name;
        private int index;

        private EOperateType(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public static String getName(int index) {
            for (EOperateType ot : EOperateType.values()) {
                if (ot.getIndex() == index) {
                    return ot.name;
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }

        public void setName(String val) {
            this.name = val;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}

