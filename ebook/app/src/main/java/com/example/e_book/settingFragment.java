package com.example.e_book;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;


public class settingFragment extends Fragment {
    RadioGroup rg;
    Layout l;





    public settingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_setting, container, false);
        rg=view.findViewById(R.id.rg);



        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rdoBtnRed){
                    getActivity().getWindow().getDecorView().setBackgroundColor(Color.RED);}
                else if(checkedId==R.id.rdoBtnWhite){
                        getActivity().getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                }
                else if(checkedId==R.id.rdoBtnGray){
                    getActivity().getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.gray));
                }
                else if(checkedId==R.id.rdoBtnPink){
                    getActivity().getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.pink));
                }
                else if(checkedId==R.id.rdoBtnPurple){
                    getActivity().getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.purple));
                }
                else if(checkedId==R.id.rdoBtnYellow){
                    getActivity().getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else if(checkedId==R.id.rdoBtnGreen){
                    getActivity().getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.green));
                }
                else if(checkedId==R.id.rdoBtnOrange){
                    getActivity().getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.orange));
                }

            }

        });



        return view;
    }
}