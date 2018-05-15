package com.junit;

public enum SystemMethod {

    BEFORE("before"),
    AFTER("after");

    private String methodName;

    SystemMethod(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public static SystemMethod getByName(String name) {
        if (name == null) {
            return null;
        }

        for (SystemMethod systemMethod : values()) {
            if (systemMethod.getMethodName().equals(name)) {
                return systemMethod;
            }
        }

        return null;
    }
}
