package com.example.lets_talk.ui.changepassword;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import com.example.lets_talk.R;

public class ListMenuFragment extends ListFragment {
    String[] users = new String[]{"Cristiano Ronaldo", "Romelu Lukaku", "Emma Raducanu", "Luis Hamilton", "Naomi Osaka"};
    String[] location = new String[] {"Manchester", "London", "New York", "Paris", "Tokyo"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listitems_info, container,false );
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, users);
        setListAdapter(adapter);
        return view;
    }
}
