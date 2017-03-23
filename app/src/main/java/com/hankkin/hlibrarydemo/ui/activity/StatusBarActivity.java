package com.hankkin.hlibrarydemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import com.hankkin.hlibrary.base.BaseParentActivity;
import com.hankkin.hlibrary.utils.statusbar.StatusBarUtil;
import com.hankkin.hlibrary.widget.view.NoScrollViewPager;
import com.hankkin.hlibrarydemo.ui.GroupFragment;
import com.hankkin.hlibrarydemo.ui.HomeFragment;
import com.hankkin.hlibrarydemo.ui.MeFragment;
import com.hankkin.hlibrarydemo.ui.SMSFragment;
import java.util.ArrayList;
import java.util.List;

public class StatusBarActivity extends BaseParentActivity {


    @Bind(R.id.vp)
    NoScrollViewPager mViewPager;
    @Bind(R.id.iv_home) ImageView ivHome;
    @Bind(R.id.iv_message)
    ImageView ivMessage;
    @Bind(R.id.iv_group)
    ImageView ivRequirement;
    @Bind(R.id.iv_personal)
    ImageView ivPersonal;

    @Bind(R.id.tv_home) TextView tvHome;
    @Bind(R.id.tv_message)
    TextView tvMessage;
    @Bind(R.id.tv_requirement)
    TextView tvRequirement;
    @Bind(R.id.tv_personal)
    TextView tvPersonal;

    private HomeFragment mHomeFragment;
    private SMSFragment mSMSFragment;
    private GroupFragment mGroupFragment;
    private MeFragment mFragment;

    private List<Fragment> fragments;

    private int normalTextColor;
    private int selectTextColor;

    private boolean isPerson = false;


    @Override
    public int getLayoutId() {
        return R.layout.activity_status_bar;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        normalTextColor = getResources().getColor(R.color.grey_text_color);
        selectTextColor = getResources().getColor(R.color.colorPrimary);
        StatusBarUtil.setTransparentForImageView(activity, null);
        initFgs();
    }


    private void initFgs() {
        fragments = new ArrayList<>();
        mHomeFragment = HomeFragment.newInstance(HomeFragment.FG_HOME_TAG);
        mSMSFragment = SMSFragment.newInstance(SMSFragment.FG_SMS_TAG);
        mGroupFragment = GroupFragment.newInstance(GroupFragment.FG_GROUP_TAG);
        mFragment = MeFragment.newInstance(MeFragment.FG_ME_TAG);
        fragments.add(mHomeFragment);
        fragments.add(mSMSFragment);
        fragments.add(mGroupFragment);
        fragments.add(mFragment);
        mViewPager.setAdapter(new StarusFragmentAdapter(getSupportFragmentManager(), fragments));
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setPagingEnabled(false);
        mViewPager.setPadding(0, StatusBarUtil.getStatusBarHeight(this), 0, 0);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary), 0);

    }


    @OnClick(R.id.ll_home)
    void showHome() {
        setTabSelection(0);
    }

    @OnClick(R.id.ll_message)
    void showMessage() {
        setTabSelection(1);
    }

    @OnClick(R.id.ll_group)
    void showRequirement() {
        setTabSelection(2);
    }

    @OnClick(R.id.ll_personal)
    void showPersonal() {
        setTabSelection(3);
    }


    /**
     * 设置底部tab切换状态
     *
     * @param index
     */
    private void setTabSelection(int index) {
        clearSelection();

        switch (index) {
            case 0:
                if (isPerson) {
                    mViewPager.setPadding(0, 0, 0, 0);
                    resetFragmentView(mHomeFragment);
                    StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary), 0);
                }
                // TODO: 16/7/9  设置选中状态
                //                ivHome.setImageResource(R.drawable.xiaoyou_yaowen_comment);
                tvHome.setTextColor(selectTextColor);
                mViewPager.setCurrentItem(0,false);
                break;
            case 1:
                if (isPerson) {
                    mViewPager.setPadding(0, 0, 0, 0);
                    resetFragmentView(mSMSFragment);
                    StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary), 0);
                }
                // TODO: 16/7/9  设置选中状态
                //                ivMessage.setImageResource(R.drawable.tabman);
                tvMessage.setTextColor(selectTextColor);
                mViewPager.setCurrentItem(1,false);
                break;
            case 2:
                if (isPerson) {
                    mViewPager.setPadding(0, 0, 0, 0);
                    resetFragmentView(mGroupFragment);
                    StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary), 0);
                }
                //                ivRequirement.setImageResource(R.drawable.xiaoyou_yaowen_green_circlepenhover);
                tvRequirement.setTextColor(selectTextColor);
                mViewPager.setCurrentItem(2,false);
                break;
            case 3:
                isPerson = true;
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
                    mViewPager.setPadding(0, 0, 0, 0);
                }
                StatusBarUtil.setTransparentForImageViewInFragment(activity, null);
                // TODO: 16/7/9  设置选中状态
                //                ivPersonal.setImageResource(R.drawable.xiaoyou_yaowen_graychilun);
                tvPersonal.setTextColor(selectTextColor);
                mViewPager.setCurrentItem(3,false);
                break;
            default:
                break;
        }
    }

    /**
     * 清空tab状态
     */
    private void clearSelection() {
        tvHome.setTextColor(normalTextColor);
        tvMessage.setTextColor(normalTextColor);
        tvRequirement.setTextColor(normalTextColor);
        tvPersonal.setTextColor(normalTextColor);
    }


    public void resetFragmentView(Fragment fragment) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            View contentView = findViewById(android.R.id.content);
            if (contentView != null) {
                ViewGroup rootView;
                rootView = (ViewGroup) ((ViewGroup) contentView).getChildAt(0);
                if (rootView.getPaddingTop() != 0) {
                    rootView.setPadding(0, 0, 0, 0);
                }
            }
            if (fragment != null) {
                if (fragment.getView() != null) {
                    fragment.getView().setPadding(0, StatusBarUtil.getStatusBarHeight(this), 0, 0);
                }
            }
        }
    }


    /**
     * Created by Hankkin on 15/9/20.
     */
    public class StarusFragmentAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragments;

        public StarusFragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
            super(fm);
            this.mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }


    }


}
