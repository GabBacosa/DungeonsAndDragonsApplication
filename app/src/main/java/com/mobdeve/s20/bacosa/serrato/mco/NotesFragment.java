package com.mobdeve.s20.bacosa.serrato.mco;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NotesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        // Example of showing notes content
        //TextView notesText = view.findViewById(R.id.notes_text);
        //notesText.setText("Character Notes: Journey started from village...");

        return view;
    }
}

