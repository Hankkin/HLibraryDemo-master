package com.hankkin.hlibrarydemo.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hankkin.hlibrary.widget.gradationscroll.GradationScrollView;
import com.hankkin.hlibrary.widget.gradationscroll.StatusBarUtil;
import com.hankkin.hlibrarydemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class QQSpeakActivity extends AppCompatActivity implements GradationScrollView.ScrollViewListener{

    @Bind(R.id.scrollview) GradationScrollView scrollView;

    @Bind(R.id.listview) ListView listView;

    @Bind(R.id.textview) TextView textView;
    @Bind(R.id.iv_banner) ImageView ivBanner;
    private int height;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        StatusBarUtil.setImgTransparent(this);
        setContentView(R.layout.activity_qqspeak);
        ButterKnife.bind(this);
        initView(savedInstanceState);
    }


    public void initView(Bundle savedInstanceState) {
        ivBanner.setFocusable(true);
        ivBanner.setFocusableInTouchMode(true);
        ivBanner.requestFocus();
        initListeners();
        initData();
    }

    /**
     * 获取顶部图片高度后，设置滚动监听
     */
    private void initListeners() {

        ViewTreeObserver vto = ivBanner.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                textView.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);
                height = ivBanner.getHeight();

                scrollView.setScrollViewListener(QQSpeakActivity.this);
            }
        });
    }



    private void initData() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(QQSpeakActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.data));
        listView.setAdapter(adapter);
    }


    /**
     * 滑动监听
     * @param scrollView
     * @param x
     * @param y
     * @param oldx
     * @param oldy
     */
    @Override
    public void onScrollChanged(GradationScrollView scrollView, int x, int y,
                                int oldx, int oldy) {
        // TODO Auto-generated method stub
        if (y <= 0) {   //设置标题的背景颜色
            textView.setBackgroundColor(Color.argb((int) 0, 144,151,166));
        } else if (y > 0 && y <= height) { //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
            float scale = (float) y / height;
            float alpha = (255 * scale);
            textView.setTextColor(Color.argb((int) alpha, 255,255,255));
            textView.setBackgroundColor(Color.argb((int) alpha, 144,151,166));
        } else {    //滑动到banner下面设置普通颜色
            textView.setBackgroundColor(Color.argb((int) 255, 144,151,166));
        }
    }
}
