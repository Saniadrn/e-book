package com.example.e_book;

public class Book {
    private String title;
    private int img;
    private String pdfUrl;

    public Book(String title, int img,String pdfUrl ) {
        this.pdfUrl = pdfUrl;
        this.img = img;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getImg() {
        return img;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }
}
