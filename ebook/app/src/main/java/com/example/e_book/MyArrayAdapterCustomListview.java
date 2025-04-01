package com.example.e_book;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class MyArrayAdapterCustomListview extends ArrayAdapter {
    private Context context;
    private int Layoutresource;
    private ArrayList<CustomListview> itemList;
    private FragmentManager parentFragmentManager;
    public MyArrayAdapterCustomListview(Context context, int Layoutresource, ArrayList<CustomListview> itemList, FragmentManager parentFragmentManager) {
        super(context,Layoutresource,itemList);
        this.context=context;
        this.Layoutresource=Layoutresource;
        this.itemList=itemList;
        this.parentFragmentManager=parentFragmentManager;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public CustomListview getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        CustomListview item=itemList.get(position);
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(Layoutresource,parent,false);
            ViewHolder holder=new ViewHolder(convertView);
            holder.fillItem(item);
            convertView.setTag(holder);
        }else{
            //chun fazaye hafeze ro holder migire
            ViewHolder holder=(ViewHolder)convertView.getTag();
            holder.fillItem(item);

        }
        return convertView;
    }
    class ViewHolder{
        TextView txtGenre;
        ImageView imgGenre;
        public ViewHolder(View convetView){
            txtGenre=(TextView) convetView.findViewById(R.id.txtGenre);
            imgGenre=(ImageView) convetView.findViewById(R.id.imgGenre);
        }

        public void fillItem(CustomListview item){
            txtGenre.setText(item.getTxt().toString());
            imgGenre.setImageResource(item.getImage());
            booksFragment booksFragment=new booksFragment();

            imgGenre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle=new Bundle();
                    bundle.putString("genre",item.getTxt().toString());
                    booksFragment.setArguments(bundle);
                    parentFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,booksFragment).commit();

                }
            });
        }
    }
}
