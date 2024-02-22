package com.nrjd.common.action;

import com.nrjd.common.util.*;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class ActionSendHttpRequest extends AbstractHttpAction {
    private String paramBody = "";
    private HttpResponse httpResponse;
    private HttpStatusEnum paramExpectStatusCode;
    private Object paramVerifyBodyObject;
    private Map<String, Object> paramVerifyField = new HashMap<>();

    @Override
    protected void prepareHttpParameters() {
        if (this.paramRequestBody != null) {
            paramBody = JsonUtil.getGson().toJson(this.paramRequestBody);
        }
    }

    @Override
    protected void sendHttpRequest() {
        switch (this.paramHttpProtocol) {
            case POST:
                httpResponse = HttpUtil.post(this.paramRequestUrl, paramBody, this.paramRequestHeader);
            case GET:
                httpResponse = HttpUtil.get(this.paramRequestUrl, paramBody, this.paramRequestHeader);
            case PUT:
                httpResponse = HttpUtil.put(this.paramRequestUrl, paramBody, this.paramRequestHeader);
        }
    }

    @Override
    protected void verify() {
        Assert.assertEquals(httpResponse.getStatusCode(), this.paramExpectStatusCode.getCode());

        paramVerifyField.forEach((key, value) -> {
            try {
                verifyHttpResponseBodyUtil.getInstance().verifyField(paramVerifyBodyObject, httpResponse.getResponseBody(), key, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                Assert.fail("ActionSendHttpRequest::Verify http response fail. Reason = " + e.getMessage());
            }
        });
    }
}
