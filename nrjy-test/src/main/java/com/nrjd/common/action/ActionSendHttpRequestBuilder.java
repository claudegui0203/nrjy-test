package com.nrjd.common.action;

import com.nrjd.common.util.HttpStatusEnum;
import org.apache.commons.httpclient.Header;

import java.util.Map;

public interface ActionSendHttpRequestBuilder extends ActionParameterBuilder<ActionSendHttpRequest> {

    /**
     * This parameter is must for the action, It cannot be noll or empty.
     * @param paramRequestUrl which the url will be sent request to.
     * @return
     */
    ActionSendHttpRequestBuilder paramRequestUrl(String paramRequestUrl);

    /**
     * This parameter is must for the action, if it is null, it will send null in header to server.
     * @param paramRequestHeader Http request header.
     * @return
     */
    ActionSendHttpRequestBuilder paramRequestHeader(Header[] paramRequestHeader);

    /**
     * This parameter is must for the action, if it is null, it will be used POST.
     * @param paramHttpProtocol POST/GET/PUT.
     * @return
     */
    ActionSendHttpRequestBuilder paramHttpProtocol(ActionHttpEnum paramHttpProtocol);

    /**
     * This parameter is must for the action, if it is null, it will send null in request body to server.
     * @param paramRequestBody Http request body.
     * @return
     */
    ActionSendHttpRequestBuilder paramRequestBody(Object paramRequestBody);

    /**
     * This parameter is must for the action, if it is null, it will send null to server.
     * @param expectedStatusCode which the api will be post to.
     * @return
     */
    ActionSendHttpRequestBuilder expectedStatusCode(HttpStatusEnum expectedStatusCode);
    /**
     * This parameter is must for the action, if it is null, it will send null to server.
     * @param expectedBodyObject which the api will be post to.
     * @return
     */
    ActionSendHttpRequestBuilder expectedBodyObject(Object expectedBodyObject);

    /**
     * This parameter is must for the action, if it is null, it will send null to server.
     * @param expectedField which the api will be post to.
     * @return
     */
    ActionSendHttpRequestBuilder expectedField(Map<String, Object> expectedField);
}
