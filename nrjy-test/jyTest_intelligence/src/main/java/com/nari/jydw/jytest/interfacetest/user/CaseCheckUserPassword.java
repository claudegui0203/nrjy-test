package com.nari.jydw.jytest.interfacetest.user;

import com.nari.jydw.jytest.CommonTestCases;
import com.nari.jydw.jytest.common.InterfaceEnum;
import com.nari.jydw.jytest.common.TestParametersUtil;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CaseCheckUserPassword extends CommonTestCases {

    @Test
    public void UserNotExist() {
//        Map<String, String> parameter = new HashMap<>();
//        parameter.put("id", "12344");
//        parameter.put("password", "123456");


        given().log().all()
                .header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8").header("token", getToken())
//                .body(parameter).
        .param("id", "12344").param("password", "123456").
        when()
                .post(TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.CHECKUSERPASSWD.getApi()).
        then()
                .log().all()
                .statusCode(200);
//                .body("code", is(200))
//                .body("msg", is("校验用户名是否可用成功"))
//                .body("data", is(true));
    }
}
