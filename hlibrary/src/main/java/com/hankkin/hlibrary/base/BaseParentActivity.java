package com.hankkin.hlibrary.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.hankkin.hlibrary.AppManager;
import com.hankkin.hlibrary.R;

/**
 * Created by Hankkin on 16/8/7.
 */
public abstract class BaseParentActivity extends BaseEventActivity implements BaseViewInterface {

    public static final int REQUEST_CAMERA = 100;
    public static final int REQUEST_GALLERY = 101;
    public static final int PHOTO_REQUEST_CUT = 102;

    protected LayoutInflater mInflater;
    protected String TAG;
    protected Activity activity;

    public interface OnRightClickListener {
        void rightClick();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        TAG = this.getClass().getSimpleName();
        AppManager.getAppManager().addActivity(this);
        if (getContentId() != 0) {
            setContentView(getContentId());
        }
        super.onCreate(savedInstanceState);
        mInflater = getLayoutInflater();
        activity = this;
        initBind();
        initView(savedInstanceState);
    }

    /**
     * 打开一个Activity 默认 不关闭当前activity
     */
    public void gotoActivity(Class<?> clz) {
        gotoActivity(clz, false, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity) {
        gotoActivity(clz, isCloseCurrentActivity, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, Bundle ex) {
        Intent intent = new Intent(this, clz);
        if (ex != null) intent.putExtras(ex);
        startActivity(intent);
        if (isCloseCurrentActivity) {
            finish();
        }
    }

    /**
     * 统一初始化titlebar
     */
    protected Toolbar initToolBar(String title) {
        ImageView ivBack = (ImageView) findViewById(R.id.tool_bar_back);
        TextView tvTitle = (TextView) findViewById(R.id.tv_toolbar_title);
        tvTitle.setText(title);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setContentInsetsRelative(10, 0);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
        return toolbar;
    }

    /**
     * 统一初始化titlebar右侧图片
     */
    protected Toolbar initToolBarRightImg(String title, int rightId, final OnRightClickListener listener) {
        ImageView ivBack = (ImageView) findViewById(R.id.tool_bar_back);
        TextView tvTitle = (TextView) findViewById(R.id.tv_toolbar_title);
        tvTitle.setText(title);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setContentInsetsRelative(10, 0);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
        ImageView ivRight = (ImageView) findViewById(R.id.iv_tool_bar_right);
        ivRight.setImageResource(rightId);
        ivRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightClick();
            }
        });
        return toolbar;
    }


    /**
     * 统一初始化titlebar右侧文字
     */
    protected Toolbar initToolBarRightTxt(String title, String right, final OnRightClickListener listener) {
        ImageView ivBack = (ImageView) findViewById(R.id.tool_bar_back);
        TextView tvTitle = (TextView) findViewById(R.id.tv_toolbar_title);
        tvTitle.setText(title);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setContentInsetsRelative(10, 0);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
        TextView tvRight = (TextView) findViewById(R.id.tv_tool_bar_right);
        tvRight.setText(right);
        tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightClick();
            }
        });
        return toolbar;
    }

    protected void back() {
        if (activity != null) {
            activity.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected int getContentId() {
        return getLayoutId();
    }

    protected void initBind() {
        ButterKnife.bind(activity);
    }
}
