package com.lwg.myapplication.models;

import com.google.gson.annotations.SerializedName;

public class Github {

    @SerializedName("current_user_url")
    private String current_user;

    @SerializedName("current_user_authorizations_html_url")
    private String current_user_authorizations;

    public String getCurrent_user() {
        return current_user;
    }

    public String getCurrent_user_authorizations() {
        return current_user_authorizations;
    }
}

