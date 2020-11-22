package com.example.afterpay1;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText userId,userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userId=findViewById(R.id.eTxtCollegeID);
        userPassword=findViewById(R.id.eTxtPassword);
        findViewById(R.id.loginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((userId.getText().toString().equals("184CA010") && userPassword.getText().toString().equals("HelloAdmin"))||
                        (userId.getText().toString().equals("184CA059") && userPassword.getText().toString().equals("HelloAdmin")))
                {
                    startActivity(new Intent(MainActivity.this,AdministratorActivity.class));
                }else if((userId.getText().toString().equals("184CA027") && userPassword.getText().toString().equals("Sthapak")))
                {
                    // Fetch Details From DB Student and verify and Login
                    //Call this Activty

                   startActivity(new Intent(MainActivity.this,StudentDetailsActivity.class));
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.signUpBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NewUserActivity.class));
            }
        });
    }
}
