package com.example.sangam;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
EditText etEmail;
EditText etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int a = 10;
        Button btnForgotPass = findViewById(R.id.btn_Forgot);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);

        btnForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Forgot Password","forgot button le kam garyo");
                /*
                1. euta activity banauna paryo
                2.tyo class ko design pani banaune
                3.tyo activity ma switch hune code yo button click garda lekhna paryo
                 */
               Intent intent =  new Intent(LoginActivity.this,
                       ForgotPassActivity.class);
                startActivity(intent);
            }
        });
    }

    public void LoginClick(View view) {

        String email = etEmail.getText().toString();
        String pass = etPassword.getText().toString();

        Log.e("Email tag", email);
        Log.e("Password tag", pass);

        if(etEmail.getText().toString().isEmpty()){
            etEmail.setError("this field is required");
        }

        if (!email.isEmpty() && !pass.isEmpty()){

        //TODO: Write your logic here
        Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_LONG).show();

        Intent intent =  new Intent(LoginActivity.this,
                DashboardActivity.class);
        startActivity(intent);

        }else{
            Toast.makeText(LoginActivity.this, "Email and Password is required", Toast.LENGTH_LONG).show();
        }

        }
    public void CreateClick(View view){
        Intent intent = new Intent(LoginActivity.this,
                AccountActivity.class);
        startActivity(intent);
    }
}

