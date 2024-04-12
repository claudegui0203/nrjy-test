package com.nari.jydw.jytest;

import com.nari.jydw.jytest.common.HttpResponse;
import com.nari.jydw.jytest.common.MainTestCases;
import com.nari.jydw.jytest.common.TestParametersUtil;
import com.nari.jydw.jytest.common.InterfaceEnum;
import com.nari.jydw.jytest.common.business.response.LoginResponse;
import com.nari.jydw.jytest.interfaceTest.actions.ActionHttpEnum;
import com.nari.jydw.jytest.interfaceTest.utils.*;
import org.apache.commons.httpclient.Header;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class CommonTestCases extends MainTestCases {
    private String token = "";

    @Parameters({ "LOCAL_CONFIG_FILE" })
    @BeforeSuite
    public void beforeSuite(String localConfigFile) {
        try {
            TestParametersUtil.getInstance().parseConfiguration(localConfigFile);
        } catch (IOException e) {
            LogUtil.error("beforeSuite::Analysis configuration file failed. message = " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @BeforeClass
    public void getTokenByLogin() {
        String tokenUrl = TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.LOGIN.getApi() + "?username=" + TestParametersUtil.getInstance().getTestParameters().getSiteUsername() + "&password=" + TestParametersUtil.getInstance().getTestParameters().getSitePassword();
        Header header = new Header("Content-Type", "application/json");
        HttpResponse httpResponse = null;
        try {
            httpResponse = HttpUtil.sendHttpRequest(ActionHttpEnum.POST, tokenUrl, "", new Header[] { header });
        } catch (IOException e) {
            LogUtil.error("getToken: Send delete request fail. Reason = " + e.getMessage());
        }

        for (int i = 0; i < 3; i++) {
            token = JsonUtil.getGson().fromJson(httpResponse.getResponseBody(), LoginResponse.class).getToken();
            if ((httpResponse.getStatusCode() == 200) && (! token.isEmpty())) {
                LogUtil.info("CommonTestCases::getToken: url = " + tokenUrl + ", response code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody() + ", token = " + token);
                return;
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                LogUtil.error("CommonTestCases::getToken: sleep error!");
            }
        }
    }

    protected Header[] generateHeaders() {
        if (this.token.isEmpty()) {
            Assert.fail("CommonTestCases::getToken: Token length is 0!!");
        }

        Header header1 = new Header("Content-Type", "application/json; charset=utf-8");
        Header header2 = new Header("Token", this.token);

        return new Header[] { header1, header2 };
    }

    @AfterTest
    public void teardown() {
        try {
            if (DBUtil.getInstance().getConnection() != null) {
                DBUtil.getInstance().getConnection().close();
            }

            if (DBUtil.getInstance().getStatement() != null) {
                DBUtil.getInstance().getStatement().close();
            }

            if (MqttUtil.getInstance().getMqttClient() != null) {
                MqttUtil.getInstance().getMqttClient().disconnect();
                MqttUtil.getInstance().getMqttClient().close();
            }
        } catch (SQLException | MqttException e) {
            LogUtil.error("teardown::Release DB connection fail. message = " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String getToken() {
        return this.token;
    }
}
