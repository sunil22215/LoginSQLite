package com.example.loginsqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper mydb;
    private EditText editTextName;
    private EditText editTextMoNumber;
    private EditText editTextEmail;
    private EditText editTextCityName;
    private EditText editTextPassword;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mydb = new DatabaseHelper(this);

        initView();
        initListener();
    }

    private void initView() {
        editTextName = findViewById(R.id.editTextName);
        editTextMoNumber = findViewById(R.id.editTextMoNumber);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextCityName = findViewById(R.id.editTextCityName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSubmit = findViewById(R.id.buttonSubmit);
    }

    private void initListener() {
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String monumber = editTextMoNumber.getText().toString();
                String email = editTextEmail.getText().toString();
                String city = editTextCityName.getText().toString();
                String password = editTextPassword.getText().toString();

                if (name.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter name", Toast.LENGTH_SHORT).show();
                    if (monumber.equals("")) {
                        Toast.makeText(getApplicationContext(), "please Enter monumber", Toast.LENGTH_SHORT).show();
                        if (email.equals("")) {
                            Toast.makeText(RegisterActivity.this, "please enter email", Toast.LENGTH_SHORT).show();
                            if (city.equals("")) {
                                Toast.makeText(RegisterActivity.this, "please enter city", Toast.LENGTH_SHORT).show();
                                if (password.equals("")) {
                                    Toast.makeText(RegisterActivity.this, "please enter password", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}