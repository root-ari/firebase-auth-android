package com.byteberry.auth;

import android.content.Intent;import android.os.Bundle;
import android.util.Log; // Added
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull; // Added
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener; // Added
import com.google.android.gms.tasks.Task; // Added
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth; // Added
import com.google.firebase.auth.FirebaseUser; // Added

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; // Added TAG
    private EditText email, password;
    private Button signIn, signUp, forgotPass;
    private FirebaseAuth mAuth; // Added mAuth declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        signIn = findViewById(R.id.button);
        signUp = findViewById(R.id.button2);
        forgotPass = findViewById(R.id.forgotPass);

        signIn.setOnClickListener(v -> {
            String emailText = email.getText().toString().trim();
            String passwordText = password.getText().toString().trim();
            // Check if email and password are not empty
            Log.d(TAG, "Email: " + emailText + ", Password: " + passwordText); // Added
            signInUser(emailText, passwordText); // Call the method


            if (!emailText.isEmpty() && !passwordText.isEmpty()) {
                signInUser(emailText, passwordText); // Call the method
            } else {
                Toast.makeText(MainActivity.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            }
        });
        forgotPass.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ForgotPass.class));
            // Usually, you don't call finish() here so the user can go back to login


        });


        signUp.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, signup.class));
            // Usually, you don't call finish() here so the user can go back to login
        });
    }

    private void signInUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(MainActivity.this, "Welcome " + user.getEmail(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, loggedIn.class);
                            startActivity(intent);
                            finish();

                            // Redirect to a Home/Dashboard Activity
                            // startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        } else {
                            // If sign in fails
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed: " + task.getException().getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // User is already signed in, redirect to HomeActivity
            Intent intent = new Intent(MainActivity.this, loggedIn.class);
            startActivity(intent);
            finish();
        }

    }
}