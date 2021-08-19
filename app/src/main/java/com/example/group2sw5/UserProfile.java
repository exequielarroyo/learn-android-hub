package com.example.group2sw5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {
    TextView firstNameTextView, lastNameTextView, usernameTextView, passwordTextView;
    RadioButton maleRadioButton, femaleRadioButton;
    Button editButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        firstNameTextView = findViewById(R.id.firstNameTextView);
        lastNameTextView = findViewById(R.id.lastNameTextView);
        usernameTextView = findViewById(R.id.usernameTextView);
        passwordTextView = findViewById(R.id.passwordTextView);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);
        editButton = findViewById(R.id.editButton);
        logoutButton = findViewById(R.id.logoutButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, PreferencesActivity.class);
                startActivity(intent);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(UserProfile.this);
//                SharedPreferences.Editor editor = sp.edit();
//                editor.putString("firstName", "");
//                editor.putString("lastName", "");
//                editor.putString("sex", "");
//                editor.putString("usernameEditText", "");
//                editor.putString("passwordEditText", "");
//                editor.apply();

                AlertDialog.Builder builder = new AlertDialog.Builder(UserProfile.this);
                builder.setMessage("Do you want to logout?");
                builder.setCancelable(true);
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        firstNameTextView.setText(sp.getString("firstName", ""));
        lastNameTextView.setText(sp.getString("lastName", ""));
        if (sp.getString("sex", "Male").equals("Male")) {
            maleRadioButton.setChecked(true);
        } else {
            femaleRadioButton.setChecked(true);
        }
        usernameTextView.setText(sp.getString("usernameEditText", ""));
        passwordTextView.setText(sp.getString("passwordEditText", ""));
    }
}