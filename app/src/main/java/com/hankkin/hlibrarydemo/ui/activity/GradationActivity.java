package com.hankkin.hlibrarydemo.ui;

import android.os.Bundle;

import com.hankkin.hlibrary.base.BaseParentActivity;
import com.hankkin.hlibrarydemo.R;

import butterknife.OnClick;

public class GradationActivity extends BaseParentActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_gradation;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @OnClick(R.id.btn_qq)
    void goQQBanner(){
        gotoActivity(QQSpeakActivity.class);
    }

    @OnClick(R.id.btn_banner)
    void goBanner(){
        gotoActivity(BannerActivity.class);
    }
}
