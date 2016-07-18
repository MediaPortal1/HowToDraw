package com.poltavets.app.howtodrawpokemonsfree.model;

import com.poltavets.app.howtodraw.R;

import java.util.HashMap;
import java.util.Map;


public class Images {
    private static String[]characters=new String[]{
            "Amaura",//0
            "Pikachu",//1
            "Celebi",//2
            "Groudon",//3
            "Grubbin",//4
            "Hoopa",//5
            "Latios",//6
            "Banette",//7
            "Pokeball",//8
            "Skyser",//9
    };
    public static String[] getCharcters(){
        return characters;
    }
    private static int[] previews=new int[]{
            R.drawable.amaura_9, //AMAURA | 0
            R.drawable.picachu_8, //PIKACHU | 1
            R.drawable.celebi_7, //CELEBI | 2
            R.drawable.groudon_9, //GROUDON | 3
            R.drawable.grubbin_7, //GRUBIN | 4
            R.drawable.hoopa_11, //HOOPA | 5
            R.drawable.latios_10, //LATIOS | 6
            R.drawable.banette_12, //BANETTE | 7
            R.drawable.pokeball_7, //POKEBALL | 8
            R.drawable.skyser_8, //POKEBALL | 9

    };
    public static Map<String,Object> getPreview(int index){
     Map<String,Object> map=new HashMap<String,Object>();

        switch (index){
            case 0:
                map.put("name",characters[0]);
                map.put("preview",previews[0]);
                map.put("steps",getAmaura().length);
            break;
            case 1:
                map.put("name",characters[1]);
                map.put("preview",previews[1]);
                map.put("steps",getPikachu().length);
            break;
            case 2:
                map.put("name",characters[2]);
                map.put("preview",previews[2]);
                map.put("steps",getCelebi().length);
            break;
            case 3:
                map.put("name",characters[3]);
                map.put("preview",previews[3]);
                map.put("steps",getGroudon().length);
            break;
            case 4:
                map.put("name",characters[4]);
                map.put("preview",previews[4]);
                map.put("steps",getGrubbin().length);
            break;
            case 5:
                map.put("name",characters[5]);
                map.put("preview",previews[5]);
                map.put("steps",getHoopa().length);
            break;
            case 6:
                map.put("name",characters[6]);
                map.put("preview",previews[6]);
                map.put("steps",getLatios().length);
            break;
            case 7:
                map.put("name",characters[7]);
                map.put("preview",previews[7]);
                map.put("steps",getBanette().length);
            break;
            case 8:
                map.put("name",characters[8]);
                map.put("preview",previews[8]);
                map.put("steps",getPokeball().length);
            break;
            case 9:
                map.put("name",characters[9]);
                map.put("preview",previews[9]);
                map.put("steps",getSkyser().length);
            break;
        }
        return map;
    }
    public static int[] getImageListbyId(int id){
        switch (id){
            case 0:
                return getAmaura();
            case 1:
                return getPikachu();
            case 2:
                return getCelebi();
            case 3:
                return getGroudon();
            case 4:
                return getGrubbin();
            case 5:
                return getHoopa();
            case 6:
                return getLatios();
            case 7:
                return getBanette();
            case 8:
                return getPokeball();
            case 9:
                return getSkyser();

        }
        return null;
    }
    public static int[] array_amaura={
                R.drawable.amaura_1,
                R.drawable.amaura_2,
                R.drawable.amaura_3,
                R.drawable.amaura_4,
                R.drawable.amaura_5,
                R.drawable.amaura_6,
                R.drawable.amaura_7,
                R.drawable.amaura_8,
                R.drawable.amaura_9,
    };
    public static int[] getAmaura(){
      return  array_amaura;
    }

    public static int[] array_pikachu={
                R.drawable.picachu_1,
                R.drawable.picachu_2,
                R.drawable.picachu_3,
                R.drawable.picachu_4,
                R.drawable.picachu_5,
                R.drawable.picachu_6,
                R.drawable.picachu_7,
                R.drawable.picachu_8,
    };
    public static int[] getPikachu(){
      return  array_pikachu;
    }
    public static int[] array_celebi={
                R.drawable.celebi_1,
                R.drawable.celebi_2,
                R.drawable.celebi_3,
                R.drawable.celebi_4,
                R.drawable.celebi_5,
                R.drawable.celebi_6,
                R.drawable.celebi_7,
    };
    public static int[] getCelebi(){
      return  array_celebi;
    }
    public static int[] array_groudon={
                R.drawable.groudon_1,
                R.drawable.groudon_2,
                R.drawable.groudon_3,
                R.drawable.groudon_4,
                R.drawable.groudon_5,
                R.drawable.groudon_6,
                R.drawable.groudon_7,
                R.drawable.groudon_8,
                R.drawable.groudon_9,
    };
    public static int[] getGroudon(){
      return  array_groudon;
    }
    public static int[] array_grubbin={
                R.drawable.grubbin_1,
                R.drawable.grubbin_2,
                R.drawable.grubbin_3,
                R.drawable.grubbin_4,
                R.drawable.grubbin_5,
                R.drawable.grubbin_6,
                R.drawable.grubbin_7,
    };
    public static int[] getGrubbin(){
      return  array_grubbin;
    }
    public static int[] array_hoopa={
                R.drawable.hoopa_1,
                R.drawable.hoopa_2,
                R.drawable.hoopa_3,
                R.drawable.hoopa_4,
                R.drawable.hoopa_5,
                R.drawable.hoopa_6,
                R.drawable.hoopa_7,
                R.drawable.hoopa_8,
                R.drawable.hoopa_9,
                R.drawable.hoopa_10,
                R.drawable.hoopa_11,
    };
    public static int[] getHoopa(){
      return  array_hoopa;
    }
    public static int[] array_latios={
                R.drawable.latios_1,
                R.drawable.latios_2,
                R.drawable.latios_3,
                R.drawable.latios_4,
                R.drawable.latios_5,
                R.drawable.latios_6,
                R.drawable.latios_7,
                R.drawable.latios_8,
                R.drawable.latios_9,
                R.drawable.latios_10,
    };
    public static int[] getLatios(){
      return  array_latios;
    }
    public static int[] array_banette={
                R.drawable.banette_1,
                R.drawable.banette_2,
                R.drawable.banette_3,
                R.drawable.banette_4,
                R.drawable.banette_5,
                R.drawable.banette_6,
                R.drawable.banette_7,
                R.drawable.banette_8,
                R.drawable.banette_9,
                R.drawable.banette_10,
                R.drawable.banette_11,
                R.drawable.banette_12,
    };
    public static int[] getBanette(){
      return  array_banette;
    }
    public static int[] array_pokeball={
                R.drawable.pokeball_1,
                R.drawable.pokeball_2,
                R.drawable.pokeball_3,
                R.drawable.pokeball_4,
                R.drawable.pokeball_5,
                R.drawable.pokeball_6,
                R.drawable.pokeball_7,
    };
    public static int[] getPokeball(){
      return  array_pokeball;
    }
    public static int[] array_skyser={
                R.drawable.skyser_1,
                R.drawable.skyser_2,
                R.drawable.skyser_3,
                R.drawable.skyser_4,
                R.drawable.skyser_5,
                R.drawable.skyser_6,
                R.drawable.skyser_7,
                R.drawable.skyser_8,
    };
    public static int[] getSkyser(){
      return  array_skyser;
    }

}
