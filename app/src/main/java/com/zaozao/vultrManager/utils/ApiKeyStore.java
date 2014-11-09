package com.zaozao.vultrManager.utils;

import android.content.Context;

/**
 * Created by chenqisheng on 14/11/9.
 */
public class ApiKeyStore {
    private static ApiKeyStore Instance = null;
    public static final String API_KEY = "api_key";


    private ApiKeyStore() {
    }

    public static ApiKeyStore getInstance() {
        if (Instance == null) {
            Instance = new ApiKeyStore();
        }
        return Instance;
    }


    public String getApiKey(Context context) {
        SharedPreferenceHelper mSharedPreference = new SharedPreferenceHelper(context);
        return mSharedPreference.getKeyStr(API_KEY);
    }

    public void setApiKey(Context context, String apiKey) {
        SharedPreferenceHelper mSharedPreference = new SharedPreferenceHelper(context);
        mSharedPreference.setKeyStr(API_KEY, apiKey);
    }
}
