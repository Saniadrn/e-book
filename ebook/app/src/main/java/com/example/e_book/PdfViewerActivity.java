package com.example.e_book;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PdfViewerActivity extends AppCompatActivity {
    PDFView pdfView;
    String pdfUrl;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pdf_viewer);

        pdfView = findViewById(R.id.pdfView);
        progressBar=findViewById(R.id.progressBar);// the Image of Loading
        progressBar.setVisibility(View.VISIBLE);
        //progressBar.setVisibility(View.VISIBLE)   --> یعنی نمایش داده شود

        Log.d("PDF_DEBUG","Dpdftask ejra shod");
        //Log.d("PDF_DEBUG","Dpdftask ejra shod")  --> ثبت یک پیغام در Logcat به منظور اشکال زدایی




        pdfUrl = getIntent().getStringExtra("PDF_URL");//گرفتن یک داده جابه جا شده بین اکتیویتی ها از نوع رشته
        Log.d("PDF_URL","link daryaft shod"+pdfUrl);//ثبت یک پیغام در Logcat به منظور اشکال زدایی
        new DownloadPdfTask().execute(pdfUrl);
        //new DownloadPdfTask()  --> مسِئول دانلود فایل پی دی اف از URL
        //.execute(pdfUrl)       --> مسئول ارسال pdfurl به عنوان ارگومان

        //سه خط کد با هم یک جریان کلی زیر را انجام می‌دهند:
        //۱. یک URL برای یک فایل PDF از intent دریافت می‌شود.
        //۲.
        //URL دریافت شده در Logcat ثبت می‌شود تا توسعه‌دهنده بتواند آن را بررسی کند.
        //۳.
        //یک task جداگانه (در یک thread پس‌زمینه) برای دانلود فایل PDF با استفاده از URL دریافت شده، شروع می‌شود.

    }

    private class DownloadPdfTask extends AsyncTask<String, Void, File> {

        @Override
        protected File doInBackground(String... strings) {
            Log.d("PDF_DOWNLOAD","download shoro shod");
            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(strings[0]).build();
                Response response = client.newCall(request).execute();
                if(!response.isSuccessful()){
                    Log.e("PDF_DOWNLOAD","daryaft file"+response.code());
                }
                InputStream inputStream = response.body().byteStream();
                File file = new File(getFilesDir(), "temp.pdf");
                FileOutputStream outputStream = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, length);
                }
                outputStream.close();
                inputStream.close();
                return file;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("PDF_ERROR","khata dar download"+e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(File file) {
            progressBar.setVisibility(View.GONE);
            if(file!=null){
                pdfView.fromFile(file).load();
            }else{
                Toast.makeText(PdfViewerActivity.this,"na movafagh",Toast.LENGTH_LONG).show();
            }
        }
    }
}