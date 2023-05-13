package com.example.matvinn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class AddEditOne extends AppCompatActivity {

    Button btn_confirm, btn_cancel;
    List<Product> productList;
    EditText et_expirydate, et_img, et_productName;
    TextView tv_productId;
    int id;
    MyApplication myApplication = (MyApplication) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);

        productList = myApplication.getProductList();

        btn_confirm = findViewById(R.id.btn_confirm);
        btn_cancel = findViewById(R.id.btn_cancel);
        et_expirydate = findViewById(R.id.et_expiryDate);
        et_img = findViewById(R.id.et_img);
        et_productName = findViewById(R.id.et_productName);
        tv_productId = findViewById(R.id.tv_foodIdNumber);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        Product product = null;

        if (id>=0){
            for (Product p: productList) {
                if(p.getId() == id) {
                    product = p;
                }
            }
            et_productName.setText(product.getName());
            et_expirydate.setText(String.valueOf(product.getExpiryDate()));
            et_img.setText(product.getImgURL());
            tv_productId.setText(String.valueOf(id));
        }
        else {

        }

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id >= 0) {
                    Product updatedProduct = new Product(id, et_productName.getText().toString(), Integer.parseInt(et_expirydate.getText().toString()), et_img.getText().toString());
                    productList.set(id, updatedProduct);
                }
                else {
                    int nextId = myApplication.getNextId();
                    Product newProduct = new Product(nextId, et_productName.getText().toString(), Integer.parseInt(et_expirydate.getText().toString()), et_img.getText().toString());

                    productList.add(newProduct);
                    myApplication.setNextId(nextId++);
                }



                Intent intent = new Intent(AddEditOne.this, Inventory.class);
                startActivity(intent);
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEditOne.this, Inventory.class);
                startActivity(intent);
            }
        });
    }
}