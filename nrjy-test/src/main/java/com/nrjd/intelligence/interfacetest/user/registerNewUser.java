package com.nrjd.intelligence.interfacetest.user;

import com.nrjd.common.util.*;
import com.nrjd.intelligence.business.body.InterfaceEnum;
import com.nrjd.intelligence.business.body.register;
import com.nrjd.intelligence.business.response.responseBody;
import com.nrjd.intelligence.interfacetest.CommonTestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class registerNewUser extends CommonTestCases {

    @Test
    public void registerUser() throws SQLException, NoSuchFieldException, IllegalAccessException {
        String testUrl = TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.REGISTER.getApi();

        register register = new register();
        List<String> roleNames = new ArrayList<>();
        List<Integer> roleIds = new ArrayList<>();

        roleNames.add("sadmin");
        roleIds.add(queryIdByUsername("sadmin"));

        String username = usernameWithoutDuplication();
        register.setUsername(username);
        register.setPassword(generateString());
        register.setCompany(generateString());
        register.setRealName(generateString());
        register.setPhone("13956055180");
        register.setRoleIds(roleIds);
        register.setRoleNames(roleNames);
        register.setIsDisplay("0");

        LogUtil.info("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(register));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(register), generateHeaders());
        LogUtil.info("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);

        verifyHttpResponseBodyUtil.getInstance().verifyField(new responseBody(), httpResponse.getResponseBody(), "code", 202);



    }

    private int queryIdByUsername(String username) throws SQLException {
        int id = 0;
        ResultSet resultSet = queryDB();
        while (resultSet.next()) {
            if (resultSet.getString("username").equals(username)) {
                id = resultSet.getInt("id");
                break;
            }
        }

        return id;
    }

    private String queryUsernameById(int id) throws SQLException {
        String username = "";
        ResultSet resultSet = queryDB();
        while (resultSet.next()) {
            if (resultSet.getInt("id") == id) {
                username = resultSet.getString("username");
                break;
            }
        }

        return username;
    }

    private ResultSet queryDB() throws SQLException {
        return DBUtil.getInstance().ExecuteSql("SELECT * FROM tb_sys_user");
    }

    private String generateString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*,.";
        Random random = new Random();
        StringBuffer username = new StringBuffer();
        for (int i=0; i < random.nextInt(129); i++){
            int number=random.nextInt(62);
            username.append(str.charAt(number));
        }

        return username.toString();
    }

    private String usernameWithoutDuplication() throws SQLException {
        while (true) {
            String username = generateString();
            if (queryIdByUsername(generateString()) == 0) {
                return username;
            }
        }
    }
}
