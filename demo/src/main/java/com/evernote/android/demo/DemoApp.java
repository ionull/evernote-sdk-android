package com.evernote.android.demo;

import android.app.Application;

import com.evernote.client.android.EvernoteSession;

/**
 * @author rwondratschek
 */
public class DemoApp extends Application {

    /*
     * ********************************************************************
     * You MUST change the following values to run this sample application.
     *
     * It's recommended to pass in these values via gradle property files.
     * ********************************************************************
     */

    /*
     * Your Evernote API key. See http://dev.evernote.com/documentation/cloud/
     * Please obfuscate your code to help keep these values secret.
     */
    private static final String CONSUMER_KEY_INT = "Your consumer key";
    private static final String CONSUMER_SECRET_INT = "Your consumer secret";
    private static final String CONSUMER_KEY_CHINA = "Your consumer key";
    private static final String CONSUMER_SECRET_CHINA = "Your consumer secret";

    /*
     * Initial development is done on Evernote's testing service, the sandbox.
     *
     * Change to PRODUCTION to use the Evernote production service
     * once your code is complete.
     */
    private static final EvernoteSession.EvernoteService EVERNOTE_SERVICE = EvernoteSession.EvernoteService.SANDBOX;

    /*
     * Set this to true if you want to allow linked notebooks for accounts that
     * can only access a single notebook.
     */
    private static final boolean SUPPORT_APP_LINKED_NOTEBOOKS = true;

    @Override
    public void onCreate() {
        super.onCreate();

        String consumerKeyInt;
        if ("Your consumer key".equals(CONSUMER_KEY_INT)) {
            consumerKeyInt = BuildConfig.EVERNOTE_CONSUMER_KEY_INT;
        } else {
            // isn't the default value anymore
            consumerKeyInt = CONSUMER_KEY_INT;
        }

        String consumerSecretInt;
        if ("Your consumer secret".equals(CONSUMER_SECRET_INT)) {
            consumerSecretInt = BuildConfig.EVERNOTE_CONSUMER_SECRET_INT;
        } else {
            // isn't the default value anymore
            consumerSecretInt = CONSUMER_SECRET_INT;
        }

        String consumerKeyChina;
        if ("Your consumer key".equals(CONSUMER_KEY_CHINA)) {
            consumerKeyChina = BuildConfig.EVERNOTE_CONSUMER_KEY_CHINA;
        } else {
            // isn't the default value anymore
            consumerKeyChina = CONSUMER_KEY_CHINA;
        }

        String consumerSecretChina;
        if ("Your consumer secret".equals(CONSUMER_SECRET_CHINA)) {
            consumerSecretChina = BuildConfig.EVERNOTE_CONSUMER_SECRET_CHINA;
        } else {
            // isn't the default value anymore
            consumerSecretChina = CONSUMER_SECRET_CHINA;
        }

        //Set up the Evernote singleton session, use EvernoteSession.getInstance() later
        new EvernoteSession.Builder(this)
                .setEvernoteService(EVERNOTE_SERVICE)
                .setSupportAppLinkedNotebooks(SUPPORT_APP_LINKED_NOTEBOOKS)
                .setForceAuthenticationInThirdPartyApp(true)
//                .setLocale(Locale.SIMPLIFIED_CHINESE)
                .build(consumerKeyInt, consumerSecretInt, consumerKeyChina, consumerSecretChina)
                .asSingleton();

        registerActivityLifecycleCallbacks(new LoginChecker());
    }
}
