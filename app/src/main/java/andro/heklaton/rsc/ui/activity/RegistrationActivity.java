package andro.heklaton.rsc.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import andro.heklaton.rsc.R;

/**
 * Created by Andro on 11/19/2015.
 */
public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button btnRegister = (Button) findViewById(R.id.button_register);

        LinearLayout llLogin = (LinearLayout) findViewById(R.id.ll_login);
        llLogin.setOnClickListener(loginClickListener);
    }

    private View.OnClickListener loginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);

            if (Build.VERSION.SDK_INT > 21) {
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(RegistrationActivity.this, findViewById(R.id.card), "card");
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
