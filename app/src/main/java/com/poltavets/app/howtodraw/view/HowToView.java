package com.poltavets.app.howtodraw.view;

import me.panavtec.drawableview.DrawableViewConfig;

/**
 * Created by Poltavets on 31.03.2016.
 */
public interface HowToView {
    void changeDrawConfig(DrawableViewConfig config);
    void changeFABStatus(int status);
    void changeImageSrc(int image,int count,int position,String name);
    void showNavButtons();
}
