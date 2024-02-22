package com.nrjd.common.action;

import com.nrjd.common.util.HttpStatusEnum;
import java.util.Map;

public interface ActionSendHttpRequestBuilder extends ActionParameterBuilder<ActionSendHttpRequest> {

    /**
     * This parameter is must for the action, if it is null, it will send null to server.
     * @param paramHttpProtocol which the api will be post to.
     * @return
     */
    ActionSendHttpRequest paramHttpProtocol(ActionHttpEnum paramHttpProtocol);

    /**
     * This parameter is must for the action, if it is null, it will send null to server.
     * @param paramExpectStatusCode which the api will be post to.
     * @return
     */
    ActionSendHttpRequest paramExpectStatusCode(HttpStatusEnum paramExpectStatusCode);
    /**
     * This parameter is must for the action, if it is null, it will send null to server.
     * @param paramVerifyBodyObject which the api will be post to.
     * @return
     */
    ActionSendHttpRequest paramVerifyBodyObject(Object paramVerifyBodyObject);

    /**
     * This parameter is must for the action, if it is null, it will send null to server.
     * @param paramVerifyField which the api will be post to.
     * @return
     */
    ActionSendHttpRequest paramVerifyField(Map<String, Object> paramVerifyField);
}
