package com.hazem.wazaker.FuncationClasses;

import java.util.Random;

public class RandomColor {


    public static int getRandomColor(int[] colors) {
        Random randomcolor = new Random();
        int color = randomcolor.nextInt(colors.length);
        return colors[color];
    }


}
