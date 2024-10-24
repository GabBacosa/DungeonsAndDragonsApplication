package com.mobdeve.s20.bacosa.serrato.mco;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileViewActivity extends AppCompatActivity {
    private Button buttonBack;
    private EditText editDisplayName, editUsername, editBio;
    private Button btnSave, btnBack;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);

        buttonBack = findViewById(R.id.profile_back_button);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editDisplayName = findViewById(R.id.edit_display_name);
        editUsername = findViewById(R.id.edit_username);
        editBio = findViewById(R.id.edit_bio);
        btnSave = findViewById(R.id.btn_save);

        sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE);

        // Load saved data from SharedPreferences
        loadProfileData();

        // Save button click listener
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveProfileData();
            }
        });

        // Any additional setup for profile view can go here
    }

    private void loadProfileData() {
        String displayName = sharedPreferences.getString("display_name", "Gab");
        String username = sharedPreferences.getString("username", "@gab.bacosa");
        String bio = sharedPreferences.getString("bio", "This is a bio about the user.");

        editDisplayName.setText(displayName);
        editUsername.setText(username);
        editBio.setText(bio);
    }

    // Save profile data to SharedPreferences
    private void saveProfileData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("display_name", editDisplayName.getText().toString());
        editor.putString("username", editUsername.getText().toString());
        editor.putString("bio", editBio.getText().toString());
        editor.apply();

        Toast.makeText(ProfileViewActivity.this, "Profile updated", Toast.LENGTH_SHORT).show();
        finish();  // Close the profile page and go back
    }

    public void openSettingsPage(View view) {
        Intent intent = new Intent(ProfileViewActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

}