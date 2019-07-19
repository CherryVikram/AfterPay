package com.example.afterpay1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class TempActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = dbHelper.showUsers( db);
        String info="";
        String mobile,name;
        textView=findViewById(R.id.tempUserDisplay);
        while (cursor.moveToNext())
        {
            mobile=cursor.getString(cursor.getColumnIndex(Contract.StudentTable.COLLEGE_ID));
            name=cursor.getString(cursor.getColumnIndex(Contract.StudentTable.NAME));
             info +="\n\n"+mobile+"\n\n"+name+"\n";
        }
        textView.setText(info);
    }
}
