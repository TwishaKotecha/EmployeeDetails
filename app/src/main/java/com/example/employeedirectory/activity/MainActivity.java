package com.example.employeedirectory.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.employeedirectory.R;
import com.example.employeedirectory.adapters.EmployeeDetailsAdapter;
import com.example.employeedirectory.models.EmployeeDetailsModel;
import com.example.employeedirectory.utils.AppConstants;
import com.example.employeedirectory.utils.Utils;
import com.example.employeedirectory.webservice.RxApiRequestHandler;
import com.example.employeedirectory.webservice.ServiceCallBack;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ServiceCallBack {

    @BindView(R.id.recEmpDetails)
    RecyclerView recEmpDetails;

    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipe_container;

    EmployeeDetailsAdapter empDetailsAdapter;
    private ArrayList<EmployeeDetailsModel.Employees> empDetailsList;


    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        context = MainActivity.this;
        init();
        RxApiRequestHandler.getEmployeeApi(MainActivity.this, MainActivity.this);
    }

    private void init() {
        empDetailsList = new ArrayList<>();
        empDetailsAdapter = new EmployeeDetailsAdapter(context, empDetailsList);
        recEmpDetails.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recEmpDetails.setAdapter(empDetailsAdapter);

        //swip listener
        swipe_container.setOnRefreshListener(() -> {
            RxApiRequestHandler.getEmployeeApi(MainActivity.this, MainActivity.this);
            swipe_container.setRefreshing(false);
        });
    }


    @Override
    public void onSuccess(String requestTag, JsonElement data) {
        switch (requestTag) {

            case AppConstants.ApiTags.GET_EMPDETAILS:

                ArrayList<EmployeeDetailsModel.Employees> empListTemp = (ArrayList<EmployeeDetailsModel.Employees>) new Gson().fromJson(data, EmployeeDetailsModel.class).getEmployees();
                for (int i = 0; i < empListTemp.size(); i++) {
                    EmployeeDetailsModel.Employees data1 = empListTemp.get(i);
                    empDetailsList.add(new EmployeeDetailsModel.Employees(data1.getUuid(), data1.getFull_name(), data1.getPhone_number(), data1.getEmail_address(), data1.getBiography(), data1.getPhoto_url_small(), data1.getPhoto_url_large(), data1.getTeam(), data1.getEmployee_type()));
                }
                empDetailsAdapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onFailure(String requestTag, String message, String errorcode) {
        Utils.setToast(MainActivity.this, message);
    }
}