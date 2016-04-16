package com.poltavets.app.howtodraw.presenter;

import android.graphics.Color;

import me.panavtec.drawableview.DrawableViewConfig;

/**
 * Created by Poltavets on 31.03.2016.
 */
public interface HowToPresenter {
    DrawableViewConfig initDrawConfig();
    void setStrokeWidth(float width);
    void setDrawColor(int colors);
    void undoDraw();
    void setTransparent(boolean paint);
    void clear();
    void showElements();
    void saveImage();
    void changeConfig();
    void destroy();
}
