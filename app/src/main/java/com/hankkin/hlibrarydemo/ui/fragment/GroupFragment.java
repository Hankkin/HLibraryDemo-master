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
public class GroupFragment extends BaseLazyFragment {

    public static final String FG_GROUP_TAG = "group";

    @Bind(R.id.tv_fg_title)
    TextView tvTitle;


    public static GroupFragment newInstance(String tag) {
        GroupFragment fragment = new GroupFragment();
        Bundle args = new Bundle();
        args.putString(FG_GROUP_TAG, tag);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_group;
    }

    @Override
    protected void initViewsAndEvents(View view) {
        tvTitle.setText("群组页");
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
