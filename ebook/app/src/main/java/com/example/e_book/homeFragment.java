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
    ArrayList<String> genre;
    ListView genre_listView;



    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        genre_listView=view.findViewById(R.id.Home_genre_lv);
        genre=new ArrayList<String>(Arrays.asList("Mystery","Romance","Comics","Fantasy"));
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,genre);
        genre_listView.setAdapter(adapter);

        return view;
    }
}