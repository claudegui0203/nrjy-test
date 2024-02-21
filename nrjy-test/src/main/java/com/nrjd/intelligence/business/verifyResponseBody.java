package com.nrjd.intelligence.business;

import java.lang.reflect.Field;

import com.nrjd.common.util.DBUtil;
import com.nrjd.common.util.JsonUtil;
import com.nrjd.intelligence.business.response.responseBody;
import org.testng.Assert;

public class verifyResponseBody {
    private static verifyResponseBody instance;

    public static verifyResponseBody getInstance() {
        if (instance == null) {
            instance = new verifyResponseBody();
        }
        return instance;
    }

    private verifyResponseBody() {

    }

    public verifyResponseBody verifyField(responseBody responseBody, String result, String fieldName, Object expect) throws NoSuchFieldException, IllegalAccessException {
        responseBody response = JsonUtil.getGson().fromJson(result, responseBody.getClass());

        if (expect instanceof String) {
            String expectedValue = (String) expect;
            Field privateField = response.getClass().getDeclaredField(fieldName);
            privateField.setAccessible(true);
            String value = (String) privateField.get(response);
            Assert.assertEquals(value, expectedValue, "Value is differ with expect! value = " + value + ", but expect = " + expect);
        } else if (expect instanceof Integer) {
            int expectedValue = (int) expect;
            Field privateField = response.getClass().getDeclaredField(fieldName);
            privateField.setAccessible(true);
            int value = (int) privateField.get(response);
            Assert.assertEquals(value, expectedValue, "Value is differ with expect! value = " + value + ", but expect = " + expect);
        }

        return this;
    }
}
