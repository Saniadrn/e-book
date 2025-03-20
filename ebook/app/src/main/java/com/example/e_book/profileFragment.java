package com.example.e_book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class profileFragment extends Fragment {
    TextView txtName;
    TextView txtLastName;
    TextView txtPhone;


    EditText edtName;

    EditText edtLastName;
    EditText edtPhone;
    Button btnLogin;



    public profileFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        txtName=view.findViewById(R.id.txtName);
        txtLastName=view.findViewById(R.id.txtLastName);
        txtPhone=view.findViewById(R.id.txtPhone);
        edtName=view.findViewById(R.id.edtName);
        edtLastName=view.findViewById(R.id.edtLastName);
        edtPhone=view.findViewById(R.id.edtPhone);
        btnLogin=view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(!(edtName.getText().toString().isEmpty())&&!(edtLastName.getText().toString().isEmpty())&&!(edtPhone.getText().toString().isEmpty())){
                    txtName.setText(edtName.getText().toString());
                    txtLastName.setText(edtLastName.getText().toString());
                    txtPhone.setText(edtPhone.getText().toString());
                    Toast.makeText(getContext(),"Login successful!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(),"Login failed.Please fill all the requierd fields.",Toast.LENGTH_LONG).show();
                }
            }
        });


        return view;
    }



}