package com.mobdeve.s20.bacosa.serrato.mco;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StatsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        // Example of showing stats content
        //TextView statsText = view.findViewById(R.id.stats_text);
        //statsText.setText("Character Stats: Strength: 10, Dexterity: 12, Intelligence: 15...");

        return view;
    }
}

