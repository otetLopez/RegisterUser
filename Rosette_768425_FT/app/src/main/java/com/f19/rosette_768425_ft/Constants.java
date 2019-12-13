package com.f19.rosette_768425_ft;


import java.util.Random;

public class Constants {
    public final static boolean ENABLE_DEBUG = true;
    public final static int INTENT_REQUEST_CODE_ADD_USER = 1;

    public final static int Icons[] = {R.drawable.icon01_01,R.drawable.icon01_02,R.drawable.icon01_03,R.drawable.icon01_04,R.drawable.icon01_05,
            R.drawable.icon01_06, R.drawable.icon01_07, R.drawable.icon01_08, R.drawable.icon01_09, R.drawable.icon01_10,
            R.drawable.icon01_11,R.drawable.icon01_12,R.drawable.icon01_13,R.drawable.icon01_14,R.drawable.icon01_15,
            R.drawable.icon01_16,R.drawable.icon01_17,R.drawable.icon01_18,R.drawable.icon01_19,R.drawable.icon01_20,
            R.drawable.icon01_21,R.drawable.icon01_22,R.drawable.icon01_23,R.drawable.icon01_24,R.drawable.icon01_25,
            R.drawable.icon01_26,R.drawable.icon01_27,R.drawable.icon01_28,R.drawable.icon01_29,R.drawable.icon01_30};

    public int getRandom() {
        Random randnum = new Random();
        return randnum.nextInt(Icons.length);
    }


}

