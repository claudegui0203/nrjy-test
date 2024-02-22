package com.nrjd.common.action;

import org.apache.commons.httpclient.Header;

public abstract class AbstractHttpAction {
    protected abstract void prepareHttpParameters();
    protected abstract void sendHttpRequest();
    protected abstract void verify();

    protected ActionHttpEnum paramHttpProtocol;
    protected String paramRequestUrl;

    protected Header[] paramRequestHeader;

    protected Object paramRequestBody;

    public void perform(String paramRequestUrl, ActionHttpEnum paramHttpProtocol, Header[] paramRequestHeader, Object paramRequestBody) {
        this.paramRequestUrl = paramRequestUrl;
        this.paramHttpProtocol = paramHttpProtocol;
        this.paramRequestHeader = paramRequestHeader;
        this.paramRequestBody = paramRequestBody;

        prepareHttpParameters();
        sendHttpRequest();
        verify();
    }
}
