package com.study.android.telephoneyex;

import android.graphics.Bitmap;

public class AddressItem {

    private String name;
    private String Telnum;
    private Bitmap photo;

    public AddressItem(String name, String Telum, Bitmap photo) {
        this.name = name;
        this.Telnum = Telum;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelnum() {
        return Telnum;
    }

    public void setTelnum(String telnum) {
        Telnum = telnum;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }
}
