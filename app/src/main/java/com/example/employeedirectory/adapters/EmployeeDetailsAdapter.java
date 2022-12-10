package com.example.employeedirectory.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedirectory.R;
import com.example.employeedirectory.models.EmployeeDetailsModel;
import com.example.employeedirectory.utils.Utils;

import java.util.ArrayList;

public class EmployeeDetailsAdapter extends RecyclerView.Adapter<EmployeeDetailsAdapter.RewardViewHolder> {
    Context context;
    ArrayList<EmployeeDetailsModel.Employees> empDetailsModels;

    public EmployeeDetailsAdapter(Context context, ArrayList<EmployeeDetailsModel.Employees> empDetailsModels) {
        this.context = context;
        this.empDetailsModels = empDetailsModels;

    }

    @NonNull
    @Override
    public RewardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.items_employee_details, parent, false);
        return new RewardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RewardViewHolder holder, int position) {

        if (!TextUtils.isEmpty(empDetailsModels.get(position).getFull_name())) {
            holder.txtName.setText(empDetailsModels.get(position).getFull_name());
        } else {
            holder.txtName.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(empDetailsModels.get(position).getEmail_address())) {
            holder.txtEmail.setText(empDetailsModels.get(position).getEmail_address());
        } else {
            holder.txtEmail.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(empDetailsModels.get(position).getPhone_number())) {
            holder.txtPhone.setText(empDetailsModels.get(position).getPhone_number());
        } else {
            holder.txtPhone.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(empDetailsModels.get(position).getBiography())) {
            holder.txtBiography.setText(empDetailsModels.get(position).getBiography());
        } else {
            holder.txtBiography.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(empDetailsModels.get(position).getEmployee_type())) {
            holder.txtEmpType.setText(empDetailsModels.get(position).getEmployee_type());
        } else {
            holder.txtEmpType.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(empDetailsModels.get(position).getTeam())) {
            holder.txtTeam.setText(empDetailsModels.get(position).getTeam());
        } else {
            holder.txtTeam.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(empDetailsModels.get(position).getPhoto_url_small()))
            Utils.glideImage(context, empDetailsModels.get(position).getPhoto_url_small(), holder.imgImage);
    }

    @Override
    public int getItemCount() {
        return empDetailsModels.size();
    }

    public class RewardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgImage;
        AppCompatTextView txtName, txtEmail, txtBiography, txtTeam, txtEmpType, txtPhone;

        public RewardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgImage = itemView.findViewById(R.id.imgImage);
            txtName = itemView.findViewById(R.id.txtName);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtBiography = itemView.findViewById(R.id.txtBiography);
            txtTeam = itemView.findViewById(R.id.txtTeam);
            txtEmpType = itemView.findViewById(R.id.txtEmpType);
            txtPhone = itemView.findViewById(R.id.txtPhone);
        }
    }
}
