package com.poltavets.app.howtodraw.view.fragments;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.poltavets.app.howtodraw.R;
import com.poltavets.app.howtodraw.presenter.HowToPresenter;
import com.poltavets.app.howtodraw.view.PaletteBar;

/**
 * Created by Poltavets on 31.03.2016.
 */
public class DrawColorDialog extends DialogFragment {
    private HowToPresenter presenter;
    private  PaletteBar paletteBar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.CustomDialog);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.draw_color_dialog,null);
        view.setBackgroundColor(Color.DKGRAY);
        paletteBar=(PaletteBar)view.findViewById(R.id.draw_palette);
        return view;
    }
    public void setPresenter(HowToPresenter howToPresenter){
        presenter=howToPresenter;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        presenter.setDrawColor(paletteBar.getColor());
        presenter.changeConfig();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.setDrawColor(paletteBar.getColor());
        presenter.changeConfig();


    }
}
