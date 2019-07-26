package com.lwg.myapplication.restAPI;

import com.lwg.myapplication.restAPI.RetrofitClient;
import com.lwg.myapplication.restAPI.ApiRequests;

public class ApiRequestBuilder {

    public static ApiRequests getSOService() {
        return RetrofitClient.getClient().create(ApiRequests.class);
    }
}
