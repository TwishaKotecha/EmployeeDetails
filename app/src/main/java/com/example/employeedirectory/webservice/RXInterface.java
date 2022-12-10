package com.example.employeedirectory.webservice;


import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RXInterface {

    @GET("{url}")
    Observable<JsonElement> makeGetRequest(@Path(value = "url", encoded = true) String url);




}
