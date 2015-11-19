package andro.heklaton.rsc.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import andro.heklaton.rsc.R;
import andro.heklaton.rsc.ui.fragment.SettingsFragment;

public class SettingsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }

}
