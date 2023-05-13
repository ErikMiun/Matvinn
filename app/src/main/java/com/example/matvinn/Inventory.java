package com.example.matvinn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class Inventory extends AppCompatActivity {

    private static final String TAG = "Products";
    Button btn_addItem;
    Menu menu;

    MyApplication myApplication = (MyApplication) this.getApplication();
    List<Product> productList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        productList = myApplication.getProductList();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_alphabetical_order:
                Collections.sort(productList, Product.ProductAlphabeticalOrderComparator);
                mAdapter.notifyDataSetChanged();
                return true;
            case R.id.menu_alphabetical_order_reverse:
                Collections.sort(productList, Product.ProductReverseAlphabeticalOrderComparator);
                mAdapter.notifyDataSetChanged();
                return true;
            case R.id.menu_ascend:
                Collections.sort(productList, Product.ProductAscendingOrderComparator);
                mAdapter.notifyDataSetChanged();
                return true;
            case R.id.menu_descend:
                Collections.sort(productList, Product.ProductDescendingOrderComparator);
                mAdapter.notifyDataSetChanged();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}