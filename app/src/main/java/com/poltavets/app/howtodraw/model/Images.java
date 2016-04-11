package com.poltavets.app.howtodraw.model;

import com.poltavets.app.howtodraw.R;

import java.util.HashMap;
import java.util.Map;


public class Images {
    private static String[]characters=new String[]{
            "Brus",//0
            "Anna"//1
    };
    public static String[] getCharcters(){
        return characters;
    }
    private static int[] previews=new int[]{
            R.drawable.brus_14, //BRUS | 0
            R.drawable.anna_14, //ANNA | 1
    };
    public static Map<String,Object> getPreview(int index){
     Map<String,Object> map=new HashMap<String,Object>();

        switch (index){
            case 0:
                map.put("name",characters[0]);
                map.put("preview",previews[0]);
                map.put("steps",getBrus().length);
            break;
            case 1:
                map.put("name",characters[1]);
                map.put("preview",previews[1]);
                map.put("steps",getAnna().length);
                break;
        }
        return map;
    }
    public static int[] getImageListbyId(int id){
        switch (id){
            case 0:
                return getBrus();
            case 1:
                return getAnna();
        }
        return null;
    }
    public static int[] array_brus={
        R.drawable.brus_1,
                R.drawable.brus_2,
                R.drawable.brus_3,
                R.drawable.brus_4,
                R.drawable.brus_5,
                R.drawable.brus_6,
                R.drawable.brus_7,
                R.drawable.brus_8,
                R.drawable.brus_9,
                R.drawable.brus_10,
                R.drawable.brus_11,
                R.drawable.brus_12,
                R.drawable.brus_13,
                R.drawable.brus_14
    };
    public static int[] getBrus(){
      return  array_brus;
    }
    public static int[] getAnna(){
        return  new int[]{
                R.drawable.anna_1,
                R.drawable.anna_2,
                R.drawable.anna_3,
                R.drawable.anna_4,
                R.drawable.anna_5,
                R.drawable.anna_6,
                R.drawable.anna_7,
                R.drawable.anna_8,
                R.drawable.anna_9,
                R.drawable.anna_10,
                R.drawable.anna_11,
                R.drawable.anna_12,
                R.drawable.anna_13,
                R.drawable.anna_14,
        };
    }
}
