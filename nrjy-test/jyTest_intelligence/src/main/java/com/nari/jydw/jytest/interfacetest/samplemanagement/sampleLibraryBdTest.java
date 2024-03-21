package com.nari.jydw.jytest.interfacetest.samplemanagement;

import com.nari.jydw.jytest.common.InterfaceEnum;
import com.nrjd.common.util.TestParametersUtil;
import com.nrjd.intelligence.interfacetest.CommonTestCases;
import org.testng.annotations.Test;

public class sampleLibraryBdTest extends CommonTestCases {

    @Test
    public void sampleLibraryBd() {
        String testUrl = TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.SAMPLELIBRARYBD.getApi();

    }
}
