package com.example.e_book;

import static com.example.e_book.R.id.chkBox1;
import static com.example.e_book.R.id.imgprofile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
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
    ImageView imgprofile;
    ImageView imgseccessful;
    Button btnConditions;
    CheckBox chkBox;



    public profileFragment() {
        // Required empty public constructor
    }



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        SetupView(view);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(chkBox.isChecked()){
                    if(!(edtName.getText().toString().isEmpty())&&!(edtLastName.getText().toString().isEmpty())&&!(edtPhone.getText().toString().isEmpty())){
                        Toast.makeText(getContext(),"Login successful!",Toast.LENGTH_LONG).show();
                        imgseccessful.setImageResource(R.drawable.seccessful);
                    }else{
                        Toast.makeText(getContext(),"Login failed.Please fill all the requierd fields.",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getContext(),"Login failed.Please read and accept the Terms and Conditions.",Toast.LENGTH_LONG).show();
                }


            }
        });


        btnConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                termsFragment termsFragment=new termsFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,termsFragment).addToBackStack(null).commit();
            }
        });


        return view;
    }

    private void SetupView(View view) {
        edtName=view.findViewById(R.id.edtName);
        edtLastName=view.findViewById(R.id.edtLastName);
        edtPhone=view.findViewById(R.id.edtPhone);
        imgprofile = view.findViewById(R.id.imgprofile);
        imgseccessful = view.findViewById(R.id.imgseccessful);
        btnLogin=view.findViewById(R.id.btnLogin);
        btnConditions=view.findViewById(R.id.btnConditions);
        chkBox=view.findViewById(R.id.chkBox1);
    }


}