package com.example.form;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText editName, editEmail, editMobileNo, editDOB, editAge, userPassword1, userPassword2;
    private Button submitButton, clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editMobileNo = findViewById(R.id.editMno);
        editDOB = findViewById(R.id.editDob);
        editAge = findViewById(R.id.edit_age);
        userPassword1 = findViewById(R.id.userPassword1);
        userPassword2 = findViewById(R.id.userPassword2);
        submitButton = findViewById(R.id.submitButton);
        clearButton = findViewById(R.id.clearButton);

        //Submit Button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String email = editEmail.getText().toString();
                String mobileNo = editMobileNo.getText().toString();
                String dob = editDOB.getText().toString();
                String age = editAge.getText().toString();
                String password1 = userPassword1.getText().toString();
                String password2 = userPassword2.getText().toString();

                // data check
                if (name.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Name is required!", Toast.LENGTH_SHORT).show();
                    editName.setError("This field is empty");

                } else if (email.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Email is required!", Toast.LENGTH_SHORT).show();
                    editEmail.setError("This field is empty");

                } else if (mobileNo.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Mobile number is required!", Toast.LENGTH_SHORT).show();
                    editMobileNo.setError("This field is empty");

                } else if (dob.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Date of Birth is required!", Toast.LENGTH_SHORT).show();
                    editDOB.setError("This field is empty");

                } else if (age.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Age is required!", Toast.LENGTH_SHORT).show();
                    editAge.setError("This field is empty");

                } else if (password1.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Password is required!", Toast.LENGTH_SHORT).show();
                    userPassword1.setError("Password is required!");

                } else if (password2.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Confirm password is required!", Toast.LENGTH_SHORT).show();
                    userPassword2.setError("Confirm Password is required!");

                } else if (!password1.equals(password2)) {

                    Toast.makeText(MainActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(MainActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Clear Button
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
                editEmail.setText("");
                editMobileNo.setText("");
                editDOB.setText("");
                editAge.setText("");
                userPassword1.setText("");
                userPassword2.setText("");
                Toast.makeText(MainActivity.this, "Cleared", Toast.LENGTH_SHORT).show();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}