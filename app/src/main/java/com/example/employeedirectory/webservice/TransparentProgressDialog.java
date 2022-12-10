package com.example.employeedirectory.webservice;


import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.employeedirectory.R;


public class TransparentProgressDialog extends Dialog {

    private ImageView iv;

    public TransparentProgressDialog(Context context) {

        super(context, R.style.TransparentProgressDialog);

        try {
            WindowManager.LayoutParams wlmp = getWindow().getAttributes();
            wlmp.gravity = Gravity.CENTER;
            getWindow().setAttributes(wlmp);
            setTitle(null);
            setCancelable(false);
            setOnCancelListener(null);
            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            iv = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int)context.getResources().getDimension(R.dimen._60sdp), (int)context.getResources().getDimension(R.dimen._60sdp));
            iv.setLayoutParams(layoutParams);
            Glide.with(context).asGif().load(R.drawable.loaders).into(iv);

            layout.addView(iv, params);
            addContentView(layout, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void show() {
        super.show();
    }
}