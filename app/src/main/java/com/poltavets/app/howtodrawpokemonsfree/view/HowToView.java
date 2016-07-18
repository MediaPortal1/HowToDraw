package com.poltavets.app.howtodrawpokemonsfree.view;

import me.panavtec.drawableview.DrawableViewConfig;

/**
 * Created by Poltavets on 31.03.2016.
 */
public interface HowToView {
    void changeDrawConfig(DrawableViewConfig config);
    void changeFABBackgroundStatus(int status);
    void changeFABGridStatus(int status);
    void changeImageSrc(int image,int count,int position,String name);
    void showNavButtons();
    void clearDialog();
}
