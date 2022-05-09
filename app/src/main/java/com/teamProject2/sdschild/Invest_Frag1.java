package com.teamProject2.sdschild;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*

    ★★★    투자현황 화면   ★★★


 */


public class Invest_Frag1 extends Fragment {

    private View view;
    public static Invest_Frag1 newInstance(){
        Invest_Frag1 investfrag1 = new Invest_Frag1();
        return investfrag1;
    }


    /*
            프로그래밍으로 건드려야 할 부분

        ★★★findViewById 바로 못씀 -> 밑에 함수에선 view.findViewById로 해야됨★★★
        ★★★fragment에선 getWindow() 바로 못써서 getActivity().getWindow()로 사용해야됨★★★

    */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_invest__frag1, container, false);
        return view;
    }
}