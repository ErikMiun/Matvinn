package com.example.matvinn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class Inventory extends AppCompatActivity {

    private static final String TAG = "Products";
    Button btn_addItem;

    List<Product> productList = new ArrayList<Product>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);


        fillProductList();
        Log.d(TAG, "onCreate: " + productList.toString());
        Toast.makeText(this, "Product count = " + productList.size(), Toast.LENGTH_SHORT).show();
        btn_addItem = findViewById(R.id.btn_addItem);

        btn_addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inventory.this, AddEditOne.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.rv_foodList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecycleVievAdapter(productList, this);
        recyclerView.setAdapter(mAdapter);
    }

    private void fillProductList() {
        Product p0 = new Product(0, "Mjök", 1, "https://static.mathem.se/shared/images/products/large/farsk-standardmjolk-3--1-5l-arla-1.jpg");
        Product p1 = new Product(1, "Grädde", 2, "a");
        Product p2 = new Product(2, "Ost", 3, "aa");
        Product p3 = new Product(3, "Morot", 4, "a");
        Product p4 = new Product(4, "Skinka", 5, "a");
        Product p5 = new Product(5, "Lax", 6, "a");
        Product p6 = new Product(6, "Köttbullar", 7, "a");
        Product p7 = new Product(7, "Mjökv", 8, "a");
        Product p8 = new Product(8, "Mjökb", 9, "a");
        Product p9 = new Product(9, "Mjökn", 10, "a");

        productList.addAll(Arrays.asList(new Product[]{p0, p1, p2, p3, p4, p5, p6, p7, p8, p9}));
    }
}