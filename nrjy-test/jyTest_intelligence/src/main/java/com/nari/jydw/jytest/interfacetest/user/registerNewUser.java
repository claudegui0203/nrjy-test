package com.nari.jydw.jytest.interfacetest.user;

import com.nari.jydw.jytest.CommonTestCases;
import com.nari.jydw.jytest.common.HttpStatusEnum;
import com.nari.jydw.jytest.common.business.body.InterfaceEnum;
import com.nari.jydw.jytest.common.business.body.del;
import com.nari.jydw.jytest.common.business.body.register;
import com.nari.jydw.jytest.common.business.response.responseBody;
import com.nari.jydw.jytest.interfaceTest.actions.ActionBuilder;
import com.nari.jydw.jytest.interfaceTest.actions.ActionHttpEnum;
import com.nari.jydw.jytest.interfaceTest.actions.ActionParameterBuilderMap4Http;
import com.nari.jydw.jytest.interfaceTest.actions.ActionSendHttpRequest;
import com.nari.jydw.jytest.interfaceTest.utils.DBUtil;
import com.nari.jydw.jytest.interfaceTest.utils.JsonUtil;
import com.nari.jydw.jytest.common.TestParametersUtil;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class registerNewUser extends CommonTestCases {
    private List<Long> userIds = new ArrayList<>();

    @Test(priority=1)
    public void registerUser() throws SQLException, NoSuchFieldException, IllegalAccessException, InterruptedException {
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
        register.setPhone(generatePhoneNumber());
        register.setRoleIds(roleIds);
        register.setRoleNames(roleNames);
        register.setIsDisplay("0");

        verifyActionResult.put("code", 200);

        ActionSendHttpRequest actionSendHttpRequest = ActionBuilder.createActionParameterBuilder(ActionParameterBuilderMap4Http.ACTION_SEND_HTTP_REQUEST)
                .paramRequestUrl(testUrl).paramHttpProtocol(ActionHttpEnum.POST).paramRequestHeader(generateHeaders()).paramRequestBody(register)
                .expectedStatusCode(HttpStatusEnum.OK).expectedBodyObject(new responseBody()).expectedField(verifyActionResult)
                .buildAction();
        actionSendHttpRequest.perform();

        String httpResponseBody = (String) actionSendHttpRequest.getResult("responseBody");
        responseBody responseBody = JsonUtil.getGson().fromJson(httpResponseBody, responseBody.class);
        userIds.add(responseBody.getData());

        verifyCaseResult.put("id", userIds.get(0));
        verifyCaseResult.put("username", register.getUsername());
        verifyCaseResult.put("phone", register.getPhone());
        verifyCaseResult.put("role_name", register.getRoleNames().get(0));
        verifyCaseResult.put("company", register.getCompany());

        ActionBuilder.createActionParameterBuilder(ActionParameterBuilderMap4Http.ACTION_QUERY_DB_REQUEST)
                .paramTableName("tb_sys_user")
                .expectedIsResultExist(true).expectedField(verifyCaseResult)
                .buildAction()
                .perform();
    }

    @Test(priority=1)
    public void usernameIsNull() throws SQLException, NoSuchFieldException, IllegalAccessException, InterruptedException {
        String testUrl = TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.REGISTER.getApi();

        register register = new register();
        List<String> roleNames = new ArrayList<>();
        List<Integer> roleIds = new ArrayList<>();

        roleNames.add("sadmin");
        roleIds.add(queryIdByUsername("sadmin"));

        register.setUsername(null);
        register.setPassword(generateString());
        register.setCompany(generateString());
        register.setRealName(generateString());
        register.setPhone(generatePhoneNumber());
        register.setRoleIds(roleIds);
        register.setRoleNames(roleNames);
        register.setIsDisplay("0");

        verifyActionResult.put("code", 400);

        ActionBuilder.createActionParameterBuilder(ActionParameterBuilderMap4Http.ACTION_SEND_HTTP_REQUEST)
                .paramRequestUrl(testUrl).paramHttpProtocol(ActionHttpEnum.POST).paramRequestHeader(generateHeaders()).paramRequestBody(register)
                .expectedStatusCode(HttpStatusEnum.OK).expectedBodyObject(new responseBody()).expectedField(verifyActionResult)
                .buildAction()
                .perform();

        ActionBuilder.createActionParameterBuilder(ActionParameterBuilderMap4Http.ACTION_QUERY_DB_REQUEST)
                .paramTableName("tb_sys_user")
                .expectedIsResultExist(false).expectedField(verifyCaseResult)
                .buildAction()
                .perform();
    }

    @Test(priority=1)
    public void passwordIsNull() throws SQLException, NoSuchFieldException, IllegalAccessException, InterruptedException {
        String testUrl = TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.REGISTER.getApi();

        register register = new register();
        List<String> roleNames = new ArrayList<>();
        List<Integer> roleIds = new ArrayList<>();

        roleNames.add("sadmin");
        roleIds.add(queryIdByUsername("sadmin"));

        String username = usernameWithoutDuplication();
        register.setUsername(username);
        register.setPassword(null);
        register.setCompany(generateString());
        register.setRealName(generateString());
        register.setPhone(generatePhoneNumber());
        register.setRoleIds(roleIds);
        register.setRoleNames(roleNames);
        register.setIsDisplay("0");

        verifyActionResult.put("code", 400);

        ActionBuilder.createActionParameterBuilder(ActionParameterBuilderMap4Http.ACTION_SEND_HTTP_REQUEST)
                .paramRequestUrl(testUrl).paramHttpProtocol(ActionHttpEnum.POST).paramRequestHeader(generateHeaders()).paramRequestBody(register)
                .expectedStatusCode(HttpStatusEnum.OK).expectedBodyObject(new responseBody()).expectedField(verifyActionResult)
                .buildAction()
                .perform();

        ActionBuilder.createActionParameterBuilder(ActionParameterBuilderMap4Http.ACTION_QUERY_DB_REQUEST)
                .paramTableName("tb_sys_user")
                .expectedIsResultExist(false).expectedField(verifyCaseResult)
                .buildAction()
                .perform();
    }

    @Test(priority=1)
    public void companyIsNull() throws SQLException, NoSuchFieldException, IllegalAccessException, InterruptedException {
        String testUrl = TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.REGISTER.getApi();

        register register = new register();
        List<String> roleNames = new ArrayList<>();
        List<Integer> roleIds = new ArrayList<>();

        roleNames.add("sadmin");
        roleIds.add(queryIdByUsername("sadmin"));

        String username = usernameWithoutDuplication();
        register.setUsername(username);
        register.setPassword(generateString());
        register.setCompany(null);
        register.setRealName(generateString());
        register.setPhone(generatePhoneNumber());
        register.setRoleIds(roleIds);
        register.setRoleNames(roleNames);
        register.setIsDisplay("0");

        verifyActionResult.put("code", 200);

        ActionSendHttpRequest actionSendHttpRequest = ActionBuilder.createActionParameterBuilder(ActionParameterBuilderMap4Http.ACTION_SEND_HTTP_REQUEST)
                .paramRequestUrl(testUrl).paramHttpProtocol(ActionHttpEnum.POST).paramRequestHeader(generateHeaders()).paramRequestBody(register)
                .expectedStatusCode(HttpStatusEnum.OK).expectedBodyObject(new responseBody()).expectedField(verifyActionResult)
                .buildAction();
        actionSendHttpRequest.perform();

        String httpResponseBody = (String) actionSendHttpRequest.getResult("responseBody");
        responseBody responseBody = JsonUtil.getGson().fromJson(httpResponseBody, responseBody.class);
        userIds.add(responseBody.getData());

        verifyCaseResult.put("id", userIds.get(0));
        verifyCaseResult.put("username", register.getUsername());
        verifyCaseResult.put("phone", register.getPhone());
        verifyCaseResult.put("role_name", register.getRoleNames().get(0));
        verifyCaseResult.put("company", register.getCompany());

        ActionBuilder.createActionParameterBuilder(ActionParameterBuilderMap4Http.ACTION_QUERY_DB_REQUEST)
                .paramTableName("tb_sys_user")
                .expectedIsResultExist(true).expectedField(verifyCaseResult)
                .buildAction()
                .perform();
    }

    @Test(priority=1)
    public void realNameIsNull() throws SQLException, NoSuchFieldException, IllegalAccessException, InterruptedException {
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
        register.setRealName(null);
        register.setPhone(generatePhoneNumber());
        register.setRoleIds(roleIds);
        register.setRoleNames(roleNames);
        register.setIsDisplay("0");

        verifyActionResult.put("code", 200);

        ActionSendHttpRequest actionSendHttpRequest = ActionBuilder.createActionParameterBuilder(ActionParameterBuilderMap4Http.ACTION_SEND_HTTP_REQUEST)
                .paramRequestUrl(testUrl).paramHttpProtocol(ActionHttpEnum.POST).paramRequestHeader(generateHeaders()).paramRequestBody(register)
                .expectedStatusCode(HttpStatusEnum.OK).expectedBodyObject(new responseBody()).expectedField(verifyActionResult)
                .buildAction();
        actionSendHttpRequest.perform();

        String httpResponseBody = (String) actionSendHttpRequest.getResult("responseBody");
        responseBody responseBody = JsonUtil.getGson().fromJson(httpResponseBody, responseBody.class);
        userIds.add(responseBody.getData());

        verifyCaseResult.put("id", userIds.get(0));
        verifyCaseResult.put("username", register.getUsername());
        verifyCaseResult.put("phone", register.getPhone());
        verifyCaseResult.put("role_name", register.getRoleNames().get(0));
        verifyCaseResult.put("company", register.getCompany());

        ActionBuilder.createActionParameterBuilder(ActionParameterBuilderMap4Http.ACTION_QUERY_DB_REQUEST)
                .paramTableName("tb_sys_user")
                .expectedIsResultExist(true).expectedField(verifyCaseResult)
                .buildAction()
                .perform();
    }

    @Test(priority=1)
    public void realNameIsEmpty() throws SQLException {
        String testUrl = TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.REGISTER.getApi();

        register register = new register();
        List<String> roleNames = new ArrayList<>();
        List<Integer> roleIds = new ArrayList<>();

        roleNames.add("sadmin");
        roleIds.add(queryIdByUsername("sadmin"));

        register.setUsername("");
        register.setPassword(generateString());
        register.setCompany(generateString());
        register.setRealName(generateString());
        register.setPhone(generatePhoneNumber());
        register.setRoleIds(roleIds);
        register.setRoleNames(roleNames);
        register.setIsDisplay("0");

        verifyActionResult.put("code", 200);

        ActionSendHttpRequest actionSendHttpRequest = ActionBuilder.createActionParameterBuilder(ActionParameterBuilderMap4Http.ACTION_SEND_HTTP_REQUEST)
                .paramRequestUrl(testUrl).paramHttpProtocol(ActionHttpEnum.POST).paramRequestHeader(generateHeaders()).paramRequestBody(register)
                .expectedStatusCode(HttpStatusEnum.OK).expectedBodyObject(new responseBody()).expectedField(verifyActionResult)
                .buildAction();
        actionSendHttpRequest.perform();

        String httpResponseBody = (String) actionSendHttpRequest.getResult("responseBody");
        responseBody responseBody = JsonUtil.getGson().fromJson(httpResponseBody, responseBody.class);
        userIds.add(responseBody.getData());

        verifyCaseResult.put("id", userIds.get(0));
        verifyCaseResult.put("username", register.getUsername());
        verifyCaseResult.put("phone", register.getPhone());
        verifyCaseResult.put("role_name", register.getRoleNames().get(0));
        verifyCaseResult.put("company", register.getCompany());

        ActionBuilder.createActionParameterBuilder(ActionParameterBuilderMap4Http.ACTION_QUERY_DB_REQUEST)
                .paramTableName("tb_sys_user")
                .expectedIsResultExist(true).expectedField(verifyCaseResult)
                .buildAction()
                .perform();
    }



    @Test(priority=2)
    public void deleteUser() {
        String testUrl = TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.DELETEUSER.getApi();

        del del = new del();
        del.setIds(userIds);

        verifyActionResult.put("code", 200);
        ActionBuilder.createActionParameterBuilder(ActionParameterBuilderMap4Http.ACTION_SEND_HTTP_REQUEST)
                .paramRequestUrl(testUrl).paramHttpProtocol(ActionHttpEnum.DELETE).paramRequestHeader(generateHeaders()).paramRequestBody(del)
                .expectedStatusCode(HttpStatusEnum.OK).expectedBodyObject(new responseBody()).expectedField(verifyActionResult)
                .buildAction()
                .perform();

        AtomicReference<String> sql = new AtomicReference<>("SELECT * FROM tb_sys_user WHERE ");
        AtomicBoolean isFirst = new AtomicBoolean(true);
        userIds.forEach(userId -> {
            isFirst.set(false);
            sql.set(mergeQuerySql(sql.get(), userId, isFirst.get()));
            verifyCaseResult.put("id", userId);});

        ActionBuilder.createActionParameterBuilder(ActionParameterBuilderMap4Http.ACTION_QUERY_DB_REQUEST)
                .paramSql(String.valueOf(sql))
                .expectedIsResultExist(false).expectedField(verifyCaseResult)
                .buildAction()
                .perform();
    }

    private String mergeQuerySql(String sql, Long userId, boolean isFirst) {
        if (! isFirst) {
            sql = sql + "id=" + userId;
        } else {
            sql = sql + " OR id=" + userId;
        }

        return sql;
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

        resultSet.close();
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

    private String generatePhoneNumber() {
        String str = "0123456789";
        Random random = new Random();
        StringBuffer phoneNumber = new StringBuffer();
        for (int i=0; i < random.nextInt(11); i++){
            int number=random.nextInt(10);
            phoneNumber.append(str.charAt(number));
        }

        return phoneNumber.toString();
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
