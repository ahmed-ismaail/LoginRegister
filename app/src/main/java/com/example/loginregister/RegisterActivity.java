package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    EditText nameEditText, emailEditText;
    TextInputLayout passwordTextInput, confirmPasswordTextInput;
    Button registerButton;
    //private Helper helper; //this helper is used for the database to save the registration data

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setTitle("Register");

        // helper = new helper(this); //making an instance form the helper class

        nameEditText = findViewById(R.id.name_editText);
        emailEditText = findViewById(R.id.email_editText);
        passwordTextInput = findViewById(R.id.password_editText);
        confirmPasswordTextInput = findViewById(R.id.confirmPassword_editText);
        registerButton = findViewById(R.id.register_button);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = Objects.requireNonNull(passwordTextInput.getEditText()).getText().toString();
                String confirmPassword = Objects.requireNonNull(confirmPasswordTextInput.getEditText()).getText().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) ||
                        TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "you have to fill all fields", Toast.LENGTH_SHORT).show();
                } else if (!TextUtils.isEmpty(password) && !TextUtils.isEmpty(confirmPassword) &&
                        !password.equals(confirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "password doesn't match", Toast.LENGTH_SHORT).show();
                } else if (!TextUtils.isEmpty(email) && !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailEditText.setError("Invalid email");
                }
                //use this to make sure the user email doesn't already exist
//              else if (isAlreadyExist(email)) {
//                    emailEditText.setError("email already exist choose another one ");
//                }
                else {
                    //addClerk(); //todo here you add the user data to the database
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

//    public void addUser() {
//        //todo add user to your database
//    }

//    public boolean isAlreadyExist(String email) {
//        //todo assert the entered email does't exist in the database in case you want to make the email unique
//    }
}
