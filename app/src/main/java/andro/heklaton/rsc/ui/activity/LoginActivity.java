package andro.heklaton.rsc.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.activeandroid.query.Delete;

import andro.heklaton.rsc.R;
import andro.heklaton.rsc.api.RestAPI;
import andro.heklaton.rsc.api.request.LoginRequest;
import andro.heklaton.rsc.model.login.Data;
import andro.heklaton.rsc.model.login.PostCategory;
import andro.heklaton.rsc.model.login.User;
import andro.heklaton.rsc.util.Constants;
import andro.heklaton.rsc.util.PrefsHelper;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private SmoothProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FloatingActionButton btnLogin = (FloatingActionButton) findViewById(R.id.button_login);
        btnLogin.setOnClickListener(loginClickListener);

        LinearLayout llRegister = (LinearLayout) findViewById(R.id.ll_register);
        llRegister.setOnClickListener(registrationClickListener);

        etUsername = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);

        progressBar = (SmoothProgressBar) findViewById(R.id.progress_smooth);
    }

    private View.OnClickListener loginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            progressBar.setVisibility(View.VISIBLE);

            // check if both username and pass was entered
            if (etUsername.getText().toString().length() == 0 || etPassword.getText().toString().length() == 0) {
                Toast.makeText(LoginActivity.this, R.string.no_username_or_password, Toast.LENGTH_SHORT).show();

            } else {
                RestAdapter adapter = new RestAdapter.Builder()
                        .setEndpoint(Constants.ENDPOINT)
                        .build();

                RestAPI api = adapter.create(RestAPI.class);
                api.login(RestAPI.HEADER, new LoginRequest("user", "123456"), new Callback<User>() {
                    @Override
                    public void success(User user, Response response) {
                        if (user.getStatus().equals("ok")) {

                            // delete existing data
                            new Delete().from(User.class).execute();
                            new Delete().from(PostCategory.class).execute();
                            new Delete().from(Data.class).execute();

                            // Save user data locally
                            user.save();
                            user.getData().save();
                            for (PostCategory pc : user.getConfig().getPostCategories()) {
                                pc.save();
                            }

                            PrefsHelper.saveEmail(LoginActivity.this, user.getData().getEmail());
                            PrefsHelper.saveUsername(LoginActivity.this, user.getData().getUsername());
                            PrefsHelper.saveToken(LoginActivity.this, user.getData().getToken());

                            progressBar.setVisibility(View.GONE);

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }


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
