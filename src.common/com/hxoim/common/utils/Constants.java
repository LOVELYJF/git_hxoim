package com.hxoim.common.utils;

public class Constants {


    // 任免表导出模板路径
    public static final String TEMPLATE = "template";

    // 任免表导出文件存放路径
    public static final String RMB_EXPORT_PATH = "exportTableFile";

    public static final int PAGE_SIZE = 20;

    /**
     * 人员照片存放路径
     */
    public static final String PHOTOS_PATH = "/photos";
    /**人员文件存储路径*/
    public static final String PERSON_FILE_PATH = "/upload/personFiles";

    /**
     * 成功返回值
     */
    public static final int SUCCESS = 0;
    /**
     * 失败返回值
     */
    public static final int ERROR = 1;

    /**
     * 默认重置密码123456
     */
    public static final String USER_PWD = "123456";
    /**
     * 请求头中的key
     */
    public static final String TOKEN_KEY = "hx-token";

    public static final String EXPIRE_TIMES = "expireTimes";
    /**
     * token过期时间
     */
    public static final String DEFAULT_PASS_MINS = "30";

    /***********************************************消息模块*************************************************/

    /**
     * 是否是根节点
     */
    public static String IS_ROOT = "1";
    public static final String Not_ROOT = "0";
    /**
     * 是否删除
     */
    public static String IS_DEL = "1";
    public static String NOT_DEL = "0";
    /**
     * 消息标识
     */
    /**
     * 个人
     */
    public static String PERSONAL = "1";
    /**
     * 处室
     */
    public static String DEPARTMENT = "2";
    /**
     * 机构
     */
    public static String ORGANIZATION = "3";
    /**
     * 讨论组
     */
    public static String DISCUSSIONGROUP = "4";
    /**
     * 处理状态
     */
    /**
     * 历史消息
     */
    public static String HISTORY_MESSAGE = "1";
    /**
     * 未处理消息
     */
    public static String NOT_HANDLE_MESSAGE = "0";
    /**
     * 发送类别
     */
    /**
     * 普通消息
     */
    public static String GENERAL_MESSAGE = "1";
    /**
     * 讨论组消息
     */
    public static String DISCUSSION_MESSAGE = "2";
    /**
     * 是否置顶
     */
    /**
     * 置顶
     */
    public static String IS_TOP = "1";
    /**
     * 未置顶
     */
    public static String NOT_TOP = "0";
    /**
     * 发件箱or收件箱
     */
    /**
     * 发件箱
     */
    public static String RECEIVE = "receive";
    /**
     * 收件箱
     */
    public static String SEND = "send";
    public static final String START_PAGE = "/index.jsp";
    /**
     * 干部类别
     */
    public static String LEADER_TYPE = "LeaderType";
    /**
     * 用户类型(0-管理员;1-普通用户)
     */
    public static String[] USER_TYPES = {"0", "1"};
    /**
     * 人员信息集
     */
    public static String PERSON_INFO = "person_infos";
}
