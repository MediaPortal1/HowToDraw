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
            R.drawable.brus14, //BRUS | 0
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
            R.drawable.brus14,
            R.drawable.brus1,
            R.drawable.brus2,
            R.drawable.brus3,
            R.drawable.brus4,
            R.drawable.brus5,
            R.drawable.brus6,
            R.drawable.brus7,
            R.drawable.brus8,
            R.drawable.brus9,
            R.drawable.brus10,
            R.drawable.brus11,
            R.drawable.brus12,
            R.drawable.brus13,
            R.drawable.brus14,
              };
    };
}
