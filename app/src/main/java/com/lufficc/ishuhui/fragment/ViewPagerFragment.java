package com.lufficc.ishuhui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.lufficc.ishuhui.R;
import com.lufficc.ishuhui.adapter.FragmentsAdapter;

import butterknife.BindView;

public class ViewPagerFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    public void initialize(@Nullable Bundle savedInstanceState) {
        super.initialize(savedInstanceState);
        viewPager.setAdapter(new FragmentsAdapter(getChildFragmentManager()));
        viewPager.addOnPageChangeListener(this);
    }

    private ViewPager.OnPageChangeListener onPageChangeListener;

    public static ViewPagerFragment newInstance() {
        return new ViewPagerFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ViewPager.OnPageChangeListener) {
            onPageChangeListener = (ViewPager.OnPageChangeListener) context;
        }
    }

    @Override
    public String toString() {
        return "搜索";
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_view_pager;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (onPageChangeListener != null)
            onPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
    }

    @Override
    public void onPageSelected(int position) {
        if (onPageChangeListener != null)
            onPageChangeListener.onPageSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (onPageChangeListener != null)
            onPageChangeListener.onPageScrollStateChanged(state);
    }

    public void setCurrentFragment(int index) {
        viewPager.setCurrentItem(index);
    }
}