package com.hamza.Wazaker.Activites.CounterActivity.FuncationClasses;

import android.graphics.Color;

import java.util.Random;

public class RandomColor {

    private static final int[] colors = {Color.WHITE, Color.BLACK, Color.YELLOW};

    public static int getRandomColor() {
        Random randomcolor = new Random();
        int color = randomcolor.nextInt(colors.length);
        return colors[color];
    }
}
