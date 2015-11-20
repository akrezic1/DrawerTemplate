package andro.heklaton.rsc.ui.activity.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;

import andro.heklaton.rsc.R;

public abstract class BaseSplash extends AppCompatActivity {

    private final String TAG = BaseSplash.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayoutRes());
        main();
    }

    public void main() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(getBaseContext(), getNextClassActivity());

                if (Build.VERSION.SDK_INT > 21) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(BaseSplash.this, findViewById(R.id.card), "card");
                    startActivity(intent, options.toBundle());

                } else {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                }

                finish();
            }
        }, getSplashTime());
    }

    public abstract int provideLayoutRes();

    public abstract int getSplashTime();

    public abstract Class getNextClassActivity();
}