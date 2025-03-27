package com.example.e_book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;


public class homeFragment extends Fragment {

    ListView genre_listView;
    ArrayList<CustomListview> itemListview;



    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        genre_listView=view.findViewById(R.id.Home_genre_lv);
        fillList();
        MyArrayAdapterCustomListview adapter=new MyArrayAdapterCustomListview(getActivity(),R.layout.custom_listview_item,itemListview);
        genre_listView.setAdapter(adapter);

        return view;
    }
    private void fillList() {
        itemListview= new ArrayList<CustomListview>();
        itemListview.add(new CustomListview(R.drawable.mystery,"Mystery"));
        itemListview.add(new CustomListview(R.drawable.romance,"Romance"));
        itemListview.add(new CustomListview(R.drawable.fantasy,"Fantasy"));
        itemListview.add(new CustomListview(R.drawable.comics,"Comics"));
    }
}