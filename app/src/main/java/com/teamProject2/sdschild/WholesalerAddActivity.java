package com.teamProject2.sdschild;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class WholesalerAddActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    Button BtnAdd;
    Button BtnCancel;
    ImageView ImageSnack;

    EditText EditName, EditAmount, EditCount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse_add);

        BtnAdd = findViewById(R.id.BtnAdd);
        BtnCancel = findViewById(R.id.BtnCancel);
        EditName = findViewById(R.id.EditName);
        EditAmount = findViewById(R.id.EditAmount);
        EditCount = findViewById(R.id.EditCount);
        ImageSnack = findViewById(R.id.ImageSnack);

        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                addRevenue(EditDate.getText().toString(),EditHistory.getText().toString(), EditAbsoluteAmount.getText().toString());
//                RevenueAddActivity.super.onRestart();
//                finish();

                //
                Drawable image = ImageSnack.getDrawable();
//                ImageSnack.setImageDrawable(image); // OK
                Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 10, stream);
                byte[] reviewImage = stream.toByteArray();

//                Toast.makeText(getApplicationContext(),reviewImage.length+"",Toast.LENGTH_SHORT).show(); // OK

//
                String StringImage = byteArrayToBinaryString(reviewImage);
//                //
//                Toast.makeText(getApplicationContext(),StringImage.length()+"", Toast.LENGTH_SHORT).show(); // OK 1193~

                addItem(StringImage, EditName.getText().toString(), EditAmount.getText().toString(), EditCount.getText().toString());
                WholesalerAddActivity.super.onRestart();
                finish();
            }
        });

        BtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ImageSnack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());

                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();

                    ImageSnack.setImageBitmap(img);
                } catch (Exception e) {

                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            }
        }
    }


//    public void addItem(String date, String history, String amount) {
//        Revenue revenue = new Revenue(date, history, amount);
//        databaseReference.child("revenue").child(date).setValue(revenue);
//    }

    public void addItem(String poster, String name, String amount, String count) {
        Item item = new Item(poster, name, amount, count);
        databaseReference.child("warehouse").child(name).setValue(item);
    }

    public static String byteArrayToBinaryString(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; ++i) {
            sb.append(byteToBinaryString(b[i]));
        }
        return sb.toString();
    }

    public static String byteToBinaryString(byte n) {
        StringBuilder sb = new StringBuilder("00000000");
        for (int bit = 0; bit < 8; bit++) {
            if (((n >> bit) & 1) > 0) {
                sb.setCharAt(7 - bit, '1');
            }
        }
        return sb.toString();
    }
}
