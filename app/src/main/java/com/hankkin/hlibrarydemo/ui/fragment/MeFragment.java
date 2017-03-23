package com.hankkin.hlibrarydemo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import com.hankkin.hlibrary.base.BaseLazyFragment;
import com.hankkin.hlibrarydemo.R;

/**
 *个人页面
 */
public class MeFragment extends BaseLazyFragment {

    public static final String FG_ME_TAG = "me";

    @Bind(R.id.tv_me_title)
    TextView tvTitle;


    public static MeFragment newInstance(String tag) {
        MeFragment fragment = new MeFragment();
        Bundle args = new Bundle();
        args.putString(FG_ME_TAG, tag);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initViewsAndEvents(View vw) {
        tvTitle.setText("我的");
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
