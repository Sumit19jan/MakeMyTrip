package com.example.makemytrip.LoginOrSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.makemytrip.MainActivity;
import com.example.makemytrip.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class EnterOTP extends AppCompatActivity {

    private EditText mEtOTP_EnterOTP;
    private ImageView mIvBack_EnterOTP;
    private String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);
        initViews();
    }

    private void initViews() {
        mEtOTP_EnterOTP = findViewById(R.id.etOpt_EnterOTP);
        final Button mBtnSubmit_EnterOTP = findViewById(R.id.btnSubmit_EnterOTP);
        mIvBack_EnterOTP = findViewById(R.id.ivBack_EnterOTP);
        ProgressBar progressBar = findViewById(R.id.progressBar_EnterOtp);
        verificationId = getIntent().getStringExtra("verificationId");
        mBtnSubmit_EnterOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                mBtnSubmit_EnterOTP.setVisibility(View.INVISIBLE);
                if (verificationId != null) {
                    String code = mEtOTP_EnterOTP.getText().toString().trim();
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
                    FirebaseAuth.getInstance()
                            .signInWithCredential(credential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        progressBar.setVisibility(View.VISIBLE);
                                        mBtnSubmit_EnterOTP.setVisibility(View.INVISIBLE);
                                        Toast.makeText(EnterOTP.this, "opt verified", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(EnterOTP.this, MainActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(EnterOTP.this, "Otp is not Valid", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                        mBtnSubmit_EnterOTP.setVisibility(View.VISIBLE);
                                    }
                                }
                            });
                }
            }
        });

        mIvBack_EnterOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnterOTP.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}