package andro.heklaton.rsc.ui.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;

import andro.heklaton.rsc.R;
import andro.heklaton.rsc.ui.activity.base.AccountActivity;

public class RegistrationActivity extends AccountActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnLogin = (FloatingActionButton) findViewById(R.id.button_register);

        LinearLayout llLogin = (LinearLayout) findViewById(R.id.ll_login);
        llLogin.setOnClickListener(loginClickListener);
    }

    private View.OnClickListener loginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);

            if (Build.VERSION.SDK_INT > 21) {
                Pair<View, String> p1 = Pair.create(findViewById(R.id.card), "card");
                Pair<View, String> p2 = Pair.create((View) btnLogin, "fab");

                ActivityOptions options = ActivityOptions.
                        makeSceneTransitionAnimation(RegistrationActivity.this, p1, p2);
                startActivity(intent, options.toBundle());

            } else {
                startActivity(intent);
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

}
