package com.poltavets.app.howtodraw.model;

import com.poltavets.app.howtodraw.R;

import java.util.HashMap;
import java.util.Map;


public class Images {
    private static String[]characters=new String[]{
            "Brus" //0
    };
    public static String[] getCharcters(){
        return characters;
    }
    private static int[] previews=new int[]{
            R.drawable.brus_14, //BRUS | 0
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
                break;
        }
        return map;
    }
    public static int[] getImageListbyId(int id){
        switch (id){
            case 0:
                return getBrus();
        }
        return null;
    }
    public static int[] getBrus(){
      return  new int[]{
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
            R.drawable.brus_14,
              };
    };
}
