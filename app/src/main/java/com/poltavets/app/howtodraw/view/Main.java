package com.poltavets.app.howtodraw.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.poltavets.app.howtodraw.R;
import com.poltavets.app.howtodraw.presenter.MainPresenter;
import com.poltavets.app.howtodraw.presenter.MainPresenterImpl;
import com.poltavets.app.howtodraw.view.fragments.AboutDialog;


public class Main extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private MainPresenter presenter;
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
        Toolbar toolbar=(Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        presenter=new MainPresenterImpl(this);
        ListView listView=(ListView)findViewById(R.id.main_listview);
        listView.setAdapter(presenter.getListAdapter());
        listView.setOnItemClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
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
                Toast.makeText(this,getString(R.string.welcome),Toast.LENGTH_SHORT).show();
                break;
        }
    return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this,HowTo.class);
        intent.putExtra("position",position);
        startActivity(intent);
    }
}
