package com.example.employeedirectory.webservice;


import com.google.gson.JsonElement;

/**
 * Interface for Network Api Callbacks Handle
 */
public interface ServiceCallBack {
    void onSuccess(String requestTag, JsonElement data);


    void onFailure(String requestTag, String message, String errorcode);

}
