package com.hxoim.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "用户身份校验失败")
public class UserCheckException extends RuntimeException {

    public UserCheckException() {
    }

    public UserCheckException(String message) {
        super(message);
    }

    public UserCheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserCheckException(Throwable cause) {
        super(cause);
    }

    public UserCheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
