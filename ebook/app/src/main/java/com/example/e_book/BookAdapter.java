package com.example.e_book;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>{
    Context context;
    int resource;
    ArrayList<Book> booklist;
    public BookAdapter(Context context, int resource, ArrayList<Book> booklist){
        this.context=context;
        this.resource=resource;
        this.booklist=booklist;//constructor
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        //getSystemService(context.LAYOUT_INFLATER_SERVICE)  --> دریافت می کند context.LAYOUT_INFLATER_SERVICE  را با استفاده از LayoutInflaterیک شی از

        View convertView=inflater.inflate(resource,parent,false);
        ViewHolder holder=new ViewHolder(convertView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Book book=booklist.get(position);
        viewHolder.fillItem(book);
        viewHolder.btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf(book.getPdfUrl());

            }
        });

    }
    private void openPdf(String url) {
        Intent intent=new Intent(context, PdfViewerActivity.class);
        intent.putExtra("PDF_URL",url);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return booklist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtBook;
        ImageView imgBook;
        Button btnBook;

        public ViewHolder( View convertView) {
            super(convertView);
            txtBook=(TextView)convertView.findViewById(R.id.txtBook);
            imgBook=(ImageView) convertView.findViewById(R.id.imgBook);
            btnBook=(Button) convertView.findViewById(R.id.btnBook);
        }
        public void fillItem(Book book){
            txtBook.setText(book.getTitle().toString());
            imgBook.setImageResource(book.getImg());
        }





    }
}
