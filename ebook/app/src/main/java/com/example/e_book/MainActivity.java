package com.example.e_book;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    PDFView pdf;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setupView();

        homeFragment homeFragment=new homeFragment();
        profileFragment profileFragment=new profileFragment();
        settingFragment settingFragment=new settingFragment();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home_icon){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,homeFragment).commit();

                }
                else if(item.getItemId()==R.id.profile_icon){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,profileFragment).commit();

                }
                else if(item.getItemId()==R.id.setting_icon){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,settingFragment).commit();

                }
                return true;
            }
        });

        //adding home as default
        bottomNavigationView.setSelectedItemId(R.id.home_icon);


    }

    private void setupView() {
        //adding bottom menu
        bottomNavigationView=findViewById(R.id.bottom_navigation);
    }

}