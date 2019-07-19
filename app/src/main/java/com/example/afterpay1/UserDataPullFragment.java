package com.example.afterpay1;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserDataPullFragment extends Fragment {

    TextView name,mobile,email,address;
    public UserDataPullFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_user_data_pull, container, false);
        name=view.findViewById(R.id.FragETxtUserName);
        mobile=view.findViewById(R.id.FragETxtUserMobile);
        email=view.findViewById(R.id.FragETxtUserEmail);
        address=view.findViewById(R.id.FragEtxtUserAddress);
        Bundle bundle = getArguments();
        name.setText(bundle.getString("NameKey"));
        mobile.setText(bundle.getString("MobileKey"));
        email.setText(bundle.getString("EmailKey"));
        address.setText(bundle.getString("AddressKey"));
        
        return view;
    }

}
