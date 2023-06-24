package com.choucair.utils;

public enum ReqresResources {
    API_BASE_URL("https://dummy.restapiexample.com/api/v1/"),
    GET_EMPLEADO_RESOURCE("employee/");

    private final String  value;

    ReqresResources(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
