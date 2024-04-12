package com.nari.jydw.jytest.interfacetest.user;

import com.nari.jydw.jytest.CommonTestCases;
import com.nari.jydw.jytest.common.InterfaceEnum;
import com.nari.jydw.jytest.common.TestParametersUtil;
import com.nari.jydw.jytest.common.business.body.Register;
import com.nari.jydw.jytest.common.business.response.SearchUserResponseBody;
import com.nari.jydw.jytest.interfaceTest.utils.JsonUtil;
import com.nari.jydw.jytest.interfaceTest.utils.LogUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class UserBusiness extends CommonTestCases {
    public String generateString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*,.";
        Random random = new Random();
        StringBuffer username = new StringBuffer();
        for (int i=0; i < random.nextInt(129); i++) {
            int number=random.nextInt(62);
            username.append(str.charAt(number));
        }

        return username.toString();
    }

    public String generatePhoneNumber() {
        String str = "0123456789";
        Random random = new Random();
        StringBuffer phoneNumber = new StringBuffer();
        for (int i=0; i < random.nextInt(11); i++){
            int number=random.nextInt(10);
            phoneNumber.append(str.charAt(number));
        }

        return phoneNumber.toString();
    }

    public Register generateUserInfo(List<String> roleNames, List<Integer> roleIds) {
        if ((roleNames.isEmpty()) || (roleIds.isEmpty())) {
            roleNames.add("超级管理员");
            roleIds.add(5);
        }

        Register register = new Register();
        String username = generateUsername();
        register.setUsername(username);
        register.setPassword(generateString());
        register.setCompany(generateString());
        register.setRealName(generateString());
        register.setPhone(generatePhoneNumber());
        register.setRoleIds(roleIds);
        register.setRoleNames(roleNames);
        register.setIsDisplay("0");
        register.setStatus("1");

        return register;
    }

    public Boolean userIsExist(String username) {
        Response response = RestAssured
                .given()
                    .header("Content-Type", "application/json; charset=utf-8").header("token", getToken())
                    .param("username", username)
                .when()
                    .get(TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.CHECKUSERNAME.getApi()).
                then()
                    .log().all().
                    extract().response();

        LogUtil.info("Body = " + response.jsonPath().get("data"));
        return response.jsonPath().get("data");
    }

    private String generateUsername() {
        while (true) {
            String username = generateString();
            if (userIsExist(username)) {
                return username;
            }
        }
    }

    public void verifySearchUserResponseBody(ResponseBody responseBody, Register register, int total, Integer userId) {
        List<Map<String, Object>> items = responseBody.jsonPath().getList("data.items");
        for (int i = 0; i < total; i++) {
            Map<String, Object> item = items.get(i);
            if ((Objects.equals(item.get("id"), userId)) && (item.get("username").equals(register.getUsername()))) {
                Assert.assertEquals(item.get("realName"), register.getRealName());
                Assert.assertEquals(item.get("company"), register.getCompany());
                Assert.assertEquals(item.get("phone"), register.getPhone());
                Assert.assertEquals(item.get("sysType"), register.getIsDisplay());
                Assert.assertEquals(item.get("roleName"), register.getRoleNames().get(0));
            }
        }
    }
}
