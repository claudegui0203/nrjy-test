package com.nrjd.intelligence.business.body;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class deleteSampleMain {
    private Integer sysType;
    private List<String> sampleIdList = new ArrayList<>();
}
