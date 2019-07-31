package com.example.demo.proxy;

public class Person implements PersonBean {

    private String name;
    private String sex;
    int rating;
    int ratongCount;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {

        this.name=name;
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public void setSex(String sex) {

        this.sex=sex;
    }

    @Override
    public int getHotOrNortRating() {
        if (ratongCount == 0) return 0;
        return (rating/ratongCount);
    }

    @Override
    public void setHotOrNortRating(int rating) {

        this.rating=rating;
    }
}
