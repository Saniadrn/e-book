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
        //View view                 --> ساخت یک شی از کلاس View
        //inflater.inflate          --> کار اصلی برنامه مارا انحام می دهد تبدیل فایل های لایه دیزاین(لایه رابط کاربری) به اشیا ویو
        //container                 --> محل قرار گیری ویو های جدید را مشخص می کند که به صورت خودکار به ویو
        // که انفلیت شده متصل نمی شود و پارامتر بعدی این مورد را تعییت می کند
        //attachToRoot : false      -->  متصل نشودcontainer یعنی ویو انفایت شده بلافاصله به

        genre_listView=view.findViewById(R.id.Home_genre_lv);
        fillList();
        MyArrayAdapterCustomListview adapter=new MyArrayAdapterCustomListview(getActivity(),
                R.layout.custom_listview_item,
                itemListview,getParentFragmentManager());
        //1. MyArrayAdapterCustomlistview       --> این کلاس به احتمال زیاد یک آداپتور سفارشی
        // (custom adapter) است که برای مدیریت داده‌ها و نمایش آن‌ها در ListView طراحی شده است.
        //2. getActivity                        --> بازگرداندن اکتیویتی جاری
        //3. itemListview                       --> لیست مورد نظر
        //4. getParentFragmentManager           --> این متد در Fragment ها استفاده می‌شود و در اینجا برای دستیابی به FragmentManager والد استفاده می‌شود

        //در کل، این خط کد یک شیء از MyArrayAdapterCustomListview ایجاد می‌کند که بخشی از لیست
        // (ListView) را مدیریت می‌کند و اطلاعات را بر اساس مجموعه‌ی داده‌های itemListview و
        // از طریق نمای مربوط به آیتم‌های سفارشی R.layout.custom_listview_item نمایش می‌دهد.
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