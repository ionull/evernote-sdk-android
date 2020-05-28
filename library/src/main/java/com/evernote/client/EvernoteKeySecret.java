package com.evernote.client;

public class EvernoteKeySecret {
    private EvernoteKeySecret() {}

    public EvernoteKeySecret(String key, String secret) {
        this.consumerKey = key;
        this.consumerSecret = secret;
    }

    public String consumerKey;
    public String consumerSecret;
}
