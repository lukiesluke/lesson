package com.lwg.myapplication.mvp.presenters

import android.util.Log
import com.lwg.myapplication.restAPI.RepositoryCallbacks
import com.lwg.myapplication.interactors.IMainInteractor
import com.lwg.myapplication.interactors.MainInteractor
import com.lwg.myapplication.models.Github
import com.lwg.myapplication.models.SOAnswersResponse
import com.lwg.myapplication.mvp.view.MainActivityView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityPresenter(val view: MainActivityView) : RepositoryCallbacks.IMainActivityCallBack<SOAnswersResponse>, RepositoryCallbacks
.IMainActivityGitHubCallBack<Github>  {

    private var interactor: IMainInteractor = MainInteractor()

    fun ready() {
        view.init()
        interactor = MainInteractor()
        interactor.getAnswers(this)
        interactor.getGitHub(this)
    }

    override fun onSuccess(response: SOAnswersResponse?) {
     response!!.items.forEach {
         Log.d("lwg", it.owner.displayName)
     }
    }

    override fun onError(errorMessage: String?) {

    }

    override fun onGitSuccess(response: Github?) {
        Log.d("lwg", response?.current_user_authorizations)
        Log.d("lwg", response?.current_user)
    }

    override fun onGitError(errorMessage: String?) {
    }

}
