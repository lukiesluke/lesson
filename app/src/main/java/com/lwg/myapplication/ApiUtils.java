package com.lwg.myapplication;

import com.lwg.myapplication.restAPI.RetrofitClient;
import com.lwg.myapplication.restAPI.SOService;

public class ApiUtils {
    public static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
