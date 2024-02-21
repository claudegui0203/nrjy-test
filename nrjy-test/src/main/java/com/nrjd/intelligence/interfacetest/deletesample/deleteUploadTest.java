package com.nrjd.intelligence.interfacetest.deletesample;

import com.nrjd.common.util.HttpResponse;
import com.nrjd.common.util.HttpUtil;
import com.nrjd.common.util.JsonUtil;
import com.nrjd.common.util.TestParametersUtil;
import com.nrjd.intelligence.business.body.InterfaceEnum;
import com.nrjd.intelligence.business.body.deleteUpload;
import com.nrjd.intelligence.interfacetest.CommonTestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

public class deleteUploadTest extends CommonTestCases {
    private String testUrl = TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.DELETEUPLOAD.getApi();

    @Test
    public void deleteOneUpload() {
        deleteUpload deleteUpload = new deleteUpload();
        deleteUpload.setSysType(1);
        deleteUpload.setUploadId("905c9e76eb204a8b85e4495bb2231b9a");

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteUpload));
        HttpResponse httpResponse = HttpUtil.get(testUrl, JsonUtil.getGson().toJson(deleteUpload), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }

    @Test
    public void uploadIdEmpty() {
        deleteUpload deleteUpload = new deleteUpload();
        deleteUpload.setSysType(1);
        deleteUpload.setUploadId("");

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteUpload));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(deleteUpload), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }

    @Test
    public void uploadIdLong() {
        deleteUpload deleteUpload = new deleteUpload();
        deleteUpload.setSysType(1);
        deleteUpload.setUploadId("905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a");

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteUpload));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(deleteUpload), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }

    @Test
    public void uploadIdNull() {
        deleteUpload deleteUpload = new deleteUpload();
        deleteUpload.setSysType(1);
        deleteUpload.setUploadId(null);

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteUpload));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(deleteUpload), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }

    @Test
    public void sysTypeNotExist() {
        deleteUpload deleteUpload = new deleteUpload();
        deleteUpload.setSysType(3);
        deleteUpload.setUploadId("905c9e76eb204a8b85e4495bb2231b9a");

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteUpload));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(deleteUpload), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }

    @Test
    public void sysTypeNotInLimit() {
        deleteUpload deleteUpload = new deleteUpload();
        deleteUpload.setSysType(-1);
        deleteUpload.setUploadId("905c9e76eb204a8b85e4495bb2231b9a");

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteUpload));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(deleteUpload), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }

    @Test
    public void sampleIdNull() {
        deleteUpload deleteUpload = new deleteUpload();
        deleteUpload.setSysType(null);
        deleteUpload.setUploadId("905c9e76eb204a8b85e4495bb2231b9a");

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteUpload));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(deleteUpload), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }
}
