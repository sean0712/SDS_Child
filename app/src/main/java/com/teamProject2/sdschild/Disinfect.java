package com.teamProject2.sdschild;

import java.io.Serializable;

public class Disinfect implements Serializable {

    String date; // 날짜
    String disper; // 방역요원명
    boolean sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10,sub11,sub12,sub13,sub14,sub15; // 일단 1개로 시작 후 추후 20명 적용 예정
    boolean ret1,ret2,ret3,ret4,ret5,ret6,ret7,ret8,ret9,ret10,ret11,ret12,ret13,ret14,ret15; // 노가다 귀찮아서 15개로 축소

    public Disinfect(String date, String disper, boolean sub1, boolean sub2, boolean sub3, boolean sub4, boolean sub5, boolean sub6, boolean sub7, boolean sub8, boolean sub9, boolean sub10, boolean sub11, boolean sub12, boolean sub13, boolean sub14, boolean sub15, boolean ret1, boolean ret2, boolean ret3, boolean ret4, boolean ret5, boolean ret6, boolean ret7, boolean ret8, boolean ret9, boolean ret10, boolean ret11, boolean ret12, boolean ret13, boolean ret14, boolean ret15) {
        this.date = date;
        this.disper = disper;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.sub4 = sub4;
        this.sub5 = sub5;
        this.sub6 = sub6;
        this.sub7 = sub7;
        this.sub8 = sub8;
        this.sub9 = sub9;
        this.sub10 = sub10;
        this.sub11 = sub11;
        this.sub12 = sub12;
        this.sub13 = sub13;
        this.sub14 = sub14;
        this.sub15 = sub15;
        this.ret1 = ret1;
        this.ret2 = ret2;
        this.ret3 = ret3;
        this.ret4 = ret4;
        this.ret5 = ret5;
        this.ret6 = ret6;
        this.ret7 = ret7;
        this.ret8 = ret8;
        this.ret9 = ret9;
        this.ret10 = ret10;
        this.ret11 = ret11;
        this.ret12 = ret12;
        this.ret13 = ret13;
        this.ret14 = ret14;
        this.ret15 = ret15;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDisper() {
        return disper;
    }

    public void setDisper(String disper) {
        this.disper = disper;
    }

    public boolean isSub1() {
        return sub1;
    }

    public void setSub1(boolean sub1) {
        this.sub1 = sub1;
    }

    public boolean isSub2() {
        return sub2;
    }

    public void setSub2(boolean sub2) {
        this.sub2 = sub2;
    }

    public boolean isSub3() {
        return sub3;
    }

    public void setSub3(boolean sub3) {
        this.sub3 = sub3;
    }

    public boolean isSub4() {
        return sub4;
    }

    public void setSub4(boolean sub4) {
        this.sub4 = sub4;
    }

    public boolean isSub5() {
        return sub5;
    }

    public void setSub5(boolean sub5) {
        this.sub5 = sub5;
    }

    public boolean isSub6() {
        return sub6;
    }

    public void setSub6(boolean sub6) {
        this.sub6 = sub6;
    }

    public boolean isSub7() {
        return sub7;
    }

    public void setSub7(boolean sub7) {
        this.sub7 = sub7;
    }

    public boolean isSub8() {
        return sub8;
    }

    public void setSub8(boolean sub8) {
        this.sub8 = sub8;
    }

    public boolean isSub9() {
        return sub9;
    }

    public void setSub9(boolean sub9) {
        this.sub9 = sub9;
    }

    public boolean isSub10() {
        return sub10;
    }

    public void setSub10(boolean sub10) {
        this.sub10 = sub10;
    }

    public boolean isSub11() {
        return sub11;
    }

    public void setSub11(boolean sub11) {
        this.sub11 = sub11;
    }

    public boolean isSub12() {
        return sub12;
    }

    public void setSub12(boolean sub12) {
        this.sub12 = sub12;
    }

    public boolean isSub13() {
        return sub13;
    }

    public void setSub13(boolean sub13) {
        this.sub13 = sub13;
    }

    public boolean isSub14() {
        return sub14;
    }

    public void setSub14(boolean sub14) {
        this.sub14 = sub14;
    }

    public boolean isSub15() {
        return sub15;
    }

    public void setSub15(boolean sub15) {
        this.sub15 = sub15;
    }

    public boolean isRet1() {
        return ret1;
    }

    public void setRet1(boolean ret1) {
        this.ret1 = ret1;
    }

    public boolean isRet2() {
        return ret2;
    }

    public void setRet2(boolean ret2) {
        this.ret2 = ret2;
    }

    public boolean isRet3() {
        return ret3;
    }

    public void setRet3(boolean ret3) {
        this.ret3 = ret3;
    }

    public boolean isRet4() {
        return ret4;
    }

    public void setRet4(boolean ret4) {
        this.ret4 = ret4;
    }

    public boolean isRet5() {
        return ret5;
    }

    public void setRet5(boolean ret5) {
        this.ret5 = ret5;
    }

    public boolean isRet6() {
        return ret6;
    }

    public void setRet6(boolean ret6) {
        this.ret6 = ret6;
    }

    public boolean isRet7() {
        return ret7;
    }

    public void setRet7(boolean ret7) {
        this.ret7 = ret7;
    }

    public boolean isRet8() {
        return ret8;
    }

    public void setRet8(boolean ret8) {
        this.ret8 = ret8;
    }

    public boolean isRet9() {
        return ret9;
    }

    public void setRet9(boolean ret9) {
        this.ret9 = ret9;
    }

    public boolean isRet10() {
        return ret10;
    }

    public void setRet10(boolean ret10) {
        this.ret10 = ret10;
    }

    public boolean isRet11() {
        return ret11;
    }

    public void setRet11(boolean ret11) {
        this.ret11 = ret11;
    }

    public boolean isRet12() {
        return ret12;
    }

    public void setRet12(boolean ret12) {
        this.ret12 = ret12;
    }

    public boolean isRet13() {
        return ret13;
    }

    public void setRet13(boolean ret13) {
        this.ret13 = ret13;
    }

    public boolean isRet14() {
        return ret14;
    }

    public void setRet14(boolean ret14) {
        this.ret14 = ret14;
    }

    public boolean isRet15() {
        return ret15;
    }

    public void setRet15(boolean ret15) {
        this.ret15 = ret15;
    }

    public Disinfect() {
    }
}
