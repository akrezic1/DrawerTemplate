package andro.template.drawertemplate.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import andro.template.drawertemplate.R;
import andro.template.drawertemplate.ui.fragment.SettingsFragment;

public class SettingsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }

}
