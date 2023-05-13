package com.example.matvinn;

import java.util.Comparator;

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

    public static Comparator<Product> ProductAlphabeticalOrderComparator = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };

    public static Comparator<Product> ProductReverseAlphabeticalOrderComparator = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return p2.getName().compareTo(p1.getName());
        }
    };

    public static Comparator<Product> ProductAscendingOrderComparator = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return p1.getExpiryDate() - p2.getExpiryDate();
        }
    };

    public static Comparator<Product> ProductDescendingOrderComparator = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return p2.getExpiryDate() - p1.getExpiryDate();
        }
    };
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
