package com.example.afterpay1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class PaymentActivity extends AppCompatActivity {
    String shopID="";
    EditText editTextAmt;
    double amount;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_activity);
        Intent intent = getIntent();
        editTextAmt = findViewById(R.id.payment_eTxt_view);
        shopID=intent.getStringExtra("SHOP_ID");

        Date dNow = new Date( );
        SimpleDateFormat ft =
                new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        String date= ft.format(dNow);

    }
}
