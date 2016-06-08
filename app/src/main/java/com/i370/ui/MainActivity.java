package com.i370.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.i370.ui.adapter.PagerSlideAdapter;
import com.i370.ui.fragment.BaseFragment;
import com.i370.ui.fragment.DeviceFragment;
import com.i370.ui.fragment.FileTypeFragment;
import com.i370.ui.fragment.PhoneFragment;
import com.i370.ui.view.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import static com.i370.ui.adapter.PagerSlideAdapter.*;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private PagerSlidingTabStrip psts;
    private ViewPager vp;
    private PagerSlideAdapter mPagerSlideAdapter;
    private List<BaseFragment> mFragments;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private String[] mFragmentNames=new String[]{"分类","手机","设备"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        psts= (PagerSlidingTabStrip) findViewById(R.id.psts);
        vp= (ViewPager) findViewById(R.id.vp);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    @Override
    public void initData() {
        toolbar.setTitle("Netac-ZSW");
        toolbar.setSubtitle("连接设备");
        toggle = new ActionBarDrawerToggle( this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        mFragments=new ArrayList<BaseFragment>();
        mFragments.add(new FileTypeFragment());
        mFragments.add(new PhoneFragment());
        mFragments.add(new DeviceFragment());
        mPagerSlideAdapter=new PagerSlideAdapter(getSupportFragmentManager(), vp, mFragments, mSlideItem);
        vp.setAdapter(mPagerSlideAdapter);
        psts.setViewPager(vp);
    }

    @Override
    public void initEvent() {

    }

    PagerSlideItem mSlideItem=new PagerSlideItem() {
        @Override
        public View getPageItemView(int position) {
            View baseView=View.inflate(MainActivity.this, R.layout.main_fragment_item, null);
            TextView tv= (TextView) baseView.findViewById(R.id.tv);
            tv.setText(mFragmentNames[position]);
            return baseView;
        }
    };
}
