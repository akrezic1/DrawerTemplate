package andro.heklaton.rsc.ui.activity.base;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import andro.heklaton.rsc.R;
import andro.heklaton.rsc.ui.util.ViewHelper;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

public class AccountActivity extends AppCompatActivity {

    private boolean loginDisabled = true;
    protected EditText etUsername;
    protected EditText etPassword;
    protected FloatingActionButton btnLogin;
    private SmoothProgressBar progressBar;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        progressBar = (SmoothProgressBar) findViewById(R.id.progress_smooth);

        etUsername = (EditText) findViewById(R.id.username);
        etUsername.addTextChangedListener(textWatcher);

        etPassword = (EditText) findViewById(R.id.password);
        etPassword.addTextChangedListener(textWatcher);
    }

    /**
     * TextWatcher used to track of text in EditText for login/registration. If it's empty make icon gray,
     * otherwise make it accent
     */
    protected TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // set enabled color if there is text in EditText
            if (etUsername.getText().toString().equals("") || etPassword.getText().toString().equals("")) {
                if (!loginDisabled) {
                    loginDisabled = true;
                    ViewHelper.animateFabColorChange(AccountActivity.this, btnLogin, R.color.colorAccent, R.color.gray_fab);
                }

            } else {
                if (loginDisabled) {
                    loginDisabled = false;
                    ViewHelper.animateFabColorChange(AccountActivity.this, btnLogin, R.color.gray_fab, R.color.colorAccent);
                }
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

    protected String getUsername() {
        return etUsername.getText().toString();
    }

    protected String getPassword() {
        return etUsername.getText().toString();
    }

    protected void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    protected void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

}
