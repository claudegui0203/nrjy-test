package com.nrjd.intelligence.business.body;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class sampleLibraryBd {
    private Integer pageSize = 0;
    private Integer pageNum = 0;
    private String sceneLabelId = "";
    private String targetLabelId = "";
    private String labelId = "";
    private Integer sysType = 0;
}
