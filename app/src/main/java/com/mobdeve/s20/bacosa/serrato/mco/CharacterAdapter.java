package com.mobdeve.s20.bacosa.serrato.mco;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private Context context;
    private List<Character> characterList;

    // Constructor
    public CharacterAdapter(Context context, List<Character> characterList) {
        this.context = context;
        this.characterList = characterList;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.character_item, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characterList.get(position);

        // Bind data to the views
        holder.characterName.setText(character.getName());
        holder.className.setText(character.getClassName());
        holder.species.setText(character.getSpecies());
        holder.userLevel.setText("Level " + character.getLevel());
        holder.dateCreated.setText(character.getDateCreated());
        holder.characterIcon.setImageResource(character.getIconResource());


        // Set click listener to open CharacterDetailsActivity
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CharacterDetailsActivity.class);

            // Pass character details to the intent
            intent.putExtra("character_name", character.getName());
            intent.putExtra("class_name", character.getClassName());
            intent.putExtra("species", character.getSpecies());
            intent.putExtra("level", character.getLevel());
            intent.putExtra("date_created", character.getDateCreated());

            // Start the new activity
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    // ViewHolder class for RecyclerView items
    public static class CharacterViewHolder extends RecyclerView.ViewHolder {

        TextView characterName, className, species, userLevel, dateCreated;
        ImageView characterIcon;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views
            characterName = itemView.findViewById(R.id.character_name);
            className = itemView.findViewById(R.id.class_name);
            species = itemView.findViewById(R.id.species);
            userLevel = itemView.findViewById(R.id.user_level);
            dateCreated = itemView.findViewById(R.id.date_created);
            characterIcon = itemView.findViewById(R.id.character_icon);
        }
    }
}

