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
public class HomeFragment extends BaseLazyFragment {

    public static final String FG_HOME_TAG = "home";

    @Bind(R.id.tv_fg_title)
    TextView tvTitle;


    public static HomeFragment newInstance(String tag) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(FG_HOME_TAG, tag);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViewsAndEvents(View view) {
        tvTitle.setText("首页");
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
