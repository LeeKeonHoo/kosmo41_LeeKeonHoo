package com.study.android.test2;

public class SingerItem {

    private String name;
    private String age;
    private String mobile;
    private int star;
    private int image;

    public SingerItem(String name, String age, String mobile,int star) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.star = star;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
