package com.example.lets_talk.ui.settings;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.lets_talk.R;
import com.example.lets_talk.databinding.FragmentHomeBinding;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }

}