package com.hankkin.hlibrary.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import com.hankkin.hlibrary.event.EventMap;
import com.hankkin.hlibrary.utils.ToastUtils;
import com.hankkin.hlibrary.widget.dialog.ProgressDialog;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Hankkin on 16/12/23.
 * 注释:event基类,顶级
 */

public class BaseEventActivity extends AppCompatActivity{
    private ProgressDialog progress;
    protected Activity mActivity;
    private boolean hasBus = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        if (hasBus)
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    /**
     * 事件观察者
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(EventMap.BaseEvent event){
        if (event != null && event instanceof EventMap.HExceptionEvent){
            if (!TextUtils.isEmpty(event.message)){
                ToastUtils.showToast(mActivity,event.message);
            }
        }
    }

    /**
     * 显示loading
     */
    public void showLoadingDialog() {
        if (progress == null){
            progress = new ProgressDialog(mActivity);
        }
        progress.show();
    }

    /**
     * 隐藏loading
     */
    public void dismissLoadingDialog() {
        if (progress != null) {
            progress.dismiss();
        }
    }

    public boolean isHasBus() {
        return hasBus;
    }

    public void setHasBus(boolean hasBus) {
        this.hasBus = hasBus;
        if (hasBus)
            EventBus.getDefault().register(this);
    }
}
