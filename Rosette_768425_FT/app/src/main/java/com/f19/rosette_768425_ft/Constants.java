package com.f19.rosette_768425_ft;


import java.util.Random;

public class Constants {
    public final static boolean ENABLE_DEBUG = false;
    public final static int INTENT_REQUEST_CODE_ADD_USER = 1;
    public final static int INTENT_REQUEST_CODE_VERIFY_USER = 2;
    public final static int INTENT_DISPLAY_PERSON_DETAILS_FRAGMENT = 3;

    public final static int ICON_COUNT = 30;
    public final static int TRAFFIC_IMAGES_COUNT = 9;

    public final static int Images[] = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
            R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9};

    public final static int Icons[] = {R.drawable.icon01_01,R.drawable.icon01_02,R.drawable.icon01_03,R.drawable.icon01_04,R.drawable.icon01_05,
            R.drawable.icon01_06, R.drawable.icon01_07, R.drawable.icon01_08, R.drawable.icon01_09, R.drawable.icon01_10,
            R.drawable.icon01_11,R.drawable.icon01_12,R.drawable.icon01_13,R.drawable.icon01_14,R.drawable.icon01_15,
            R.drawable.icon01_16,R.drawable.icon01_17,R.drawable.icon01_18,R.drawable.icon01_19,R.drawable.icon01_20,
            R.drawable.icon01_21,R.drawable.icon01_22,R.drawable.icon01_23,R.drawable.icon01_24,R.drawable.icon01_25,
            R.drawable.icon01_26,R.drawable.icon01_27,R.drawable.icon01_28,R.drawable.icon01_29,R.drawable.icon01_30};

    public final static String INPUT_VERIFIED = "Verified";
    public final static String INPUT_NOT_VERIFIED = "Not Verified";

    public int getRandom(int max) {
        Random randnum = new Random();
        return randnum.nextInt(max-1);
    }

    public static int[] RandomizeArray(int[] array){
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }
        return array;
    }


}

