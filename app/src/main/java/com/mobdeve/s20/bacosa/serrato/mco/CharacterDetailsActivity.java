package com.mobdeve.s20.bacosa.serrato.mco;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class CharacterDetailsActivity extends AppCompatActivity {

    private Button buttonStats, buttonInventory, buttonNotes;
    private ImageButton buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);

        buttonStats = findViewById(R.id.button_stats);
        buttonInventory = findViewById(R.id.button_inventory);
        buttonNotes = findViewById(R.id.button_notes);
        buttonBack = findViewById(R.id.character_details_back_button);
        ImageView profileImage = findViewById(R.id.profile_image);

        // Load the stats fragment by default
        loadFragment(new StatsFragment());

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CharacterDetailsActivity", "Profile icon clicked");
                Intent intent = new Intent(CharacterDetailsActivity.this, ProfileViewActivity.class);
                startActivity(intent);
            }
        });

        buttonStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new StatsFragment());
            }
        });

        buttonInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new InventoryFragment());
            }
        });

        buttonNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new NotesFragment());
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Method to replace the frame layout with the selected fragment
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_content, fragment);
        transaction.commit();
    }
}

