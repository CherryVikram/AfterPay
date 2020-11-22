package com.example.afterpay1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ShopActivity  extends AppCompatActivity {
    EditText shopname,shopid,shopmobile,shopemail,shopaddress;
    DBHelper dbHelper;
    SQLiteDatabase db;
    String result="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        shopname=findViewById(R.id.AeTxtShopName);
        shopid=findViewById(R.id.AeTxtShopID);
        shopmobile=findViewById(R.id.AeTxtShopMobile);
        shopemail=findViewById(R.id.AeTxtShopEmail);
        shopaddress=findViewById(R.id.AeTxtShopAddress);
        dbHelper=new DBHelper(getApplicationContext());
        findViewById(R.id.AShopRegistrationBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             db=dbHelper.getWritableDatabase();
             long a=dbHelper.addshop(shopid.getText().toString(),shopname.getText().toString(),shopmobile.getText().toString(),
                     shopemail.getText().toString(),shopaddress.getText().toString(),db);
             if(a!=-1)
                 Toast.makeText(ShopActivity.this,"shop added succesfully",Toast.LENGTH_SHORT).show();
             else
                 Toast.makeText(ShopActivity.this,"ERROR ",Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.AShopShowBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=dbHelper.getReadableDatabase();
                Cursor cursor=dbHelper.showshop(db);
                String id,name,address;
                while(cursor.moveToNext())
                {
                    id=cursor.getString(cursor.getColumnIndex(Contract.ShopTable.SHOP_ID));
                    name=cursor.getString(cursor.getColumnIndex(Contract.ShopTable.SHOP_NAME));
                    address=cursor.getString(cursor.getColumnIndex(Contract.ShopTable.ADDRESS));
                    result+="\n\n"+id+"\n\n"+name+"\n\n"+address;
                }
                showMessage(result);
            }
        });
    }

    private void showMessage(String result) {
        Intent intent = new Intent(this,ShowShopDetails.class);
        intent.putExtra("SHOP_DETAILS",result);
        startActivity(intent);

    }
}
