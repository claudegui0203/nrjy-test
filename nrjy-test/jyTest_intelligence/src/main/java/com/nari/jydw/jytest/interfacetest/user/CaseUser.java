package com.nari.jydw.jytest.interfacetest.user;

import com.nari.jydw.jytest.common.InterfaceEnum;
import com.nari.jydw.jytest.common.TestParametersUtil;
import com.nari.jydw.jytest.common.business.body.Del;
import com.nari.jydw.jytest.common.business.body.Register;
import com.nari.jydw.jytest.common.business.response.SearchUserResponseBody;
import com.nari.jydw.jytest.interfaceTest.utils.JsonUtil;
import com.nari.jydw.jytest.interfaceTest.utils.LogUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CaseUser extends UserBusiness {
    private Register register = null;
    private Integer userId = 0;

    @Test
    public void registerNewUser() {
        this.register = generateUserInfo(new ArrayList<>(), new ArrayList<>());

        Response response = RestAssured.
        given().log().all()
                .header("Content-Type", "application/json; charset=utf-8").header("token", getToken())
                .body(JsonUtil.getGson().toJson(this.register)).
        when()
                .post(TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.REGISTER.getApi()).
        then()
                .statusCode(200)
                .body("code", is(200))
                .body("msg", is("用户注册成功"))
                .log().all().extract().response();

        userId = response.jsonPath().get("data");
        LogUtil.info("user id = " + userId);
    }

    @Test
    public void searchUser() {
        Response response = (Response) RestAssured.
        given().log().all()
                .header("Content-Type", "application/json; charset=utf-8").header("token", getToken())
                .param("pageNum", 1).param("pageSize", 25).param("search", "5YzMiCE0VlEKKmc").
        when()
                .get(TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.QUERYUSER.getApi()).
        then()
                .log().body()
                .statusCode(200)
                .body("code", is(200))
                .body("msg", is("用户列表查询成功")).extract();

        Assert.assertEquals((Integer) response.jsonPath().get("data.total"), response.jsonPath().getList("data.items").size());
        verifySearchUserResponseBody(response, this.register, response.jsonPath().get("data.total"), userId);


    }

    @Test
    public void deleteUser() {
        Del del = new Del();
        List<Long> ids = new ArrayList<>();
        ids.add(this.userId.longValue());

        given()
                .header("Content-Type", "application/json; charset=utf-8").header("token", getToken())
                .body(JsonUtil.getGson().toJson(del)).
        when()
                .delete(TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.DELETEUSER.getApi()).
        then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("msg", is("删除用户成功"));
    }
}
