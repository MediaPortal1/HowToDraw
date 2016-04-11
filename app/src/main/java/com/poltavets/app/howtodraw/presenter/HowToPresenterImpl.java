package com.poltavets.app.howtodraw.presenter;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.View;

import com.poltavets.app.howtodraw.R;
import com.poltavets.app.howtodraw.model.Images;
import com.poltavets.app.howtodraw.view.HowToView;
import com.poltavets.app.howtodraw.view.fragments.DrawColorDialog;
import com.poltavets.app.howtodraw.view.fragments.DrawSizeDialog;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class HowToPresenterImpl implements HowToPresenter,View.OnClickListener,View.OnLongClickListener{

    public final static int AB=1;
    public final static int A=2;
    public final static int B=3;

    private int count;
    private int position;
    private int numberofimage;
    private String name;
    private int bgstatus;
    private int gridstatus;
    private float stroke;
    private int color;
    private int cashcolor;
    private boolean paint;
    private DrawableViewConfig config;
    private DrawableView drawableView;
    private DisplayMetrics displayMetrics;
    private HowToView howToView;
    private FragmentManager fm;
    public HowToPresenterImpl(DrawableView drawableView,DisplayMetrics displayMetrics,HowToView howToView,FragmentManager fm,int position,int imagenumber) {
        this.howToView=howToView;
        this.stroke = 1.0f;
        this.color = Color.BLACK;
        this.cashcolor=Color.BLACK;
        this.paint = true;
        this.drawableView=drawableView;
        this.fm=fm;
        this.bgstatus =AB;
        this.position=position;
        this.count=Images.getImageListbyId(position).length;
        this.name= Images.getCharcters()[position];
        this.numberofimage=imagenumber;
        this.gridstatus=A;
        config=new DrawableViewConfig();
        this.displayMetrics=displayMetrics;
        changeConfig();
        howToView.changeImageSrc(Images.getImageListbyId(position)[numberofimage],count,numberofimage,Images.getCharcters()[position]);
    }

    @Override
    public void changeConfig() {
    howToView.changeDrawConfig(initDrawConfig());
    }

    @Override
    public DrawableViewConfig initDrawConfig() {
        config.setStrokeColor(color);
        config.setShowCanvasBounds(true); // If the view is bigger than canvas, with this the user will see the bounds (Recommended)
        config.setStrokeWidth(stroke);
        config.setMinZoom(1.0f);
        config.setMaxZoom(1.0f);
        config.setCanvasWidth(displayMetrics.widthPixels);
        config.setCanvasHeight(displayMetrics.heightPixels);
        return config;
    }

    @Override
    public void setStrokeWidth(float width) {
    stroke=width;
    }

    @Override
    public void setDrawColor(int color) {
        if(paint) {
            this.color = color;
        }
        else{
            this.cashcolor=color;
        }
    }

    @Override
    public void undoDraw() {
    drawableView.undo();
    }

    @Override
    public void setTransparent(boolean paint) {
        this.paint=paint;
    }

    @Override
    public void clear() {
    drawableView.clear();
    }

    @Override
    public void showElements() {
    //FUTURE
    }

    @Override
    public void saveImage() {
    //FUTURE
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.grid_status:
                if(gridstatus==A) {
                    gridstatus = B;
                    howToView.changeFABGridStatus(B);
                }else if(gridstatus==B){
                    gridstatus = A;
                    howToView.changeFABGridStatus(A);
                }
                break;
            case R.id.draw_status:
                switch(bgstatus){
                    case AB:
                    bgstatus =A;
                    howToView.changeFABBackgroundStatus(A);
                        break;
                    case A:
                        bgstatus =B;
                        howToView.changeFABBackgroundStatus(B);
                        break;
                    case B:
                        bgstatus =AB;
                        howToView.changeFABBackgroundStatus(AB);
                        break;
                }
                break;
            case R.id.draw_clear:
                howToView.clearDialog();
                break;
            case R.id.draw_color:
                DrawColorDialog colorDialog = new DrawColorDialog();
                colorDialog.setPresenter(this);
                colorDialog.show(fm,"color");
                break;
            case R.id.draw_size:
                DrawSizeDialog sizeDialog= new DrawSizeDialog();
                sizeDialog.setPresenter(this);
                sizeDialog.setProgress(stroke);
                sizeDialog.show(fm,"size");
                break;
            case R.id.draw_undo:
            drawableView.undo();
                break;
            case R.id.moveBtn:
                if(numberofimage+1!=count) howToView.changeImageSrc(Images.getImageListbyId(position)[++numberofimage],count,numberofimage,Images.getCharcters()[position]);
                break;
            case R.id.backBtn:
                if(numberofimage!=0)howToView.changeImageSrc(Images.getImageListbyId(position)[--numberofimage],count,numberofimage,Images.getCharcters()[position]);
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.backBtn:
                howToView.showNavButtons();
                howToView.changeImageSrc(Images.getImageListbyId(position)[(numberofimage=0)],count,numberofimage,Images.getCharcters()[position]);
                return true;
            case R.id.moveBtn:
                howToView.showNavButtons();
                howToView.changeImageSrc(Images.getImageListbyId(position)[(numberofimage=count-1)],count,numberofimage,Images.getCharcters()[position]);
                return true;
        }
        return false;
    }
}
