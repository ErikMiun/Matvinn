package com.example.matvinn;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static List<Product> productList = new ArrayList<Product>();
    private static int nextId = 10;

    public MyApplication() {
        fillProductList();
    }

    private void fillProductList() {
        Product p0 = new Product(0, "Mjök", 1, "https://static.mathem.se/shared/images/products/large/farsk-standardmjolk-3--1-5l-arla-1.jpg");
        Product p1 = new Product(1, "Grädde", 2, "https://static.mathem.se/shared/images/products/large/07311041065013_c1l1.jpg");
        Product p2 = new Product(2, "Ost", 3, "aa");
        Product p3 = new Product(3, "Morot", 4, "a");
        Product p4 = new Product(4, "Skinka", 5, "a");
        Product p5 = new Product(5, "Lax", 6, "https://assets.icanet.se/t_product_large_v1,f_auto/7318690080428.jpg");
        Product p6 = new Product(6, "Köttbullar", 7, "a");
        Product p7 = new Product(7, "Bröd", 8, "https://www.fazer.fi/globalassets/skogaholm/720x720/skogaholmslimpa-720.png");
        Product p8 = new Product(8, "Mjökb", 9, "a");
        Product p9 = new Product(9, "Mjökn", 10, "a");

        productList.addAll(Arrays.asList(new Product[]{p0, p1, p2, p3, p4, p5, p6, p7, p8, p9}));
    }

    public static List<Product> getProductList() {
        return productList;
    }

    public static void setProductList(List<Product> productList) {
        MyApplication.productList = productList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
