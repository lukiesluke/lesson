package com.lwg.myapplication.interactors;

import com.lwg.myapplication.repository.Repository;
import com.lwg.myapplication.repository.RepositoryImpl;
import com.lwg.myapplication.restAPI.RepositoryCallbacks;

public class MainInteractor implements IMainInteractor {

    private Repository repository = new RepositoryImpl();

    @Override
    public void getAnswers(final RepositoryCallbacks.IMainActivityCallBack callBack) {
        repository.getAnswers(callBack);
    }

    @Override
    public void getGitHub(RepositoryCallbacks.ISingleResponseCallback callBack) {
        repository.getGitHub(callBack);
    }
}
