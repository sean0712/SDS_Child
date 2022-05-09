package com.teamProject2.sdschild;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Invest_Frag0#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Invest_Frag0 extends Fragment {

    private View view;
    private LineChart chart;
    Dialog dialog;
    Context mContext;

    public static Invest_Frag0 newInstance(){
        Invest_Frag0 investfrag0 = new Invest_Frag0();
        return investfrag0;
    }

    /*
        ★★★    투자하기 화면   ★★★

    ★★★findViewById 바로 못씀 -> 밑에 함수에선 view.findViewById로 해야됨★★★
    ★★★fragment에선 getWindow() 바로 못써서 getActivity().getWindow()로 사용해야됨★★★


    */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_invest__frag0, container, false);
        chart= view.findViewById(R.id.linechart);

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

        mContext= container.getContext();
        //다이얼로그//
        dialog=new Dialog(mContext);
        dialog.requestWindowFeature(getActivity().getWindow().FEATURE_NO_TITLE);//fragment에선 getWindow바로 못써서 getActivity사용해야됨
        dialog.setContentView(R.layout.dialog_geolae);

        view.findViewById(R.id.purchaseBtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showDialog();
            }
        });
        return view;
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