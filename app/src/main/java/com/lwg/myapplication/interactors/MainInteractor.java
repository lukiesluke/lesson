package com.lwg.myapplication.interactors;

import com.lwg.myapplication.ApiBuilder;
import com.lwg.myapplication.restAPI.RepositoryCallbacks;
import com.lwg.myapplication.restAPI.ApiRequests;
import com.lwg.myapplication.models.SOAnswersResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainInteractor implements IMainInteractor {

    private ApiRequests apiRequests;

    @Override
    public void getAnswers(final RepositoryCallbacks.IMainActivityCallBack callBack) {

        apiRequests = ApiBuilder.getSOService();
        apiRequests.getAnswers().enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(@NotNull Call<SOAnswersResponse> call, @NotNull Response<SOAnswersResponse> response) {
                if (response.isSuccessful()) {
                    callBack.onSuccess(response.body());
                } else {
                    callBack.onError(response.message());
                }
            }

            @Override
            public void onFailure(@NotNull Call<SOAnswersResponse> call, @NotNull Throwable t) {
                callBack.onError(t.getMessage());
            }
        });
    }
}
