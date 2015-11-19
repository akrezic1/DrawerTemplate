package andro.heklaton.rsc.ui.activity;

import andro.heklaton.rsc.R;
import andro.heklaton.rsc.ui.activity.base.BaseSplash;

public class SplashActivity extends BaseSplash {

    @Override
    public int provideLayoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    public int getSplashTime() {
        return 1000;
    }

    @Override
    public Class getNextClassActivity() {
        return LoginActivity.class;
    }
}
