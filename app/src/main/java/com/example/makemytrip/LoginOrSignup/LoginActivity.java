package com.example.makemytrip.LoginOrSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.makemytrip.R;
import com.example.makemytrip.adapter.ViewPagerLoginAdapter;
import com.example.makemytrip.response.ViewPagerModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    private EditText mEtMobileNumber_LoginActivity;
    private Button mBtnContinue_LoginActivity;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    private FirebaseAuth firebaseAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private ArrayList<ViewPagerModel> viewPagerModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        initViews();
    }

    private void initViews() {
        mEtMobileNumber_LoginActivity = findViewById(R.id.etMobileNumber_LoginActivity);
        mBtnContinue_LoginActivity = findViewById(R.id.btnContinue_LoginActivity);
        viewPager2 = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        ProgressBar progressBar = findViewById(R.id.progressBar_LoginActivity);
        bulidData();
        setViewPagerAdapter();
        mBtnContinue_LoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {
                    progressBar.setVisibility(View.VISIBLE);
                    mBtnContinue_LoginActivity.setVisibility(View.INVISIBLE);
                    mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                        @Override
                        public void onVerificationCompleted(PhoneAuthCredential credential) {
                        }

                        @Override
                        public void onVerificationFailed(FirebaseException e) {
                            progressBar.setVisibility(View.GONE);
                            mBtnContinue_LoginActivity.setVisibility(View.VISIBLE);
                            Toast.makeText(LoginActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCodeSent(@NonNull String verificationId,
                                               @NonNull PhoneAuthProvider.ForceResendingToken token) {
                            progressBar.setVisibility(View.GONE);
                            mBtnContinue_LoginActivity.setVisibility(View.VISIBLE);
                            Toast.makeText(LoginActivity.this, "opt Successfully sent", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this,EnterOTP.class);
                            intent.putExtra("mobile",mEtMobileNumber_LoginActivity.getText().toString().trim());
                            intent.putExtra("verificationId",verificationId);
                            startActivity(intent);

                        }
                    };

                    PhoneAuthOptions options =
                            PhoneAuthOptions.newBuilder(firebaseAuth)
                                    .setPhoneNumber("+91"+mEtMobileNumber_LoginActivity.getText().toString().trim())
                                    .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                    .setActivity(LoginActivity.this)                 // Activity (for callback binding)
                                    .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                                    .build();
                    PhoneAuthProvider.verifyPhoneNumber(options);
                } else {
                    Toast.makeText(LoginActivity.this, "Please Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void bulidData() {
        viewPagerModels.add(new ViewPagerModel(R.drawable.l1));
        viewPagerModels.add(new ViewPagerModel(R.drawable.l2));
        viewPagerModels.add(new ViewPagerModel(R.drawable.l3));
    }

    private void setViewPagerAdapter() {
        ViewPagerLoginAdapter viewPagerLoginAdapter = new ViewPagerLoginAdapter(viewPagerModels);
        viewPager2.setAdapter(viewPagerLoginAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
            }
        }).attach();
    }

    public boolean check() {
        if (mEtMobileNumber_LoginActivity.getText().toString().length() == 10) {
            return true;
        } else {
            mEtMobileNumber_LoginActivity.setError("Enter Correct Mobile Number");
            return false;
        }
    }
}