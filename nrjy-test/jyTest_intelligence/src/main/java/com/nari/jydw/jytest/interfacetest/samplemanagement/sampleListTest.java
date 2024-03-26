package com.nari.jydw.jytest.interfacetest.samplemanagement;

import com.nari.jydw.jytest.CommonTestCases;
import com.nari.jydw.jytest.common.HttpResponse;
import com.nari.jydw.jytest.common.InterfaceEnum;
import com.nari.jydw.jytest.common.TestParametersUtil;
import com.nari.jydw.jytest.common.business.body.sampleList;
import com.nari.jydw.jytest.interfaceTest.utils.HttpUtil;
import com.nari.jydw.jytest.interfaceTest.utils.JsonUtil;
import com.nari.jydw.jytest.interfaceTest.utils.LogUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class sampleListTest extends CommonTestCases {

    @Test
    public void smpleList() {
        String testUrl = TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.SAMPLELIST.getApi();

        List<Integer> labelIds = new ArrayList<>();
        labelIds.add(1);
        labelIds.add(2);

        sampleList samplelist = new sampleList();
        samplelist.setLabelIds(labelIds);

        LogUtil.info("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(samplelist));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(samplelist), generateHeaders());
        LogUtil.info("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }
}
