package com.example.afterpay1;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserIDSearchFragment extends Fragment {




    EditText IdSearch;
    public UserIDSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_user_idsearch, container, false);
        IdSearch = view.findViewById(R.id.NUeTxtSearchID);
        view.findViewById(R.id.NUIDSearchBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             DBHelper dbHelper = new DBHelper(getContext());
             String idSrch=IdSearch.getText().toString();
               SQLiteDatabase db = dbHelper.getReadableDatabase();
               Cursor cursor= dbHelper.getUserDetail(db,idSrch);

                if(cursor.moveToFirst())
                {
                    String name= cursor.getString(cursor.getColumnIndex(Contract.StudentTable.NAME));
                    String mobile= cursor.getString(cursor.getColumnIndex(Contract.StudentTable.MOBILE));
                    String email= cursor.getString(cursor.getColumnIndex(Contract.StudentTable.EMAIL));
                    String address= cursor.getString(cursor.getColumnIndex(Contract.StudentTable.ADDRESS));
                    Bundle bundle = new Bundle();
                    bundle.putString("NameKey",name);
                    bundle.putString("MobileKey",mobile);
                    bundle.putString("EmailKey",email);
                    bundle.putString("AddressKey",address);
                    UserDataPullFragment userDataPullFragment = new UserDataPullFragment();
                    userDataPullFragment.setArguments(bundle);
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container,userDataPullFragment).commit();

                }
            }
        });
        return view;
    }

}
