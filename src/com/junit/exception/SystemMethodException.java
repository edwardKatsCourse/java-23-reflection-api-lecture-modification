package com.junit.exception;

import com.junit.SystemMethod;

public class SystemMethodException extends GeneralAPIException{

    public SystemMethodException(SystemMethod systemMethod, Throwable e) {
        super(String.format("Exception thrown from method [%s]. Exception: %s", systemMethod.name(), e));
    }
}
