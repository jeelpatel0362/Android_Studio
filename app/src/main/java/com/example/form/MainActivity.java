package com.example.form;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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

        initBinding();

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
                if (validateForm(name, email, mobileNo, dob, age, password1, password2)) {
                    Toast.makeText(MainActivity.this, "Form submitted successfully!!", Toast.LENGTH_SHORT).show();
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

    // initialize
    private void initBinding() {
        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editMobileNo = findViewById(R.id.editMno);
        editDOB = findViewById(R.id.editDob);
        editAge = findViewById(R.id.edit_age);
        userPassword1 = findViewById(R.id.userPassword1);
        userPassword2 = findViewById(R.id.userPassword2);
        submitButton = findViewById(R.id.submitButton);
        clearButton = findViewById(R.id.clearButton);


    }

    private boolean validateForm(String name, String email, String mobileNo, String dob, String age, String password1, String password2) {

        // Name
        
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "Name is reqired", Toast.LENGTH_SHORT).show();
            return false;
        } else if (name.length() < 3) {
            Toast.makeText(getApplicationContext(), "Name should have at least 3 characters", Toast.LENGTH_SHORT).show();
            return false;
        }

        // email

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Email is required", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(getApplicationContext(), "Enter valid Email address", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Mobile no.

        if(TextUtils.isEmpty(mobileNo)){
            Toast.makeText(getApplicationContext(), "Mobile no. is required", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!Patterns.PHONE.matcher(mobileNo).matches() ) {
            Toast.makeText(getApplicationContext(), "Enter valid Mobile number", Toast.LENGTH_SHORT).show();
            return false;
        }else if (!(mobileNo.length() == 10)){
            Toast.makeText(getApplicationContext(), "Enter 10-Digit Mobile number", Toast.LENGTH_SHORT).show();
            return false;
        }

        //Date of Birth
        if(TextUtils.isEmpty(dob)) {
            Toast.makeText(getApplicationContext(), "Date of birth is required", Toast.LENGTH_SHORT).show();
            return false;
        }

        //Age

        if(TextUtils.isEmpty(age)){
            Toast.makeText(getApplicationContext(), "Age is required", Toast.LENGTH_SHORT).show();
            return false;
        }

        //Password 1

        if(TextUtils.isEmpty(password1)){
            Toast.makeText(getApplicationContext(),"Password is required",Toast.LENGTH_SHORT).show();
            return  false;
        } else if (password1.length() < 8) { // length
            Toast.makeText(getApplicationContext(),"Password should have at least 8 characters",Toast.LENGTH_SHORT).show();
            return  false;
        } else if (!password1.matches(".*[A-Z].*")) {
            Toast.makeText(getApplicationContext(),"Password should have at least 1 Uppercase characters",Toast.LENGTH_SHORT).show();
            return  false;
        } else if (!password1.matches(".*[a-z].*")) {
            Toast.makeText(getApplicationContext(), "Password should have at least 1 lower characters", Toast.LENGTH_SHORT).show();
            return false;
        }else if (!password1.matches(".*[0-9].*")) {
            Toast.makeText(getApplicationContext(),"Password should have at least 1 digit",Toast.LENGTH_SHORT).show();
            return  false;
        }else if (!password1.matches(".*[@#$%^&*+=_!].*")) {
            Toast.makeText(getApplicationContext(),"Password should have at least 1 special character",Toast.LENGTH_SHORT).show();
            return  false;
        }

        //Confirm Password

        if(TextUtils.isEmpty(password2)){
            Toast.makeText(MainActivity.this, "Confirm password is required!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!password1.equals(password2)) {

            Toast.makeText(MainActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}