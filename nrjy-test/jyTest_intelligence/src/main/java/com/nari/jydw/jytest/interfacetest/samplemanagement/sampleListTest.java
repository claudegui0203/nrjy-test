package com.nari.jydw.jytest.interfacetest.samplemanagement;

import com.nrjd.common.util.*;
import com.nrjd.intelligence.business.body.InterfaceEnum;
import com.nrjd.intelligence.business.body.sampleList;
import com.nrjd.intelligence.interfacetest.CommonTestCases;
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
