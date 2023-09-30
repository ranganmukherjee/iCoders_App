package com.example.icoders;

public class profileModel {

    private int img;
    private String name, desig;

    public profileModel(int img, String name, String desig)
    {
        this.img=img;
        this.name=name;
        this.desig=desig;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getDesig() {
        return desig;
    }

}
