package com.nari.jydw.jytest.interfacetest.samplemanagement;

import com.nari.jydw.jytest.CommonTestCases;
import com.nari.jydw.jytest.common.InterfaceEnum;
import com.nari.jydw.jytest.common.TestParametersUtil;

import org.testng.annotations.Test;

public class sampleLibraryBdTest extends CommonTestCases {

    @Test
    public void sampleLibraryBd() {
        String testUrl = TestParametersUtil.getInstance().getTestParameters().getSiteUrl() + InterfaceEnum.SAMPLELIBRARYBD.getApi();

    }
}
