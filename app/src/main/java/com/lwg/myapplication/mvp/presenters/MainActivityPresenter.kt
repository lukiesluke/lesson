package com.lwg.myapplication.mvp.presenters

import android.util.Log
import com.lwg.myapplication.restAPI.RepositoryCallbacks
import com.lwg.myapplication.interactors.IMainInteractor
import com.lwg.myapplication.interactors.MainInteractor
import com.lwg.myapplication.models.SOAnswersResponse
import com.lwg.myapplication.mvp.view.MainActivityView

class MainActivityPresenter(val view: MainActivityView) : RepositoryCallbacks.IMainActivityCallBack<SOAnswersResponse> {

    private var interactor: IMainInteractor = MainInteractor()

    fun ready() {
        view.init()
        interactor = MainInteractor()
        interactor.getAnswers(this)

    }

    override fun onSuccess(response: SOAnswersResponse?) {
        view.responses(response)
        response!!.items.forEach {
            Log.d("lwg", it.owner.profileImage)
        }
    }

    override fun onError(errorMessage: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
