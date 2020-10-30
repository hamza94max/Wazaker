package com.hazem.wazaker.Models;

import androidx.annotation.NonNull;

public class ZekeritemModel implements CharSequence {

    private String zeker ;
    private int counter ;
    private boolean checked;
    private int currentCount = 0;

    public ZekeritemModel(String zeker, int counter) {
        this.zeker = zeker;
        this.counter = counter;
    }


    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public String getZeker() {
        return zeker;
    }

    public void setZeker(String zeker) {
        this.zeker = zeker;
    }

    public int getCounter() {
        return counter;
    }

    public void setCount(int counter) {
        this.counter = counter;
    }


    @Override
    public int length() {
        return 0;
    }


    @Override
    public char charAt(int index) {
        return 0;
    }

    @NonNull
    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

}
