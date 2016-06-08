package com.i370.ui.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.i370.ui.fragment.BaseFragment;
import com.i370.ui.view.PagerSlidingTabStrip;

import java.util.List;

/**
 * Created by siwei.zhao on 2016/6/8.
 */
public class PagerSlideAdapter extends MyPagerAdapter implements PagerSlidingTabStrip.ViewTabProvider{

    private PagerSlideItem mSlideItem;

    public PagerSlideAdapter(FragmentManager fragmentManager, ViewPager viewPager, List<BaseFragment> fragments, PagerSlideItem itemView) {
        super(fragmentManager, viewPager, fragments);
        this.mSlideItem=itemView;
    }

    @Override
    public View getPageTabView(int position) {
        if(mSlideItem!=null)return mSlideItem.getPageItemView(position);
        return null;
    }

    public static abstract class PagerSlideItem{

        public abstract View getPageItemView(int position);

    }
}
