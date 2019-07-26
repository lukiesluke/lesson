package com.lwg.myapplication.repository;

import android.util.Log;

import com.lwg.myapplication.models.Github;
import com.lwg.myapplication.models.SOAnswersResponse;
import com.lwg.myapplication.restAPI.ApiRequestBuilder;
import com.lwg.myapplication.restAPI.ApiRequests;
import com.lwg.myapplication.restAPI.RepositoryCallbacks;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryImpl implements Repository {

    private ApiRequests apiServiceRequests = ApiRequestBuilder.getSOService();

    @Override
    public void getAnswers(final RepositoryCallbacks.IMainActivityCallBack callBack) {

        apiServiceRequests.getAnswers().enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {
                if (response.isSuccessful()) {
                    callBack.onSuccess(response.body());
                } else {
                    callBack.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {
                callBack.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getGitHub(final RepositoryCallbacks.IMainActivityGitHubCallBack callBack) {

        apiServiceRequests.getGitHub().enqueue(new Callback<Github>() {
            @Override
            public void onResponse(Call<Github> call, Response<Github> response) {
                if (response.isSuccessful()) {
                    callBack.onGitSuccess(response.body());
                    Log.d("lwg", "interactor: " + response.body().getCurrent_user());
                    Log.d("lwg", "interactor: " + response.body().getCurrent_user_authorizations());
                } else {
                    callBack.onGitError("interactor response code: " + response.code() + response.message());
                }
            }

            @Override
            public void onFailure(Call<Github> call, Throwable t) {
                Log.d("lwg", t.getMessage());
            }
        });
    }
}
