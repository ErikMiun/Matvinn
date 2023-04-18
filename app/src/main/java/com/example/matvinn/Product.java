package com.example.matvinn;

public class Product {
    private int id;
    private String name;
    private int expiryDate;
    private String imgURL;

    public Product(int id, String name, int expiryDate, String imgURL) {
        this.id = id;
        this.name = name;
        this.expiryDate = expiryDate;
        this.imgURL = imgURL;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expiryDate=" + expiryDate +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(int expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
