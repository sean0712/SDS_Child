package com.teamProject2.sdschild;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayInputStream;

public class MarketEditActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    EditText EditName, EditAmount, EditCount;
    Button BtnEdit, BtnDelete, BtnCancel;
    ImageView ImageViewSnack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_edit);

        BtnEdit = findViewById(R.id.BtnEdit);
        BtnDelete = findViewById(R.id.BtnDelete);
        BtnCancel = findViewById(R.id.BtnCancel);

        EditName = findViewById(R.id.EditName);
        EditAmount = findViewById(R.id.EditAmount);
        EditCount = findViewById(R.id.EditCount);

        ImageViewSnack = findViewById(R.id.ImageViewSnack);

        Intent intent = getIntent();
        Item item = (Item) intent.getSerializableExtra("item");

//        EditDate.setText(revenue.date);
//        EditHistory.setText(revenue.content);
//        EditAmount.setText(revenue.amount);
        EditName.setText(item.name);
        EditAmount.setText(item.amount);
        EditCount.setText(item.count);

        String image = item.poster;
        byte[] b = binaryStringToByteArray(image);
        ByteArrayInputStream is = new ByteArrayInputStream(b);
        Drawable reviewImage = Drawable.createFromStream(is, "reviewImage");
        ImageViewSnack.setImageDrawable(reviewImage);

        BtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                editRevenue(EditDate.getText().toString(),EditHistory.getText().toString(), EditAmount.getText().toString());
                editMarket(item.poster, EditName.getText().toString(), EditAmount.getText().toString(), EditCount.getText().toString());
                MarketEditActivity.super.onRestart();
                finish();
            }
        });

        BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                deleteRevenue(EditDate.getText().toString());
                deleteMarket(EditName.getText().toString());
                MarketEditActivity.super.onRestart();
                finish();
            }
        });
//
        BtnCancel.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

//    public void editWarehouse(String poster, String name, String amount, String count) {
////        Revenue revenue = new Revenue(date, history, amount);
//        Item item = new Item(poster, name, amount, count);
//        databaseReference.child("warehouse").child(name).setValue(item);
//    }

    public void editMarket(String poster, String name, String amount, String count) {
//        Revenue revenue = new Revenue(date, history, amount);
        Item item = new Item(poster, name, amount, count);
        databaseReference.child("market").child(name).setValue(item);
    }
    //
    public void deleteMarket(String name) {
        databaseReference.child("market").child(name).setValue(null);
    }

    public static byte[] binaryStringToByteArray(String s) {
        int count = s.length() / 8;
        byte[] b = new byte[count];
        for (int i = 1; i < count; ++i) {
            String t = s.substring((i - 1) * 8, i * 8);
            b[i - 1] = binaryStringToByte(t);
        }
        return b;
    }

    public static byte binaryStringToByte(String s) {
        byte ret = 0, total = 0;
        for (int i = 0; i < 8; ++i) {
            ret = (s.charAt(7 - i) == '1') ? (byte) (1 << i) : 0;
            total = (byte) (ret | total);
        }
        return total;
    }
}
