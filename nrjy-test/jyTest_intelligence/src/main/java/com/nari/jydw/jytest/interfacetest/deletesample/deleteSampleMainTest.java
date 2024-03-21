package com.nari.jydw.jytest.interfacetest.deletesample;

import com.nrjd.common.util.HttpResponse;
import com.nrjd.common.util.HttpUtil;
import com.nrjd.common.util.JsonUtil;
import com.nrjd.common.util.TestParametersUtil;
import com.nrjd.intelligence.business.body.InterfaceEnum;
import com.nrjd.intelligence.business.body.deleteSampleMain;
import com.nrjd.intelligence.interfacetest.CommonTestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class deleteSampleMainTest extends CommonTestCases {
    private String testUrl = TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.DELETESAMPLEMAIN.getApi();

    @Test
    public void deleteOneSample() {
        List<String> sampleIdList = new ArrayList<>();
        sampleIdList.add("08929ff3334e1000");

        deleteSampleMain deleteSampleMain = new deleteSampleMain();
        deleteSampleMain.setSysType(65535);
        deleteSampleMain.setSampleIdList(sampleIdList);

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteSampleMain));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(deleteSampleMain), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }

    @Test
    public void deleteMultiSamples() {
        List<String> sampleIdList = new ArrayList<>();
        sampleIdList.add("0892c8bfe20e1000");
        sampleIdList.add("08919359af0e1000");
        sampleIdList.add("08918f2307ce1000");

        deleteSampleMain deleteSampleMain = new deleteSampleMain();
        deleteSampleMain.setSysType(1);
        deleteSampleMain.setSampleIdList(sampleIdList);

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteSampleMain));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(deleteSampleMain), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }

    @Test
    public void deleteOneCorrectSample() {
        List<String> sampleIdList = new ArrayList<>();
        sampleIdList.add("08918f230cce1000");
        sampleIdList.add("08918f2309991000");

        deleteSampleMain deleteSampleMain = new deleteSampleMain();
        deleteSampleMain.setSysType(1);
        deleteSampleMain.setSampleIdList(sampleIdList);

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteSampleMain));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(deleteSampleMain), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }

    @Test
    public void deleteTwoSameSample() {
        List<String> sampleIdList = new ArrayList<>();
        sampleIdList.add("08918f23168e1000");
        sampleIdList.add("08918f23168e1000");

        deleteSampleMain deleteSampleMain = new deleteSampleMain();
        deleteSampleMain.setSysType(1);
        deleteSampleMain.setSampleIdList(sampleIdList);

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteSampleMain));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(deleteSampleMain), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }

    @Test
    public void sysTypeNotExist() {
        List<String> sampleIdList = new ArrayList<>();
        sampleIdList.add("088d81b96a8e1000");

        deleteSampleMain deleteSampleMain = new deleteSampleMain();
        deleteSampleMain.setSysType(3);
        deleteSampleMain.setSampleIdList(sampleIdList);

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteSampleMain));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(deleteSampleMain), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }

    @Test
    public void sampleIdLong() {
        List<String> sampleIdList = new ArrayList<>();
        sampleIdList.add("905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a");
        sampleIdList.add("905c99999204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9ab");
        sampleIdList.add("905c99999204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9ac");
        sampleIdList.add("905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b91");
        sampleIdList.add("905c99999204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a2");
        sampleIdList.add("905c99999204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a3");
        sampleIdList.add("905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b94");
        sampleIdList.add("905c99999204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a5");
        sampleIdList.add("905c99999204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a6");
        sampleIdList.add("905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b97");
        sampleIdList.add("905c99999204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a8");
        sampleIdList.add("905c99999204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a9");
        sampleIdList.add("905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b10");
        sampleIdList.add("905c99999204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b911");
        sampleIdList.add("905c99999204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b912");
        sampleIdList.add("905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b13");
        sampleIdList.add("905c99999204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b914");
        sampleIdList.add("905c99999204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b9a905c9e76eb204a8b85e4495bb2231b915");

        deleteSampleMain deleteSampleMain = new deleteSampleMain();
        deleteSampleMain.setSysType(1);
        deleteSampleMain.setSampleIdList(sampleIdList);

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteSampleMain));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(deleteSampleMain), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }

    @Test
    public void sysTypeAndSampleIdNotExist() {
        List<String> sampleIdList = new ArrayList<>();
        sampleIdList.add("088d81b977ce1000");

        deleteSampleMain deleteSampleMain = new deleteSampleMain();
        deleteSampleMain.setSysType(65535);
        deleteSampleMain.setSampleIdList(sampleIdList);

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteSampleMain));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(deleteSampleMain), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }

    @Test
    public void sampleIdEmpty() {
        List<String> sampleIdList = new ArrayList<>();
        sampleIdList.add("");

        deleteSampleMain deleteSampleMain = new deleteSampleMain();
        deleteSampleMain.setSysType(1);
        deleteSampleMain.setSampleIdList(sampleIdList);

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteSampleMain));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(deleteSampleMain), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }

    @Test
    public void sampleIdListNull() {
        deleteSampleMain deleteSampleMain = new deleteSampleMain();
        deleteSampleMain.setSysType(1);
        deleteSampleMain.setSampleIdList(null);

        System.out.println("url = " + testUrl + ", body = " + JsonUtil.getGson().toJson(deleteSampleMain));
        HttpResponse httpResponse = HttpUtil.post(testUrl, JsonUtil.getGson().toJson(deleteSampleMain), generateHeaders());
        System.out.println("code = " + httpResponse.getStatusCode() + ", body = " + httpResponse.getResponseBody());
//        Assert.assertEquals(httpResponse.getStatusCode(), 200);
    }
}
