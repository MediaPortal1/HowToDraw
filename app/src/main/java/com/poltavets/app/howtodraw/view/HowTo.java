package com.poltavets.app.howtodraw.view;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.poltavets.app.howtodraw.R;
import com.poltavets.app.howtodraw.model.Images;
import com.poltavets.app.howtodraw.presenter.HowToPresenter;
import com.poltavets.app.howtodraw.presenter.HowToPresenterImpl;
import com.poltavets.app.howtodraw.view.fragments.DrawSizeDialog;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class HowTo extends AppCompatActivity implements HowToView{
    private DrawableView drawableView;
    private HowToPresenter howToPresenter;
    private FloatingActionButton statusFAB;
    private ImageView imageView;
    private int imagenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.howtodraw);
        if(savedInstanceState!=null)
            imagenumber=savedInstanceState.getInt("position");
        else
            imagenumber=0;
        drawableView=(DrawableView)findViewById(R.id.drawview);
        Toolbar toolbar=(Toolbar)findViewById(R.id.howtodraw_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.title_how_to));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metricsB = new DisplayMetrics();
        display.getMetrics(metricsB);
        imageView=(ImageView)findViewById(R.id.howto_image_view);
        howToPresenter=new HowToPresenterImpl(drawableView,displaymetrics,(HowToView)this,getSupportFragmentManager(),getIntent().getIntExtra("position", 0),imagenumber);
        howToPresenter.initDrawConfig();
        statusFAB=(FloatingActionButton)findViewById(R.id.draw_status);
        statusFAB.setOnClickListener((View.OnClickListener) howToPresenter);
        statusFAB.setColorNormal(ContextCompat.getColor(this, R.color.blue));
        statusFAB.setColorPressed(android.R.color.white);
        findViewById(R.id.draw_color).setOnClickListener((View.OnClickListener) howToPresenter);
        findViewById(R.id.draw_undo).setOnClickListener((View.OnClickListener) howToPresenter);
        findViewById(R.id.draw_clear).setOnClickListener((View.OnClickListener) howToPresenter);
        findViewById(R.id.draw_size).setOnClickListener((View.OnClickListener) howToPresenter);
        findViewById(R.id.moveBtn).setOnClickListener((View.OnClickListener)howToPresenter);
        findViewById(R.id.moveBtn).setOnLongClickListener((View.OnLongClickListener) howToPresenter);
        findViewById(R.id.backBtn).setOnClickListener((View.OnClickListener) howToPresenter);
        findViewById(R.id.backBtn).setOnLongClickListener((View.OnLongClickListener) howToPresenter);
    }


    @Override
    public void changeDrawConfig(DrawableViewConfig config) {
        drawableView.setConfig(config);
    }

    @Override
    public void changeFABStatus(int status) {
        switch (status){
            case HowToPresenterImpl.AB:
                drawableView.setVisibility(View.VISIBLE);
                drawableView.setEnabled(true);
                imageView.setVisibility(View.VISIBLE);
                statusFAB.setColorNormal(ContextCompat.getColor(this, R.color.blue));
                Toast.makeText(this,getResources().getString(R.string.AB),Toast.LENGTH_SHORT).show();
                break;
            case HowToPresenterImpl.A:
                drawableView.setVisibility(View.INVISIBLE);
                drawableView.setEnabled(false);
                imageView.setVisibility(View.VISIBLE);
                statusFAB.setColorNormal(ContextCompat.getColor(this, R.color.colorStatusA));
                Toast.makeText(this,getResources().getString(R.string.A),Toast.LENGTH_SHORT).show();
                break;

            case HowToPresenterImpl.B:
                drawableView.setVisibility(View.VISIBLE);
                drawableView.setEnabled(true);
                imageView.setVisibility(View.INVISIBLE);
                statusFAB.setColorNormal(ContextCompat.getColor(this, R.color.colorAccent));
                Toast.makeText(this,getResources().getString(R.string.B),Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void showNavButtons() {
        findViewById(R.id.backBtn).setEnabled(true);
        findViewById(R.id.backBtn).setVisibility(View.VISIBLE);
        findViewById(R.id.moveBtn).setEnabled(true);
        findViewById(R.id.moveBtn).setVisibility(View.VISIBLE);
    }

    @Override
    public void changeImageSrc(int image,int count,int position,String name) {
        Drawable img= ResourcesCompat.getDrawable(getResources(),image,null);
        ColorFilter filter=new PorterDuffColorFilter(Color.WHITE, PorterDuff.Mode.CLEAR);
        img.setColorFilter(filter);
        imageView.setImageDrawable(img);
        getSupportActionBar().setTitle(getResources().getString(R.string.title_how_to) + " " + name + ": " + position+"/"+(count-1));
        if(position==0 || position+1==count){
            if(position==0){
                findViewById(R.id.backBtn).setEnabled(false);
                findViewById(R.id.backBtn).setVisibility(View.INVISIBLE);
            }
                else {
                findViewById(R.id.moveBtn).setEnabled(false);
                findViewById(R.id.moveBtn).setVisibility(View.INVISIBLE);
                Toast.makeText(this,getString(R.string.finish),Toast.LENGTH_SHORT).show();
            }
            }
        else {
            showNavButtons();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("position",imagenumber);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        imagenumber=savedInstanceState.getInt("position");
    }
}
