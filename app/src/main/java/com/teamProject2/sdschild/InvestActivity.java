package com.teamProject2.sdschild;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class InvestActivity extends AppCompatActivity {

    private LineChart chart;
    Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invest);

       chart=findViewById(R.id.linechart);

        ArrayList<Entry> values = new ArrayList<>();

/*        for (int i = 0; i < 10; i++) {

            float val = (float) (Math.random() * 10);
            values.add(new Entry(i, val));
        }*/

        values.add(new Entry(0, 0));
        values.add(new Entry(1, 1));
        values.add(new Entry(2, 2));
        values.add(new Entry(3, 3));
        values.add(new Entry(4, 4));
        values.add(new Entry(5, 5));




        LineDataSet set1;
        set1 = new LineDataSet(values, "DataSet 1");

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1); // add the data sets

        // create a data object with the data sets
        LineData data = new LineData(dataSets);

        // black lines and points
        set1.setColor(Color.BLACK);
        set1.setCircleColor(Color.BLACK);

        // set data
        chart.setData(data);


        //다이얼로그//
        dialog=new Dialog(InvestActivity.this);
        dialog.requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_geolae);

        findViewById(R.id.purchaseBtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showDialog();
            }
        });
    }

    public void showDialog(){
        dialog.show();

        /*이 안에 버튼에대한 기능을 구현하면됨 현재는 종료*/
        dialog.findViewById(R.id.geolaeBtn).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
