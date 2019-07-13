package com.lwg.myapplication.restAPI

class RepositoryCallbacks {

    interface IMainActivityCallBack<T> {

        fun onSuccess(response: T?)

        fun onError(errorMessage: String?)
    }
}