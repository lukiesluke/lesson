package com.lwg.myapplication.interactors;

import com.lwg.myapplication.restAPI.RepositoryCallbacks;

public interface IMainInteractor {

    void getAnswers(RepositoryCallbacks.IMainActivityCallBack callBack);

}
