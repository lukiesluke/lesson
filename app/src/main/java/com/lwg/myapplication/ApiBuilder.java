package com.lwg.myapplication;

import com.lwg.myapplication.restAPI.RetrofitClient;
import com.lwg.myapplication.restAPI.ApiRequests;

public class ApiBuilder {

    public static ApiRequests getSOService() {
        return RetrofitClient.getClient().create(ApiRequests.class);
    }
}
