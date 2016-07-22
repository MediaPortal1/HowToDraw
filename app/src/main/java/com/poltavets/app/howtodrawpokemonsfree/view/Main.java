package com.poltavets.app.howtodrawpokemonsfree.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.poltavets.app.howtodraw.R;
import com.poltavets.app.howtodrawpokemonsfree.model.Images;
import com.poltavets.app.howtodrawpokemonsfree.view.fragments.AboutDialog;

import java.util.ArrayList;
import java.util.Map;


public class Main extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<Map<String,Object>> imagelist;
    private ListView mainList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SchoolStyle);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        mainList = (ListView) findViewById(R.id.main_listview);
        mainList.setOnItemClickListener(this);
        initList();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_menu:
                DialogFragment dialogFragment = new AboutDialog();
                dialogFragment.show(getSupportFragmentManager(), "about");
                break;
            case R.id.appsbyme_menu:
                AlertDialog.Builder builder = new AlertDialog.Builder(Main.this, R.style.CustomDialog);
                builder.setMessage(R.string.moreapps_question)
                        .setTitle(R.string.moreapps)
                        .setCancelable(true)
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getBaseContext(), getString(R.string.welcome), Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:Alex Poltavets")));
                            }
                        })
                        .create()
                        .show();

                break;
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, HowTo.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
    private void initList(){
        imagelist=new ArrayList<Map<String,Object>>();
        for(int i = 0; i< Images.getCharcters().length; i++){
            imagelist.add(Images.getPreview(i));
        }
        mainList.setAdapter(new HowToAdapter());
    }
    private class HowToAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imagelist.size();
        }

        @Override
        public Object getItem(int position) {
            return imagelist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View itemView=inflater.inflate(R.layout.draw_list_item,parent,false);
            ImageView image= (ImageView) itemView.findViewById(R.id.imageListItem);
            image.setImageResource((int)imagelist.get(position).get("preview"));
            ImageView imageStars= (ImageView) itemView.findViewById(R.id.imageView_item_stars);
            switch ((int)imagelist.get(position).get("stars")) {
                case 1:
                    imageStars.setImageResource(R.mipmap.star1);
                    break;
                case 2:
                    imageStars.setImageResource(R.mipmap.star2);
                    break;
                case 3:
                    imageStars.setImageResource(R.mipmap.star3);
                    break;
                case 4:
                    imageStars.setImageResource(R.mipmap.star4);
                    break;
                case 5:
                    imageStars.setImageResource(R.mipmap.star5);
                    break;
                default:
                    imageStars.setImageResource(R.mipmap.star2);
            }
            TextView name= (TextView) itemView.findViewById(R.id.nameListItem);
            name.setText((String)imagelist.get(position).get("name"));
            TextView steps=(TextView)itemView.findViewById(R.id.stepsListItem);
            steps.setText(imagelist.get(position).get("steps")+" "+getString(R.string.steps));

            return itemView;
        }
    }
}
