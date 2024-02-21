package com.nrjd.common;

import com.nrjd.common.util.LogUtil;
import com.nrjd.common.util.TestParametersUtil;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.io.IOException;

public class MainTestCases {

    public MainTestCases() {

    }

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
}
