package andro.heklaton.rsc.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import andro.heklaton.rsc.R;
import andro.heklaton.rsc.api.RestAPI;
import andro.heklaton.rsc.model.login.LoginRequest;
import andro.heklaton.rsc.model.login.User;
import andro.heklaton.rsc.util.Constants;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = (Button) findViewById(R.id.button_login);
        btnLogin.setOnClickListener(loginClickListener);

        LinearLayout llRegister = (LinearLayout) findViewById(R.id.ll_register);
        llRegister.setOnClickListener(registrationClickListener);
    }

    private View.OnClickListener loginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(Constants.ENDPOINT)
                    .build();

            RestAPI api = adapter.create(RestAPI.class);
            api.login(RestAPI.HEADER, new LoginRequest("user", "123456"), new Callback<User>() {
                @Override
                public void success(User user, Response response) {

                }

                @Override
                public void failure(RetrofitError error) {

                }
            });
        }
    };

    private View.OnClickListener registrationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);

            if (Build.VERSION.SDK_INT > 21) {
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(LoginActivity.this, findViewById(R.id.card), "card");
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
