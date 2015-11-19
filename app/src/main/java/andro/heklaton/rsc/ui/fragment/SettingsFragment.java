package andro.heklaton.rsc.ui.fragment;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;

public class SettingsFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {

    EditTextPreference editTextPreference;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(getActivity());

        editTextPreference = new EditTextPreference(getActivity());
        editTextPreference.setKey("key");
        editTextPreference.setTitle("Title");
        editTextPreference.setDefaultValue("5");
        editTextPreference.setSummary("Summary");

        editTextPreference.setOnPreferenceChangeListener(this);

        screen.addPreference(editTextPreference);

        PreferenceCategory category = new PreferenceCategory(getActivity());
        category.setTitle("Category");

        screen.addPreference(category);

        CheckBoxPreference checkBoxPref = new CheckBoxPreference(getActivity());
        checkBoxPref.setTitle("Title");
        checkBoxPref.setChecked(false);
        checkBoxPref.setKey("check");

        category.addPreference(checkBoxPref);

        setPreferenceScreen(screen);

    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return true;
    }


}