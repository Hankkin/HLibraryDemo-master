package com.hankkin.hlibrarydemo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import com.hankkin.hlibrary.base.BaseLazyFragment;
import com.hankkin.hlibrarydemo.R;

/**
 *
 */
public class SMSFragment extends BaseLazyFragment {

    public static final String FG_SMS_TAG = "home";

    @Bind(R.id.tv_fg_title)
    TextView tvTitle;


    public static SMSFragment newInstance(String tag) {
        SMSFragment fragment = new SMSFragment();
        Bundle args = new Bundle();
        args.putString(FG_SMS_TAG, tag);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_sms;
    }

    @Override
    protected void initViewsAndEvents(View view) {
        tvTitle.setText("消息页");
    }

    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected void DetoryViewAndThing() {

    }


}
