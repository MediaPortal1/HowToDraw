package com.poltavets.app.howtodraw.presenter;

import android.content.Context;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.poltavets.app.howtodraw.R;
import com.poltavets.app.howtodraw.model.Images;

import java.util.ArrayList;
import java.util.Map;

public class MainPresenterImpl implements MainPresenter{
    private ArrayList<Map<String,Object>> imagelist;
    private Context context;

    public MainPresenterImpl(Context context) {
        this.context=context;
        imagelist=new ArrayList<Map<String,Object>>();
        for(int i=0;i< Images.getCharcters().length;i++){
            imagelist.add(Images.getPreview(i));
        }
    }

    @Override
    public ListAdapter getListAdapter() {
        return new SimpleAdapter(context,imagelist, R.layout.draw_list_item,new String[]{"name","steps","preview"},new int[]{R.id.nameListItem,R.id.stepsListItem,R.id.imageListItem});
    }
}
