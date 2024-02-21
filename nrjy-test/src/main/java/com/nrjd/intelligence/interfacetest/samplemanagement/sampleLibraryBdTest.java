package com.nrjd.intelligence.interfacetest.samplemanagement;

import com.nrjd.common.util.TestParametersUtil;
import com.nrjd.intelligence.business.body.InterfaceEnum;
import com.nrjd.intelligence.interfacetest.CommonTestCases;
import org.testng.annotations.Test;

public class sampleLibraryBdTest extends CommonTestCases {

    @Test
    public void sampleLibraryBd() {
        String testUrl = TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.SAMPLELIBRARYBD.getApi();

    }
}
