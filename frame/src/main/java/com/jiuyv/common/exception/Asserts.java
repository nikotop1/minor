package com.jiuyv.common.exception;

import com.jiuyv.common.api.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 * Created by 
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
