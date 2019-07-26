package com.lwg.myapplication.restAPI;

import com.lwg.myapplication.models.Github;
import com.lwg.myapplication.models.SOAnswersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequests {

    @GET("https://api.stackexchange.com/2.2//answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswersResponse> getAnswers();

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswersResponse> getAnswers(@Query("tagged") String tags);

    @GET("https://api.github.com/")
    Call<Github> getGitHub();
}
