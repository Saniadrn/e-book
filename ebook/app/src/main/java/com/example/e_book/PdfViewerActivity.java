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
        //.execute(pdfUrl)       --> عملیات دانلود PDF در پس‌زمینه اجرا شود.

        //سه خط کد با هم یک جریان کلی زیر را انجام می‌دهند:
        //۱. یک URL برای یک فایل PDF از intent دریافت می‌شود.
        //۲.
        //URL دریافت شده در Logcat ثبت می‌شود تا توسعه‌دهنده بتواند آن را بررسی کند.
        //۳.
        //یک task جداگانه (در یک thread پس‌زمینه) برای دانلود فایل PDF با استفاده از URL دریافت شده، شروع می‌شود.

    }

    private class DownloadPdfTask extends AsyncTask<String, Void, File> {
//       AsyncTask    --> این کلاس مسئول دانلود فایل PDF در یک ترد پس‌زمینه است تا رابط کاربری بلاک نشود.

        @Override
        protected File doInBackground(String... strings) {
//            تد اصلی که در ترد پس‌زمینه اجرا می‌شود
            Log.d("PDF_DOWNLOAD","download shoro shod");
            try {
//                کتابخانه OkHttp برای درخواست‌های شبکه‌ای
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(strings[0]).build();
//                اینجا strings[0] همون pdfUrl است
//                Request.Builder --> ریکوست درست میکند
                Response response = client.newCall(request).execute();
//               درخواست را ارسال می‌کنه و پاسخ سرور در شی Response قرار می‌گیرد
                if(!response.isSuccessful()){
                    Log.e("PDF_DOWNLOAD","daryaft file"+response.code());
                }
                InputStream inputStream = response.body().byteStream();
//                از بدنه پاسخ (response.body()) استریم می‌گیرد (byteStream()). این استریم داده‌های PDF را برمی‌گرداند.
//                استریم می‌گیرد» یعنی که به جای اینکه کل فایل را یک‌باره در حافظه بگیریم
//                می‌تونیم مرحله به مرحله و به‌صورت جریان داده و داده را بایت به بایت یا در بافرهای کوچک از سرور بخوانیم
                File file = new File(getFilesDir(), "temp.pdf");
//             ساخت   فایلی به نام temp.pdf در مسیر داخلی برنامه پوشه getFilesDi
                FileOutputStream outputStream = new FileOutputStream(file);
//                یک FileOutputStream برای نوشتن بایت‌ها در فایل باز می‌کنیم.
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, length);
                }
//                ه کمک inputStream.read(buffer), داده‌ها را از پاسخ شبکه می‌خوانیم و تا زمانی که مقدار بازگشتی
//                از متد read منفی نباشد ( -1 به معنی انتهای فایل است)، آن را در outputStream می‌نویسیم.

//                در اصل این حلقه کل PDF را از سرور می‌گیرد و به فایل temp.pdf در حافظه داخلی منتقل می‌کند.
                outputStream.close();
                inputStream.close();
//                استریم‌ها را می‌بندیم تا منابع آزاد شوند.
                return file;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("PDF_ERROR","khata dar download"+e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(File file) {
//            ین متد روی ترد اصلی (UI thread) صدا زده می‌شود
            progressBar.setVisibility(View.GONE);
            if(file!=null){
                pdfView.fromFile(file).load();
            }else{
                Toast.makeText(PdfViewerActivity.this,"na movafagh",Toast.LENGTH_LONG).show();
            }
        }
    }
}