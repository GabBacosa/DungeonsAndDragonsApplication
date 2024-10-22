package com.mobdeve.s20.bacosa.serrato.mco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CharacterAdapter characterAdapter;
    private List<Character> characterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView profileImage = findViewById(R.id.profile_image);

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileViewActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.character_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the character list
        characterList = new ArrayList<>();
        characterList.add(new Character("Aragorn", "Fighter", "01 Jan 2024", 5, "Human", R.drawable.icon1));
        characterList.add(new Character("Marcus Ironwill", "Cleric", "02 Jan 2024", 2, "Warforged", R.drawable.icon1));
        characterList.add(new Character("Gimli", "Warrior", "03 Jan 2024", 6, "Dwarf", R.drawable.icon3));
        // Add more characters...


        characterAdapter = new CharacterAdapter(this, characterList);

        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(characterAdapter);

    }


}
