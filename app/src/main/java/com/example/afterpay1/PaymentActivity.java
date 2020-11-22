package com.example.afterpay1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class PaymentActivity extends AppCompatActivity {
    String shopID="";
    EditText editTextAmt;
    DBHelper dbHelper;
    SQLiteDatabase db;
    double amount;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_activity);
        Intent intent = getIntent();
        editTextAmt = findViewById(R.id.payment_eTxt_view);
        shopID=intent.getStringExtra("SHOP_ID");
        dbHelper = new DBHelper(getApplicationContext());

        Date dNow = new Date( );
        SimpleDateFormat ft =
                new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        final String date= ft.format(dNow);
        findViewById(R.id.payment_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=dbHelper.getWritableDatabase();
                long cr = dbHelper.addTransaction(shopID,editTextAmt.getText().toString(),MainActivity.std_id,date,db);
                if(cr!=-1){
                    Toast.makeText(PaymentActivity.this,"Transaction Successful",Toast.LENGTH_LONG).show();
                }else
                   Toast.makeText(PaymentActivity.this,"Transaction Fail",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
