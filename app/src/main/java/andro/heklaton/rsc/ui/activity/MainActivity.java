package andro.heklaton.rsc.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import andro.heklaton.rsc.R;
import andro.heklaton.rsc.ui.activity.base.DrawerActivity;
import andro.heklaton.rsc.ui.adapter.PagerAdapter;
import andro.heklaton.rsc.ui.fragment.PagerGridFragment;
import andro.heklaton.rsc.ui.fragment.PagerListFragment;

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
        fragments.add(new PagerListFragment());
        fragments.add(new PagerGridFragment());
        fragments.add(new PagerListFragment());
        return fragments;
    }

}
