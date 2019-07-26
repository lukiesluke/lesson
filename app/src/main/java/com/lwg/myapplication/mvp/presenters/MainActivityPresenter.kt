package com.lwg.myapplication.mvp.presenters

import android.util.Log
import com.lwg.myapplication.interactors.IMainInteractor
import com.lwg.myapplication.interactors.MainInteractor
import com.lwg.myapplication.models.Github
import com.lwg.myapplication.models.SOAnswersResponse
import com.lwg.myapplication.mvp.view.MainActivityView
import com.lwg.myapplication.restAPI.RepositoryCallbacks

class MainActivityPresenter(val view: MainActivityView) : RepositoryCallbacks.IMainActivityCallBack<SOAnswersResponse> {

    private var interactor: IMainInteractor = MainInteractor()

    fun ready() {
        view.init()
        interactor = MainInteractor()
        interactor.getAnswers(this)
        onGetGitHub()
    }

    private fun onGetGitHub() {

        interactor.getGitHub(object : RepositoryCallbacks.ISingleResponseCallback<Github> {
            override fun onSuccess(response: Github?) {
                Log.d("lwg", "onGetGitHub " + response?.current_user_authorizations)
                Log.d("lwg", "onGetGitHub " + response?.current_user)
            }

            override fun onError(errorMessage: String?) {
            }

        })
    }

    override fun onSuccess(response: SOAnswersResponse?) {
        response!!.items.forEach {
            Log.d("lwg", it.owner.displayName)
        }
    }

    override fun onError(errorMessage: String?) {

    }
}
