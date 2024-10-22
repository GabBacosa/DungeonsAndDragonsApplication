package com.mobdeve.s20.bacosa.serrato.mco;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InventoryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);

        // Example of showing inventory content
        //TextView inventoryText = view.findViewById(R.id.inventory_text);
        //inventoryText.setText("Character Inventory: Sword, Shield, Potion...");

        return view;
    }
}

