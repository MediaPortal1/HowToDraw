package com.poltavets.app.howtodrawpokemonsfree.view.fragments;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.poltavets.app.howtodraw.R;
import com.poltavets.app.howtodrawpokemonsfree.presenter.HowToPresenter;

/**
 * Created by Poltavets on 30.03.2016.
 */
public class DrawSizeDialog extends DialogFragment {
    private int progress;
    private HowToPresenter howToPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.draw_size_dialog,null);
        view.setBackgroundColor(Color.DKGRAY);
        SeekBar seekBar=(SeekBar)view.findViewById(R.id.draw_size_seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            howToPresenter.setStrokeWidth((float)progress);
                howToPresenter.changeConfig();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setProgress(progress);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.CustomDialog);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }
    public void setPresenter(HowToPresenter presenter){
        howToPresenter=presenter;
    }
    public void setProgress(float progress){
    this.progress=(int)progress;
    }
}
