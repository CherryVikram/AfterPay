package com.example.afterpay1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowShopDetails extends AppCompatActivity {

    DBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_details_activity);
        TextView textView = findViewById(R.id.txtShopShowInfo);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("SHOP_DETAILS"));

    }
}
