package com.dev.honda.Util;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.dev.honda.R;


public class SnackbarUtil {
    public static void showSnackBar(Context mContext, String message) {
        Snackbar mySnackbar = Snackbar.make(((Activity) mContext).findViewById(android.R.id.content),
                message, Snackbar.LENGTH_INDEFINITE);
        mySnackbar.setAction(R.string.ok, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mySnackbar.show();
    }
}
