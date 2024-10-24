package com.mobdeve.s20.bacosa.serrato.mco;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddAccountActivity extends AppCompatActivity {

    private EditText editNewUsername, editNewPassword;
    private Button btnCreateAccount;

    // SharedPreferences file name
    private static final String PREFS_NAME = "userPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        editNewUsername = findViewById(R.id.edit_new_username);
        editNewPassword = findViewById(R.id.edit_new_password);
        btnCreateAccount = findViewById(R.id.btn_create_account);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUsername = editNewUsername.getText().toString().trim();
                String newPassword = editNewPassword.getText().toString().trim();

                // Simple validation for empty fields
                if (TextUtils.isEmpty(newUsername)) {
                    editNewUsername.setError("Username required");
                    return;
                }
                if (TextUtils.isEmpty(newPassword)) {
                    editNewPassword.setError("Password required");
                    return;
                }

                // Save the account using SharedPreferences
                SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(newUsername, newPassword); // Store the username as key and password as value
                editor.apply(); // Commit changes

                Toast.makeText(AddAccountActivity.this, "Account created successfully!", Toast.LENGTH_SHORT).show();

                // Redirect back to login page
                Intent intent = new Intent(AddAccountActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
