package com.nari.jydw.jytest.common.business.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class responseBody {
    int code = 0;
    String msg = "";
    Long data = 0L;
}
