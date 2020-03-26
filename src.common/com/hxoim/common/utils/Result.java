package com.hxoim.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author：sunqian
 * @desc：前端返回的实体类
 * @date：2019/5/27 11:14
 */
public class Result implements Serializable {

    public Result() {
    }

    /**
     * 返回的编码
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int code;

    /**
     * 返回的消息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msg;
    /**
     * 返回的数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    /**
     * 返回的token
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

    /**
     * 返回的token
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long total;

    public Long getTotal() {
        return total;
    }

    public Result setTotal(Long total) {
        this.total = total;
        return this;
    }

    public String getToken() {
        return token;
    }

    public Result setToken(String token) {
        this.token = token;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    /**
     * @ author：sunqian
     * @ desc：不带数据的返回的对象
     * @ date：2019/5/27 11:15
     */
    public static Result success() {
        Result result = new Result();
        result.setCode(Constants.SUCCESS);
        result.setMsg("操作成功");
        return result;
    }

    /**
     * @ author：sunqian
     * @ desc：带数据的返回对象
     * @ date：2019/5/27 11:16
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(Constants.SUCCESS);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }

    /**
     * @ author：sunqian
     * @ desc：处理错误的返回对象
     * @ date：2019/5/27 11:18
     */
    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(Constants.ERROR);
        result.setMsg(msg);
        return result;
    }
}
