package com.lwg.myapplication.repository;

import com.lwg.myapplication.restAPI.RepositoryCallbacks;

public interface Repository {

    void getAnswers(RepositoryCallbacks.IMainActivityCallBack callBack);

    void getGitHub(RepositoryCallbacks.ISingleResponseCallback callBack);

}
