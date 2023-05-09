package com.example.nt118n11mmcl_projectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText etUserName;
    private EditText etPassWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
            etUserName = findViewById(R.id.username);
            etPassWord = findViewById(R.id.password);
            Button btn = findViewById(R.id.login_bt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName = etUserName.getText().toString();
                String PassWord = etPassWord.getText().toString();

                if (UserName.equalsIgnoreCase("nhom9") && PassWord.equalsIgnoreCase("nhom9")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else if (UserName.isEmpty() || PassWord.isEmpty()) {
                    Toast.makeText(LoginActivity.this,
                                    "Missing Information", Toast.LENGTH_SHORT)
                            .show();

                }
                else {
                    Toast.makeText(LoginActivity.this,
                                    "Wrong Information", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }
}