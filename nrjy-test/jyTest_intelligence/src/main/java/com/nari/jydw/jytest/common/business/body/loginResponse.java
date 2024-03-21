package com.nari.jydw.jytest.common.business.body;


import com.nari.jydw.jytest.interfaceTest.utils.JsonUtil;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class loginResponse {
    private int code = 0;
    private String msg = "";
    private data data;

    @Override
    public String toString() {
        return JsonUtil.getGson().toJson(this);
    }

    public String getToken() {
        return data.getToken();
    }
}

@Setter
@Getter
class data {
    userInfo userInfo;
    String token = "";
    String type = "";
    String roleName = "";
    String roleId = "";
    String realName = "";
}

@Setter
@Getter
class userInfo {
    int id = 0;
    String username = "";
}