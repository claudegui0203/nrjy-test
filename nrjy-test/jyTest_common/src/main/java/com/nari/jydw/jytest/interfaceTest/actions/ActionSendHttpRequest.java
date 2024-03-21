package com.nari.jydw.jytest.interfaceTest.actions;

import com.nari.jydw.jytest.common.HttpResponse;
import com.nari.jydw.jytest.common.HttpStatusEnum;
import com.nari.jydw.jytest.interfaceTest.utils.HttpUtil;
import com.nari.jydw.jytest.interfaceTest.utils.JsonUtil;
import com.nari.jydw.jytest.interfaceTest.utils.LogUtil;
import com.nari.jydw.jytest.interfaceTest.utils.verifyHttpResponseBodyUtil;
import org.apache.commons.httpclient.Header;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ActionSendHttpRequest extends AbstractTestAction {
    private ActionHttpEnum paramHttpProtocol = ActionHttpEnum.POST;
    private String paramRequestUrl = "";
    private Header[] paramRequestHeader;
    private Object paramRequestBody;
    private String paramBody = "";
    private HttpResponse httpResponse;
    private HttpStatusEnum expectedStatusCode;
    private Object expectedBodyObject;
    private Map<String, Object> expectedField = new HashMap<>();

    @Override
    protected void prepareParameters() {
        if ((this.paramRequestUrl == null) || (this.paramRequestUrl.isEmpty())) {
            Assert.fail("ActionSendHttpRequest: paramRequestUrl cannot be null or empty!!!");
        }

        if (this.paramRequestBody != null) {
            paramBody = JsonUtil.getGson().toJson(this.paramRequestBody);
        }
    }

    @Override
    protected void sendRequest() {
        LogUtil.info("ActionSendHttpRequest: Test url = " + this.paramRequestUrl + ". Header = " + paramRequestHeader.toString() + " and Request body = " + paramBody);
        switch (this.paramHttpProtocol) {
            case POST:
                httpResponse = HttpUtil.post(paramRequestUrl, paramBody, paramRequestHeader);
                break;
            case GET:
                httpResponse = HttpUtil.get(paramRequestUrl, paramBody, paramRequestHeader);
                break;
            case PUT:
                httpResponse = HttpUtil.put(paramRequestUrl, paramBody, paramRequestHeader);
                break;
            case DELETE:
                try {
                    httpResponse = HttpUtil.delete(paramRequestUrl, paramBody, paramRequestHeader);
                } catch (IOException e) {
                    LogUtil.error("sendRequest: Send delete request fail. Reason = " + e.getMessage());
                }
                break;
        }

        actionResult.put("statusCode", httpResponse.getStatusCode());
        actionResult.put("responseBody", httpResponse.getResponseBody());
        LogUtil.info("ActionSendHttpRequest: Test response status code = " + httpResponse.getStatusCode() + " and response body = " + httpResponse.getResponseBody());
    }

    @Override
    protected void verify() {
        Assert.assertEquals(httpResponse.getStatusCode(), this.expectedStatusCode.getCode());

        expectedField.forEach((key, value) -> {
            try {
                verifyHttpResponseBodyUtil.getInstance().verifyField(expectedBodyObject, httpResponse.getResponseBody(), key, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                Assert.fail("ActionSendHttpRequest::Verify http response fail. Reason = " + e.getMessage());
            }
        });
    }
}
