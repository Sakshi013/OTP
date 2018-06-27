 package com.example.sakshi.androidpermission;

import android.Manifest;
import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Telephony;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Permission;
import java.util.Random;

 public class MainActivity extends AppCompatActivity {
     private EditText num, text;
     private Button send;

     private static final int REQUEST_CODE_SMS =101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num =findViewById(R.id.num);
        text =findViewById(R.id.text);
        send =findViewById(R.id.send);

        String[] permission ={
                Manifest.permission.SEND_SMS
        };

        if (ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(MainActivity.this,permission,123);

        }
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String PhoneNo = num.getText().toString().trim();
                String message = text.getText().toString().trim();

//sms manager

                SmsManager sms =SmsManager.getDefault();

//                to make otp
                 Random r =new Random();
                int i1 =r.nextInt(9999 - 1111) + 1111;
                String messageNumber = i1+"";


                sms.sendTextMessage(PhoneNo,null,messageNumber,null,null);

//                to put otp

                Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("message",messageNumber);
                startActivity(intent);




            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 123){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                Toast.makeText(MainActivity.this,"permission granted",Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(MainActivity.this,"Not granted",Toast.LENGTH_SHORT).show();






        }


    }
}



