package com.nari.jydw.jytest.common;

public enum InterfaceEnum {

    LOGIN("/api/auth/login"),
    SAMPLELIST("/api/sample/sampleView/sampleList"),
    SAMPLELIBRARYBD("/statistics/sampleLibraryBd"),
    DELETESAMPLEMAIN("/api/sample/sampleView/deleteSampleMain"),
    DELETEUPLOAD("/api/sample/sampleView/deleteUpload"),
    REGISTER("/api/user/register"),
    UPDATEUSER("/api/user/update"),
    DELETEUSER("/api/user/del");


    private InterfaceEnum(String api) {
        this.api = api;
    }

    public String getApi() {
        return this.api;
    }

    private String api;
}
