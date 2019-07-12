package com.evernote.client.android;

import org.scribe.builder.api.EvernoteApi;
import org.scribe.model.Token;

public class YinxiangSandboxApi extends EvernoteApi {

    private static final String YINXIANG_URL = "https://sandbox.yinxiang.com"; //$NON-NLS-1$

    @Override
    public String getRequestTokenEndpoint() {
        return YINXIANG_URL + "/oauth"; //$NON-NLS-1$
    }

    @Override
    public String getAccessTokenEndpoint() {
        return YINXIANG_URL + "/oauth"; //$NON-NLS-1$
    }

    @Override
    public String getAuthorizationUrl(Token requestToken) {
        return String.format(YINXIANG_URL + "/OAuth.action?oauth_token=%s", requestToken.getToken()); //$NON-NLS-1$
    }
}
