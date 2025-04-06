package com.example.e_book;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class termsFragment extends Fragment {
    TextView txtTerms;
    Button btn;



    public termsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_terms, container, false);
        //View view                 --> ساخت یک شی از کلاس View
        //inflater.inflate          --> کار اصلی برنامه مارا انحام می دهد تبدیل فایل های لایه دیزاین(لایه رابط کاربری) به اشیا ویو
        //container                 --> محل قرار گیری ویو های جدید را مشخص می کند که به صورت خودکار به ویو
        // که انفلیت شده متصل نمی شود و پارامتر بعدی این مورد را تعییت می کند
        //attachToRoot : false      -->  متصل نشودcontainer یعنی ویو انفایت شده بلافاصله به


        txtTerms=view.findViewById(R.id.txtTerms);
        btn=view.findViewById(R.id.btnRead);
        txtTerms.setText("Hey there! We’re so happy to have you here. Before you dive in, here are a few simple things to keep in mind:\n" +
                "\t1.\tEnjoy the App!\n" +
                "This app is designed to make your experience fun and easy. Feel free to explore and enjoy every moment!\n" +
                "\t2.\tBe Kind & Respectful\n" +
                "Let’s keep things positive! Treat others with respect, and don’t use the app in ways that might ruin the fun for everyone.\n" +
                "\t3.\tYour Privacy Matters\n" +
                "We respect your privacy and keep your data safe. No sneaky business here!\n" +
                "\t4.\tUpdates & Improvements\n" +
                "We’re always working to make things better, so expect updates from time to time.\n" +
                "\n" +
                "That’s it! No complicated rules—just a great experience for you. By continuing, you agree to these simple guidelines.\n" +
                "\n" +
                "Now, go ahead and have fun! \uD83D\uDE80✨\n");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
                //getActivity -->  دسترسی به اکتیویتی فعلی
                //popBackStack -->  نمایش لایه زیرین به رو یعنی نمایش دوباره لایه ای که زیر این اکتیویتی بوده
            }
        });

        return view;
    }
}