package com.example.group2sw5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Signup extends AppCompatActivity {
    //++++++++++++++++++++++++++
    EditText firstName, lastName, usernameEditText,passwordEditText;
    RadioButton maleRadioButton,femaleRadioButton;
    Button save;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //++++++++++++++++++++++++++
        maleRadioButton = findViewById(R.id.maleRadioButton);
        firstName = findViewById(R.id.firstNameEditText);
        lastName = findViewById(R.id.lastNameTextView);
        usernameEditText = findViewById(R.id.usernameTextView);
        passwordEditText = findViewById(R.id.passwordTextView);
        save = findViewById(R.id.saveButton);
        preferences = getSharedPreferences("user", Context.MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //++++++++++++++++++++++++++
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("firstName", firstName.getText().toString());
                editor.putString("lastName", lastName.getText().toString());
                if (maleRadioButton.isChecked()){
                    editor.putString("sex", "Male");
                } else {
                    editor.putString("sex", "Female");
                }
                editor.putString("usernameEditText", usernameEditText.getText().toString());
                editor.putString("passwordEditText", passwordEditText.getText().toString());
                editor.apply();

                Intent intent = new Intent(Signup.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}