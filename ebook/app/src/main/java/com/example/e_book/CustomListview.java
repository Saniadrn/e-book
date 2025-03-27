package com.example.e_book;

public class CustomListview {
    private int Image;
    private String txt;

    public CustomListview(int image, String txt) {
        Image = image;
        this.txt = txt;
    }
    public CustomListview() {
    }
    public int getImage() {
        return Image;
    }
    public String getTxt() {
        return txt;
    }
}
