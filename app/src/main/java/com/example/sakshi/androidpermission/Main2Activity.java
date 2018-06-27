package com.example.sakshi.androidpermission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {


    EditText OTP;
    Button otpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        OTP = findViewById(R.id.OTP);
        otpButton = findViewById(R.id.otpButton);

        String  message = getIntent().getStringExtra("message");


// sending of otp ......
        final int s1 = Integer.valueOf(message);





        otpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                when user gets otp and after that he sees the otp and confirms the otp

                String UserOTP = OTP.getText().toString().trim();

                Integer s2 = Integer.valueOf(UserOTP);
// value of otp got by the user equal to value of otp  received
                if (s1 == s2) {
                    Toast.makeText(Main2Activity.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(Main2Activity.this, "Wrong Otp", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

