package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                boolean isInserted = mydb.addUser(editTextName.getText().toString(),
                        editTextMoNumber.getText().toString(),
                        editTextEmail.getText().toString(),
                editTextCityName.getText().toString(),
                       editTextPassword.getText().toString());

                if (isInserted = true)
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Data Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });


    }
}