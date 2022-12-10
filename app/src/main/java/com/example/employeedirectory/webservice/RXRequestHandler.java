package com.example.employeedirectory.webservice;

import android.content.Context;
import android.util.Log;

import com.example.employeedirectory.R;
import com.example.employeedirectory.utils.AppConstants;
import com.example.employeedirectory.utils.Utils;
import com.google.gson.JsonElement;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;


public class RXRequestHandler {

    public static Disposable disposable = null;
    String errMsg = "";


    public void makeApiRequest(final Context context, String url, final String requestTag,
                               final ServiceCallBack listener,
                               boolean isProgressNeeded, String apiType) {

        errMsg = "";
        if (Utils.isConnectingToInternet(context)) {
            RXInterface apiService = RxApiClient.getClient().create(RXInterface.class);
            Observable<JsonElement> observableResponse = null;

            if (isProgressNeeded) {
                Utils.showProgressDialog(context);
            }

            if (apiType.equalsIgnoreCase(AppConstants.ApiType.GET)) {

                observableResponse = apiService.makeGetRequest(url)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
            if (observableResponse != null) {
                observableResponse.subscribe(new Observer<JsonElement>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(@NonNull JsonElement jsonElement) {
                        Utils.hideProgressDialog(context);
                        if (listener != null) {
                            listener.onSuccess(requestTag, jsonElement);
                        }
                    }


                    @Override
                    public void onError(@NonNull Throwable e) {
                        Utils.hideProgressDialog(context);
                        if (listener != null) {
                            readerror(context, e, context.getResources().getString(R.string.serverError), listener, requestTag);
                        }
                    }

                    @Override
                    public void onComplete() {
                    }
                });


            }
        }
    }


    private void readerror(Context context, Throwable e, String errorstring, ServiceCallBack listener, String requestTag) {
        String errorcode = "";


        try {
            if (e instanceof HttpException) {
                HttpException error = (HttpException) e;
                if (error.code() == 403) {
                    //Session expired
                    listener = null;
                } else {
                    //General error
                    String errorBody = error.response().errorBody().string();
                    try {
                        Log.e("macro", "errorBody->" + errorBody);
                    } catch (Exception ex) {
                        Log.e("macro", "exception->" + ex);
                    }
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if (listener != null) {
            listener.onFailure(requestTag, errorstring, errorcode);
        }
    }


}
