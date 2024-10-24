package com.mobdeve.s20.bacosa.serrato.mco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private Button btnAddAccount, btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnAddAccount = findViewById(R.id.btn_add_account);
        btnLogOut = findViewById(R.id.btn_log_out);

        // Handle Add Account button click
        btnAddAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start AddAccountActivity or perform an action
                Toast.makeText(SettingsActivity.this, "Add Account clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Log Out button click
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform logout logic or redirect
                Toast.makeText(SettingsActivity.this, "Log Out clicked", Toast.LENGTH_SHORT).show();
                // Redirect to login screen or perform logout logic
                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);  // Replace with your login activity
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear stack
                startActivity(intent);
                finish(); // Close current activity
            }
        });

        Button btnAddAccount = findViewById(R.id.btn_add_account);
        btnAddAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch AddAccountActivity
                Intent intent = new Intent(SettingsActivity.this, AddAccountActivity.class);
                startActivity(intent);
            }
        });

    }


}
