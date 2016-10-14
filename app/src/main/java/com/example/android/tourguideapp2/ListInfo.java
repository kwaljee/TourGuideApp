package com.example.android.tourguideapp2;


public class ListInfo {

    private String subTitle;
    private String desc;
    private int imageResource;

    public ListInfo(String subtitle, String description, int imageResourceId) {
        subTitle = subtitle;
        desc = description;
        imageResource = imageResourceId;
    }

    public String getSubtitle() {
        return subTitle;
    }

    public String getDescription() {
        return desc;
    }

    public int getImageResourceId() {
        return imageResource;
    }


}
