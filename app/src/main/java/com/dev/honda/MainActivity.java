package com.dev.honda;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dev.honda.Util.ConnectionDetector;
import com.dev.honda.Util.ProgressDialogObject;
import com.dev.honda.Util.SnackbarUtil;
import com.dev.honda.model.UserResponse;
import com.dev.honda.network.ApiService;
import com.dev.honda.network.RequestCode;
import com.dev.honda.network.RestCallbackObject;
import com.dev.honda.network.RestClient;
import com.dev.honda.network.ServerConnectListenerObject;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServerConnectListenerObject {

    private EditText mEtUsername;

    private Context mContext;
    private ProgressDialogObject mProgressDialog;
    private ApiService mService;
    private TextView mTvUserDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initUIComponents();
    }

    private void initUIComponents() {
        findViewById(R.id.get_detail).setOnClickListener(this);
        mEtUsername = findViewById(R.id.et_enter_username);
        mTvUserDetail = findViewById(R.id.tv_user_detail);
    }

    private void getUserDetail(String s) {
        if (TextUtils.isEmpty(s))
            return;
        if (ConnectionDetector.isConnectedToNetwork(mContext)) {
            mProgressDialog = new ProgressDialogObject(mContext);
            mProgressDialog.showProgressDialog(getApplicationContext().getString(
                    R.string.fetching));
            mService = RestClient.getInstance(this, false, false);
            Call<UserResponse> userObject = mService.getUserDetail(s);
            RestCallbackObject callbackObject = new RestCallbackObject(this, this, RequestCode.USER_DETAIL_REQUEST_CODE).showProgress(true, 0).dontHideProgress(false);
            userObject.enqueue(callbackObject);
        } else {
            SnackbarUtil.showSnackBar(mContext, getApplicationContext().getString(R.string.error_msg_no_internet));
        }
    }

    @Override
    public void onFailure(String error, RequestCode requestCode) {
        hideProgress();
        SnackbarUtil.showSnackBar(mContext, error);
    }

    @Override
    public void onSuccess(Object object, RequestCode requestCode) {
        if (requestCode == RequestCode.USER_DETAIL_REQUEST_CODE) {
            UserResponse userDetailReponse = (UserResponse) object;
            mTvUserDetail.setText(userDetailReponse.getId() + "\n" + userDetailReponse.getName() + "\n" + userDetailReponse.getBio() + "\n" + userDetailReponse.getLocation());
        }
        hideProgress();
    }

    private void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.hideProgressDialog();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_detail:
                getUserDetail(mEtUsername.getEditableText().toString());
                break;
        }
    }


}
