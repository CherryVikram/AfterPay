package com.example.afterpay1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdministratorActivity extends AppCompatActivity {


    EditText userId,username,userMobile,userEmail,userAddress;
    DBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);

        userId=findViewById(R.id.AeTxtUserID);
        username=findViewById(R.id.AeTxtUserName);
        userMobile=findViewById(R.id.AeTxtUserMobile);
        userEmail=findViewById(R.id.AeTxtUserEmail);
        userAddress=findViewById(R.id.AeTxtUserAddress);

        dbHelper = new DBHelper(getApplicationContext());

        findViewById(R.id.ashopRegistrationBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdministratorActivity.this,ShopActivity.class));
            }
        });
       findViewById(R.id.AuserRegistrationBtn).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

                db = dbHelper.getWritableDatabase();
               long g=dbHelper.adduser(userId.getText().toString(),username.getText().toString(),
                       userMobile.getText().toString(),userEmail.getText().toString(),userAddress.getText().toString(),db);
               if(g!=-1)
               Toast.makeText(AdministratorActivity.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
               else{
                   Toast.makeText(AdministratorActivity.this, "User Already Exist", Toast.LENGTH_SHORT).show();
               }
           }
       });

       findViewById(R.id.AuserShowBtn).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

              startActivity(new Intent(AdministratorActivity.this,TempActivity.class));

           }
       });

       findViewById(R.id.AuserDeleteBtn).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               db=dbHelper.getWritableDatabase();
               dbHelper.deleteUser(userId.getText().toString(),db);
               Toast.makeText(AdministratorActivity.this, "User Deleted Successfully..!", Toast.LENGTH_SHORT).show();
           }
       });
    }
}
