package com.example.employeedirectory.webservice;

import android.content.Context;

import com.example.employeedirectory.utils.AppConstants;


public class RxApiRequestHandler {


    public static void getEmployeeApi(Context context, ServiceCallBack callBack) {

        try {

            RXRequestHandler handler = new RXRequestHandler();
            handler.makeApiRequest(context, "employees.json", AppConstants.ApiTags.GET_EMPDETAILS, callBack, true, AppConstants.ApiType.GET);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getEmployeeMalformedApi(Context context, ServiceCallBack callBack) {

        try {

            RXRequestHandler handler = new RXRequestHandler();
            handler.makeApiRequest(context, "employees_malformed.json", AppConstants.ApiTags.GET_EMPMALFORMED, callBack, true, AppConstants.ApiType.GET);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getEmployeeEmptyApi(Context context, ServiceCallBack callBack) {

        try {

            RXRequestHandler handler = new RXRequestHandler();
            handler.makeApiRequest(context, "employees_empty.json", AppConstants.ApiTags.GET_EMPMEMPTY, callBack, true, AppConstants.ApiType.GET);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}