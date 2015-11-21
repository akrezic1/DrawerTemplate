package andro.heklaton.rsc.ui.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.activeandroid.query.Delete;

import andro.heklaton.rsc.R;
import andro.heklaton.rsc.api.RestAPI;
import andro.heklaton.rsc.api.request.LoginRequest;
import andro.heklaton.rsc.gcm.RegistrationIntentService;
import andro.heklaton.rsc.model.login.Data;
import andro.heklaton.rsc.model.login.PostCategory;
import andro.heklaton.rsc.model.login.User;
import andro.heklaton.rsc.ui.activity.base.AccountActivity;
import andro.heklaton.rsc.util.Constants;
import andro.heklaton.rsc.util.PrefsHelper;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends AccountActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        // start intent to get GCM token
        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);

        btnLogin = (FloatingActionButton) findViewById(R.id.button_login);
        btnLogin.setOnClickListener(loginClickListener);

        LinearLayout llRegister = (LinearLayout) findViewById(R.id.ll_register);
        llRegister.setOnClickListener(registrationClickListener);
    }

    private View.OnClickListener loginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showProgress();

            // check if both username and pass was entered
            if (getUsername().length() == 0 || getPassword().length() == 0) {
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

                            hideProgress();

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        hideProgress();
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
                Pair<View, String> p1 = Pair.create(findViewById(R.id.card), "card");
                Pair<View, String> p2 = Pair.create((View) btnLogin, "fab");

                ActivityOptions options = ActivityOptions.
                        makeSceneTransitionAnimation(LoginActivity.this, p1, p2);
                startActivity(intent, options.toBundle());

            } else {
                startActivity(intent);
            }
        }
    };

}
