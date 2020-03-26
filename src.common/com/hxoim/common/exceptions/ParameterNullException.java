package com.hxoim.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author: sunqian
 * @desc: 参数空异常
 * @date: 2019/5/27 13:57
 */
public class ParameterNullException extends RuntimeException {

    public ParameterNullException(String message) {
        super(message);
    }

    public ParameterNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterNullException(Throwable cause) {
        super(cause);
    }

    protected ParameterNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
