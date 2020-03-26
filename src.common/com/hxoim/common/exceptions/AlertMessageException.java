package com.hxoim.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author sunqian
 * @Description 抛出异常向前端提示信息
 * @Date 16:56 2019/6/5
 */
public class AlertMessageException extends RuntimeException {

    public AlertMessageException() {
        super();
    }

    public AlertMessageException(String message) {
        super(message);
    }

    public AlertMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlertMessageException(Throwable cause) {
        super(cause);
    }

    protected AlertMessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
