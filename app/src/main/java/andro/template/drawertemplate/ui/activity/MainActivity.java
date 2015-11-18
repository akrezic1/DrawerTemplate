package andro.template.drawertemplate.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import andro.template.drawertemplate.ui.activity.base.DrawerActivity;
import andro.template.drawertemplate.R;
import andro.template.drawertemplate.ui.adapter.PagerAdapter;
import andro.template.drawertemplate.ui.fragment.PagerFragment;

public class MainActivity extends DrawerActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public int getNavigationItemPosition() {
        return 0;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), getPagerFragments());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private List<Fragment> getPagerFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new PagerFragment());
        fragments.add(new PagerFragment());
        fragments.add(new PagerFragment());
        return fragments;
    }

}
