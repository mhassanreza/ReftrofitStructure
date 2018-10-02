package com.dev.honda.Util;

import android.app.ProgressDialog;
import android.content.Context;
import android.text.Spanned;

import com.dev.honda.R;


public class ProgressDialogObject {

    private ProgressDialog mProgressDialog;

    public ProgressDialogObject(Context context) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(context, R.style.AppCompatAlertDialogStyle);
        }
    }

    public void showProgressDialog(String text) {
        mProgressDialog.setMessage(text);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        mProgressDialog.dismiss();
    }

    public void updateMessage(String message) {
        mProgressDialog.setMessage(message);
    }

    public void updateSpannedMessage(Spanned message) {
        mProgressDialog.setMessage(message);
    }

    public ProgressDialog getmProgressDialog() {
        return mProgressDialog;
    }

    public void setmProgressDialog(ProgressDialog mProgressDialog) {
        this.mProgressDialog = mProgressDialog;
    }
}
