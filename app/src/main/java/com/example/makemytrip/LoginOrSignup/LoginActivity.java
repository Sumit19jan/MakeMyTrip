package com.example.makemytrip.LoginOrSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.makemytrip.R;

public class LoginActivity extends AppCompatActivity {

    private EditText mEtMobileNumber_LoginActivity;
    private Button mBtnContinue_LoginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        mEtMobileNumber_LoginActivity = findViewById(R.id.etMobileNumber_LoginActivity);
        mBtnContinue_LoginActivity = findViewById(R.id.btnContinue_LoginActivity);
        mBtnContinue_LoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {
                    Intent intent = new Intent(LoginActivity.this, EnterOTP.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Please Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean check() {
        if (mEtMobileNumber_LoginActivity.getText().toString().length() == 10) {
            return true;
        }else {
            mEtMobileNumber_LoginActivity.setError("Enter Correct Mobile Number");
            return false;
        }
    }
}