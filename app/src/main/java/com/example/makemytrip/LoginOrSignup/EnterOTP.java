package com.example.makemytrip.LoginOrSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.makemytrip.MainActivity;
import com.example.makemytrip.R;

public class EnterOTP extends AppCompatActivity {

    private EditText mEtOTP_EnterOTP;
    private Button mBtnSubmit_EnterOTP;
    private ImageView mIvBack_EnterOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);
        initViews();
    }

    private void initViews() {
        mEtOTP_EnterOTP = findViewById(R.id.etOpt_EnterOTP);
        mBtnSubmit_EnterOTP = findViewById(R.id.btnSubmit_EnterOTP);
        mIvBack_EnterOTP = findViewById(R.id.ivBack_EnterOTP);
        mBtnSubmit_EnterOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()){
                    Intent intent = new Intent(EnterOTP.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(EnterOTP.this, "Please correct enter opt", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mIvBack_EnterOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnterOTP.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean check() {
        if (mEtOTP_EnterOTP.getText().toString() .equals("8642") ) {
            return true;
        }else {
            mEtOTP_EnterOTP.setError("Enter correct opt");
            return false;
        }
    }
}