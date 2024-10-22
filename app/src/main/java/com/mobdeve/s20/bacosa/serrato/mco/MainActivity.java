package com.mobdeve.s20.bacosa.serrato.mco;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CharacterAdapter characterAdapter;
    private List<Character> characterList;
    private TextView displayName, username;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView profileImage = findViewById(R.id.profile_image);
        displayName = findViewById(R.id.display_name);
        username = findViewById(R.id.username);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE);

        // Load profile data into header
        loadProfileData();

        // Profile image click listener to open profile view
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileViewActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.character_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize character list
        characterList = new ArrayList<>();
        characterList.add(new Character("Aragorn", "Fighter", "01 Jan 2024", 5, "Human", R.drawable.icon1));
        characterList.add(new Character("Marcus Ironwill", "Cleric", "02 Jan 2024", 2, "Warforged", R.drawable.icon2));
        characterList.add(new Character("Gimli", "Warrior", "03 Jan 2024", 6, "Dwarf", R.drawable.icon3));
        // Add more characters...

        characterAdapter = new CharacterAdapter(this, characterList);
        recyclerView.setAdapter(characterAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Reload profile data when returning to this activity
        loadProfileData();
    }

    private void loadProfileData() {
        String name = sharedPreferences.getString("display_name", "Gab");
        String user = sharedPreferences.getString("username", "@gab.bacosa");

        displayName.setText(name);
        username.setText(user);
    }
}
