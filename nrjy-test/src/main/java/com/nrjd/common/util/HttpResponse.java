package com.nrjd.common.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HttpResponse {
    private int statusCode;
    private String responseBody;

    public HttpResponse (int statusCode, String responseBody) {
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }
}
