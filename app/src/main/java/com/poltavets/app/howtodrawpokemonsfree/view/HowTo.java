package com.poltavets.app.howtodrawpokemonsfree.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.poltavets.app.howtodraw.R;
import com.poltavets.app.howtodrawpokemonsfree.presenter.HowToPresenter;
import com.poltavets.app.howtodrawpokemonsfree.presenter.HowToPresenterImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class HowTo extends AppCompatActivity implements HowToView{
    private DrawableView drawableView;
    private HowToPresenter howToPresenter;
    private FloatingActionButton statusFAB,gridFAB;
    private ImageView imageView;
    private int imagenumber;
    private Handler handler;
    private ImageButton back,move;
    private ViewGroup background;
    private String filename;
    private AdView topAd,bottomAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.howtodraw);
        Toolbar toolbar=(Toolbar)findViewById(R.id.howtodraw_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.title_how_to));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metricsB = new DisplayMetrics();
        display.getMetrics(metricsB);
        imageView=(ImageView)findViewById(R.id.howto_image_view);
        if(savedInstanceState!=null)
            imagenumber=savedInstanceState.getInt("position");
        drawableView=(DrawableView)findViewById(R.id.drawview);
        howToPresenter=new HowToPresenterImpl(drawableView,displaymetrics,(HowToView)this,getSupportFragmentManager(),getIntent().getIntExtra("position", 0),imagenumber);
        howToPresenter.initDrawConfig();
        statusFAB=(FloatingActionButton)findViewById(R.id.draw_status);
        statusFAB.setOnClickListener((View.OnClickListener) howToPresenter);
        statusFAB.setColorNormal(ContextCompat.getColor(this, R.color.blue));
        statusFAB.setColorPressed(android.R.color.white);
        gridFAB=(FloatingActionButton)findViewById(R.id.grid_status);
        gridFAB.setOnClickListener((View.OnClickListener)howToPresenter);
        findViewById(R.id.draw_color).setOnClickListener((View.OnClickListener) howToPresenter);
        findViewById(R.id.draw_undo).setOnClickListener((View.OnClickListener) howToPresenter);
        findViewById(R.id.draw_clear).setOnClickListener((View.OnClickListener) howToPresenter);
        findViewById(R.id.draw_size).setOnClickListener((View.OnClickListener) howToPresenter);
        move=(ImageButton)findViewById(R.id.moveBtn);
        move.setOnClickListener((View.OnClickListener) howToPresenter);
        findViewById(R.id.moveBtn).setOnLongClickListener((View.OnLongClickListener) howToPresenter);
        back=(ImageButton)findViewById(R.id.backBtn);
        back.setOnClickListener((View.OnClickListener) howToPresenter);
        back.setOnLongClickListener((View.OnLongClickListener) howToPresenter);
        background=(ViewGroup)findViewById(R.id.howto_bg);
        if(findViewById(R.id.floatingmenu)!=null){
            topAd = (AdView) findViewById(R.id.adv_top);
            AdRequest adRequestTop = new AdRequest.Builder().build();
            topAd.loadAd(adRequestTop);
        }
        bottomAd = (AdView) findViewById(R.id.adv_bottom);
        AdRequest adRequestBottom = new AdRequest.Builder().build();
        bottomAd.loadAd(adRequestBottom);
    }


    @Override
    public void changeDrawConfig(DrawableViewConfig config) {
        drawableView.setConfig(config);
    }

    @Override
    public void changeFABBackgroundStatus(int status) {
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
    public void changeFABGridStatus(int status) {
        switch (status){
            case HowToPresenterImpl.A:
                gridFAB.setImageResource(R.mipmap.grid_off);
                background.setBackgroundResource(R.drawable.bgklekta);
                break;
            case HowToPresenterImpl.B:
                gridFAB.setImageResource(R.mipmap.grid);
                background.setBackgroundColor(Color.WHITE);
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
    public void clearDialog() {
        AlertDialog dialog=new AlertDialog.Builder(HowTo.this)
                .setTitle(R.string.areyousure)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        drawableView.clear();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setMessage(R.string.deletemessage)
                .setCancelable(true)
                .setIcon(R.mipmap.delete).create();
            dialog.show();
    }

    @Override
    public void changeImageSrc(int image,int count,int position,String name) {
        filename=name+"_"+image+"_"+position;
        imagenumber=position;
        if(move!=null || back!=null) {
            move.setEnabled(false);
            back.setEnabled(false);
        }
        Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(getRequestedOrientation()==ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
                    imageView.setImageBitmap(decodeSampledBitmapFromResource(getResources(), msg.what,100,100));
                else imageView.setImageBitmap(decodeSampledBitmapFromResource(getResources(), msg.what,400,400));
//                imageView.setImageResource(msg.what);
            }
        };
        handler.sendEmptyMessage(image);

        getSupportActionBar().setTitle(getResources().getString(R.string.title_how_to) + " " + name + ": " + (position+1)+"/"+(count));
            if(position==0 || position+1==count){
                if(position==0){
                    findViewById(R.id.backBtn).setEnabled(false);
                    findViewById(R.id.backBtn).setVisibility(View.INVISIBLE);
                }
                else {
                    findViewById(R.id.moveBtn).setEnabled(false);
                    findViewById(R.id.moveBtn).setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(),getString(R.string.finish),Toast.LENGTH_SHORT).show();
                }
            }
            else {
                showNavButtons();
            }
        if(move!=null || back!=null) {
            move.setEnabled(true);
            back.setEnabled(true);
        }

        }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("position",imagenumber);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        imagenumber=savedInstanceState.getInt("position");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.howto_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.saveimage) {
            String path = Environment.getExternalStorageDirectory().toString();
            OutputStream fOut = null;
            File file = new File(path, filename + ".png"); // the File to save to
            try {
                fOut = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            drawableView.setDrawingCacheEnabled(true);
            drawableView.buildDrawingCache();
            Bitmap pictureBitmap = drawableView.getDrawingCache(); // obtaining the Bitmap
            Bitmap newBitmap = Bitmap.createBitmap(pictureBitmap.getWidth(), pictureBitmap.getHeight(), pictureBitmap.getConfig());
            Canvas canvas = new Canvas(newBitmap);
            canvas.drawColor(Color.WHITE);
            canvas.drawBitmap(pictureBitmap, 0, 0, null);
            newBitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            try {
                fOut.flush();
                fOut.close(); // do not forget to close the stream
                MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                Toast.makeText(getApplicationContext(), getString(R.string.saved), Toast.LENGTH_SHORT).show();
                drawableView.setDrawingCacheEnabled(false);

            }
        }
        else if(item.getItemId() == R.id.removeads){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.poltavets.app.howtodraw")));
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onPause() {
        if (topAd != null) {
            topAd.pause();
        }
        if (bottomAd != null) {
            bottomAd.pause();
        }

        super.onPause();
    }
    @Override
    public void onResume() {
        super.onResume();
        if (topAd != null) {
            topAd.resume();
        }
        if (bottomAd != null) {
            bottomAd.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (topAd != null) {
            topAd.destroy();
        }
        if (bottomAd != null) {
            bottomAd.destroy();
        }
        howToPresenter.destroy();
        howToPresenter=null;
        super.onDestroy();
    }
}
