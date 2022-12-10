package com.example.employeedirectory.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.StrictMode;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.employeedirectory.R;
import com.example.employeedirectory.webservice.TransparentProgressDialog;
import com.google.android.material.textfield.TextInputLayout;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;


public class Utils {

    private static TransparentProgressDialog mProgressDialog;
    public static Toast toast;

    /**
     * Check for internet connectivity
     */
    public static boolean isConnectingToInternet(Context context) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        } else {
            Toast.makeText(context, context.getResources().getString(R.string.noInternet), Toast.LENGTH_LONG).show();
            return false;
        }
    }

    /**
     * Show loader on complete task or background process
     */
    public static void showProgressDialog(final Context ctx) {

        try {

            if (mProgressDialog == null) {
                mProgressDialog = new TransparentProgressDialog(ctx);
                mProgressDialog.setCancelable(false);
                mProgressDialog.show();

            } else {

                mProgressDialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Hide loader on complete task or background process
     */
    public static void hideProgressDialog(final Context ctx) {

        try {
            if (mProgressDialog != null) {
                mProgressDialog.dismiss();
                mProgressDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Set toast message as string
     */
    public static void setToast(Context context, String msg) {
        try {
            if (toast != null) {
                toast.cancel();
            }
            toast = SToast.makeText(context, msg.trim(), SToast.LENGTH_LONG, 0, true);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, (int) context.getResources().getDimension(R.dimen._40sdp));
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Set profile picture in circle
     */
    public static void glideImage(Context context, String imageResources, ImageView imageView) {
        imageView.setVisibility(View.VISIBLE);
        Glide.with(context).load(imageResources)
                .dontTransform()
                .thumbnail(0.1f)
                .apply(new RequestOptions().placeholder(R.drawable.user).error(R.drawable.user))
                .into(imageView);
    }


}
