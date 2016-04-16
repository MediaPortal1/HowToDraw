package com.poltavets.app.howtodraw.model;

import com.poltavets.app.howtodraw.R;

import java.util.HashMap;
import java.util.Map;


public class Images {
    private static String[]characters=new String[]{
            "Brus",//0
            "Anna",//1
            "King",//2
            "Julia",//3
            "Asuka",//4
            "Ganryu",//5
            "Jack",//6
            "Christie",//7
            "Lei",//8
            "Lee",//9
            "Steve",//10
            "Feng",//11
            "Hworang",//12
            "Paul",//13
            "Xiaoyu",//14
    };
    public static String[] getCharcters(){
        return characters;
    }
    private static int[] previews=new int[]{
            R.drawable.brus_14, //BRUS | 0
            R.drawable.anna_14, //ANNA | 1
            R.drawable.king_16, //KING | 2
            R.drawable.ulya_14,//ULYA | 3
            R.drawable.asuka_14, //ASUKA | 4
            R.drawable.ganru_16, //GANRYU | 5
            R.drawable.jack_16, //JACK | 6
            R.drawable.kristy_16,//christie | 7
            R.drawable.ley_16,//ley | 8
            R.drawable.lee_17,//lee | 9
            R.drawable.steev_16,//steve | 10
            R.drawable.feng_16,//feng | 11
            R.drawable.hworang_15,//hworang | 12
            R.drawable.pol_14,//pol | 13
            R.drawable.xiaoyu_14,//pol | 14
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
            case 2:
                map.put("name",characters[2]);
                map.put("preview",previews[2]);
                map.put("steps",getKing().length);
                break;
            case 3:
                map.put("name",characters[3]);
                map.put("preview",previews[3]);
                map.put("steps",getUlya().length);
                break;
            case 4:
                map.put("name",characters[4]);
                map.put("preview",previews[4]);
                map.put("steps",getAsuka().length);
                break;
            case 5:
                map.put("name",characters[5]);
                map.put("preview",previews[5]);
                map.put("steps",getGanru().length);
                break;
            case 6:
                map.put("name",characters[6]);
                map.put("preview",previews[6]);
                map.put("steps",getJack().length);
                break;
            case 7:
                map.put("name",characters[7]);
                map.put("preview",previews[7]);
                map.put("steps",getKristy().length);
                break;
            case 8:
                map.put("name",characters[8]);
                map.put("preview",previews[8]);
                map.put("steps",getLei().length);
                break;
            case 9:
                map.put("name",characters[9]);
                map.put("preview",previews[9]);
                map.put("steps",getLee().length);
                break;
            case 10:
                map.put("name",characters[10]);
                map.put("preview",previews[10]);
                map.put("steps",getSteev().length);
                break;
            case 11:
                map.put("name",characters[11]);
                map.put("preview",previews[11]);
                map.put("steps",getFeng().length);
                break;
            case 12:
                map.put("name",characters[12]);
                map.put("preview",previews[12]);
                map.put("steps",getHworang().length);
                break;
            case 13:
                map.put("name",characters[13]);
                map.put("preview",previews[13]);
                map.put("steps",getPol().length);
                break;
            case 14:
                map.put("name",characters[14]);
                map.put("preview",previews[14]);
                map.put("steps",getXiaoyu().length);
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
            case 2:
                return getKing();
            case 3:
                return getUlya();
            case 4:
                return getAsuka();
            case 5:
                return getGanru();
            case 6:
                return getJack();
            case 7:
                return getKristy();
            case 8:
                return getLei();
            case 9:
                return getLee();
            case 10:
                return getSteev();
            case 11:
                return getFeng();
            case 12:
                return getHworang();
            case 13:
                return getPol();
            case 14:
                return getXiaoyu();
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
    public static int[] array_anna={
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
    public static int[] getAnna(){
        return  array_anna;
    }
    public static int[] array_king={
            R.drawable.king_1,
            R.drawable.king_2,
            R.drawable.king_3,
            R.drawable.king_4,
            R.drawable.king_5,
            R.drawable.king_6,
            R.drawable.king_7,
            R.drawable.king_8,
            R.drawable.king_9,
            R.drawable.king_10,
            R.drawable.king_11,
            R.drawable.king_12,
            R.drawable.king_13,
            R.drawable.king_14,
            R.drawable.king_15,
            R.drawable.king_16,
    };
    public static int[] getKing(){
        return  array_king;
    }
    public static int[] array_asuka={
            R.drawable.asuka_1,
            R.drawable.asuka_2,
            R.drawable.asuka_3,
            R.drawable.asuka_4,
            R.drawable.asuka_5,
            R.drawable.asuka_6,
            R.drawable.asuka_7,
            R.drawable.asuka_8,
            R.drawable.asuka_9,
            R.drawable.asuka_10,
            R.drawable.asuka_11,
            R.drawable.asuka_12,
            R.drawable.asuka_13,
            R.drawable.asuka_14,
    };
    public static int[] getAsuka(){
        return  array_asuka;
    }
    public static int[] array_ulya={
            R.drawable.ulya_1,
            R.drawable.ulya_2,
            R.drawable.ulya_3,
            R.drawable.ulya_4,
            R.drawable.ulya_5,
            R.drawable.ulya_6,
            R.drawable.ulya_7,
            R.drawable.ulya_8,
            R.drawable.ulya_9,
            R.drawable.ulya_10,
            R.drawable.ulya_11,
            R.drawable.ulya_12,
            R.drawable.ulya_13,
            R.drawable.ulya_14,
    };
    public static int[] getUlya(){
        return  array_ulya;
    }

    public static int[] array_ganru={
            R.drawable.ganru_1,
            R.drawable.ganru_2,
            R.drawable.ganru_3,
            R.drawable.ganru_4,
            R.drawable.ganru_5,
            R.drawable.ganru_6,
            R.drawable.ganru_7,
            R.drawable.ganru_8,
            R.drawable.ganru_9,
            R.drawable.ganru_10,
            R.drawable.ganru_11,
            R.drawable.ganru_12,
            R.drawable.ganru_13,
            R.drawable.ganru_14,
            R.drawable.ganru_15,
            R.drawable.ganru_16,
    };
    public static int[] getGanru(){
        return  array_ganru;
    }

    public static int[] array_jack={
            R.drawable.jack_1,
            R.drawable.jack_2,
            R.drawable.jack_3,
            R.drawable.jack_4,
            R.drawable.jack_5,
            R.drawable.jack_6,
            R.drawable.jack_7,
            R.drawable.jack_8,
            R.drawable.jack_9,
            R.drawable.jack_10,
            R.drawable.jack_11,
            R.drawable.jack_12,
            R.drawable.jack_13,
            R.drawable.jack_14,
            R.drawable.jack_15,
            R.drawable.jack_16,
    };
    public static int[] getJack(){
        return  array_jack;
    }

    public static int[] array_kristy={
            R.drawable.kristy_1,
            R.drawable.kristy_2,
            R.drawable.kristy_3,
            R.drawable.kristy_4,
            R.drawable.kristy_5,
            R.drawable.kristy_6,
            R.drawable.kristy_7,
            R.drawable.kristy_8,
            R.drawable.kristy_9,
            R.drawable.kristy_10,
            R.drawable.kristy_11,
            R.drawable.kristy_12,
            R.drawable.kristy_13,
            R.drawable.kristy_14,
            R.drawable.kristy_15,
            R.drawable.kristy_16,
    };
    public static int[] getKristy(){
        return  array_kristy;
    }
    public static int[] array_ley={
            R.drawable.ley_1,
            R.drawable.ley_2,
            R.drawable.ley_3,
            R.drawable.ley_4,
            R.drawable.ley_5,
            R.drawable.ley_6,
            R.drawable.ley_7,
            R.drawable.ley_8,
            R.drawable.ley_9,
            R.drawable.ley_10,
            R.drawable.ley_11,
            R.drawable.ley_12,
            R.drawable.ley_13,
            R.drawable.ley_14,
            R.drawable.ley_15,
            R.drawable.ley_16,
    };
    public static int[] getLei(){
        return  array_ley;
    }
    public static int[] array_lee={
            R.drawable.lee_1,
            R.drawable.lee_2,
            R.drawable.lee_3,
            R.drawable.lee_4,
            R.drawable.lee_5,
            R.drawable.lee_6,
            R.drawable.lee_7,
            R.drawable.lee_8,
            R.drawable.lee_9,
            R.drawable.lee_10,
            R.drawable.lee_11,
            R.drawable.lee_12,
            R.drawable.lee_13,
            R.drawable.lee_14,
            R.drawable.lee_15,
            R.drawable.lee_16,
            R.drawable.lee_17,
    };
    public static int[] getLee(){
        return  array_lee;
    }
    public static int[] array_steev={
            R.drawable.steev_1,
            R.drawable.steev_2,
            R.drawable.steev_3,
            R.drawable.steev_4,
            R.drawable.steev_5,
            R.drawable.steev_6,
            R.drawable.steev_7,
            R.drawable.steev_8,
            R.drawable.steev_9,
            R.drawable.steev_10,
            R.drawable.steev_11,
            R.drawable.steev_12,
            R.drawable.steev_13,
            R.drawable.steev_14,
            R.drawable.steev_15,
            R.drawable.steev_16,
    };
    public static int[] getSteev(){
        return  array_steev;
    }
    public static int[] array_feng={
            R.drawable.feng_1,
            R.drawable.feng_2,
            R.drawable.feng_3,
            R.drawable.feng_4,
            R.drawable.feng_5,
            R.drawable.feng_6,
            R.drawable.feng_7,
            R.drawable.feng_8,
            R.drawable.feng_9,
            R.drawable.feng_10,
            R.drawable.feng_11,
            R.drawable.feng_12,
            R.drawable.feng_13,
            R.drawable.feng_14,
            R.drawable.feng_15,
            R.drawable.feng_16,
    };
    public static int[] getFeng(){
        return  array_feng;
    }
    public static int[] array_hworang={
            R.drawable.hworang_1,
            R.drawable.hworang_2,
            R.drawable.hworang_3,
            R.drawable.hworang_4,
            R.drawable.hworang_5,
            R.drawable.hworang_6,
            R.drawable.hworang_7,
            R.drawable.hworang_8,
            R.drawable.hworang_9,
            R.drawable.hworang_10,
            R.drawable.hworang_11,
            R.drawable.hworang_12,
            R.drawable.hworang_13,
            R.drawable.hworang_14,
            R.drawable.hworang_15,
    };
    public static int[] getHworang(){
        return  array_hworang;
    }

    public static int[] array_pol={
            R.drawable.pol_1,
            R.drawable.pol_2,
            R.drawable.pol_3,
            R.drawable.pol_4,
            R.drawable.pol_5,
            R.drawable.pol_6,
            R.drawable.pol_7,
            R.drawable.pol_8,
            R.drawable.pol_9,
            R.drawable.pol_10,
            R.drawable.pol_11,
            R.drawable.pol_12,
            R.drawable.pol_13,
            R.drawable.pol_14,
    };
    public static int[] getPol(){
        return  array_pol;
    }
    public static int[] array_xiaoyu={
            R.drawable.xiaoyu_1,
            R.drawable.xiaoyu_2,
            R.drawable.xiaoyu_3,
            R.drawable.xiaoyu_4,
            R.drawable.xiaoyu_5,
            R.drawable.xiaoyu_6,
            R.drawable.xiaoyu_7,
            R.drawable.xiaoyu_8,
            R.drawable.xiaoyu_9,
            R.drawable.xiaoyu_10,
            R.drawable.xiaoyu_11,
            R.drawable.xiaoyu_12,
            R.drawable.xiaoyu_13,
            R.drawable.xiaoyu_14,
    };
    public static int[] getXiaoyu(){
        return  array_xiaoyu;
    }

}
