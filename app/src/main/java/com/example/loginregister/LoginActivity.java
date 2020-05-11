package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//import com.google.android.gms.auth.api.signin.GoogleSignIn;
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
//import com.google.android.gms.auth.api.signin.GoogleSignInClient;
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
//import com.google.android.gms.common.SignInButton;
//import com.google.android.gms.common.api.ApiException;
//import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;


public class LoginActivity extends AppCompatActivity {

    EditText emailEditText;
    TextInputLayout passwordTextInput;
    Button loginButton, registerButton;
    //SignInButton signInButton; //used for sign in with google
    // GoogleSignInClient mGoogleSignInClient; //used for sign in with google
    //int RC_SIGN_IN = 0;

    //private Helper helper; //helper class used for database
    public static String EMAIL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");

        //Dbhelper = new PetDbHelper(this);

//        signInButton = findViewById(R.id.googleSignInButton);
//        signInButton.setSize(SignInButton.SIZE_WIDE); //customize the sign in button
//        signInButton.setTextAlignment(SignInButton.TEXT_ALIGNMENT_CENTER); //customize the sign in button

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail().build();

        // Build a GoogleSignInClient with the options specified by gso.
        //mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        emailEditText = findViewById(R.id.LoginEmail_editText);
        passwordTextInput = findViewById(R.id.LoginPassword_editText);
        loginButton = findViewById(R.id.login_btn);
        registerButton = findViewById(R.id.register_btn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                EMAIL = email;//this is used in Edit Account page
                String password = Objects.requireNonNull(passwordTextInput.getEditText()).getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "you have to enter email and password", Toast.LENGTH_SHORT).show();
                }
//              else if (authenticateUser(email, password)) {
//                      //todo navigate to the activity you want after log in succeeds
//                    Intent intent = new Intent(LoginActivity.this, Activity.class);
//                    intent.putExtra("Activity", "LogIn");//passing the name of the current activity so you know where you are coming from
//                    startActivity(intent);
//              }
                else {
                    Toast.makeText(LoginActivity.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //when click Google sign in button
//        signInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                signIn();
//            }
//        });
    }

    //sign in with google
//    private void signIn() {
//
//        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//        startActivityForResult(signInIntent, RC_SIGN_IN);
//    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
//            // The Task returned from this call is always completed, no need to attach
//            // a listener.
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            handleSignInResult(task);
//        }
//    }

    //handle sign in with google
//    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
//        try {
//            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
//
//            // Signed in successfully
//            Intent intent = new Intent(LoginActivity.this, CatalogActivity.class);
//            intent.putExtra("Activity", "LogIn");
//            startActivity(intent);
//        } catch (ApiException e) {
//            // The ApiException status code indicates the detailed failure reason.
//            // Please refer to the GoogleSignInStatusCodes class reference for more information.
//            Log.w("Google Sign In Error", "signInResult:failed code=" + e.getStatusCode());
//            Toast.makeText(LoginActivity.this, "signIn failed", Toast.LENGTH_SHORT).show();
//        }
//    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        // Check for existing Google Sign In account, if the user is already signed in
//        // the GoogleSignInAccount will be non-null.
//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
//        if (account != null) {
//            startActivity(new Intent(LoginActivity.this, CatalogActivity.class));
//        }
//    }

    //this will close the app onBackPressed
    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }

//    public boolean authenticateUser(String email, String password) {
//       //todo write code to authenticate user
//    }
}
