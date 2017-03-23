package com.hankkin.hlibrary.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

import com.hankkin.hlibrary.R;

import butterknife.ButterKnife;

/**
 * Created by Hankkin on 2017/3/1.
 * 注释:
 */

public class ProgressDialog extends Dialog {

    private Context context;

    public ProgressDialog(Context context) {
        super(context, R.style.progress);
        this.context = context;
        init();
    }

    private void init(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_progress);
        ButterKnife.bind(this);

        //设置SelectPicPopupWindow弹出窗体的背景
        getWindow().setBackgroundDrawableResource(R.color.transparent);
    }


    @Override
    public void onBackPressed() {
        dismiss();
    }

}
