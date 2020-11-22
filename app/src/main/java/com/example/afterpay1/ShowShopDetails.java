package com.example.afterpay1;

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
        dbHelper = new DBHelper(getApplicationContext());
        db=dbHelper.getReadableDatabase();
        Cursor cursor=dbHelper.showshop(db);
        String id,name,address,result="";
        while(cursor.moveToNext())
        {
            id=cursor.getString(cursor.getColumnIndex(Contract.ShopTable.SHOP_ID));
            name=cursor.getString(cursor.getColumnIndex(Contract.ShopTable.SHOP_NAME));
            address=cursor.getString(cursor.getColumnIndex(Contract.ShopTable.ADDRESS));
            result="\n\n"+id+"\n\n"+name+"\n\n"+address;
        }

        textView.setText("result");

    }
}
