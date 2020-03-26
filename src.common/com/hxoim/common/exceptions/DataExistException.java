package com.hxoim.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author sunqian
 * @Description 提示需要保存的数据已经存在或者不需要保存的提示
 * @Date 16:57 2019/6/5
 */
public class DataExistException extends RuntimeException {

    public DataExistException() {
        super();
    }

    public DataExistException(String message) {
        super(message);
    }

    public DataExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataExistException(Throwable cause) {
        super(cause);
    }

    protected DataExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
