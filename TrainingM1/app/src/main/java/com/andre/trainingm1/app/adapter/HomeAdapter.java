package com.andre.trainingm1.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.andre.trainingm1.app.R;
import com.andre.trainingm1.app.models.InfoModels;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Andree on 12/31/2014.
 */
public class HomeAdapter extends BaseAdapter {
    Context context;
    InfoModels[] infoModelses;

    public HomeAdapter(Context context, InfoModels[] infoModelses) {
        this.context = context;
        this.infoModelses = infoModelses;

    }

    @Override
    public int getCount() {
        return infoModelses.length;
    }

    @Override
    public Object getItem(int i) {
        return infoModelses[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.homelayout, viewGroup, false);
        TextView info, title;
        ImageView imageHome;
        info = (TextView) view.findViewById(R.id.textViewhomeinfo);
        title = (TextView) view.findViewById(R.id.textViewhometitle);
        imageHome = (ImageView) view.findViewById(R.id.ImageViewhome);
        info.setText(infoModelses[i].getInfo());
        title.setText(infoModelses[i].getTitle());
        InputStream ImageStream = null;
        try {
            ImageStream = context.getAssets().open(infoModelses[i].getImageName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Drawable drawableImage = Drawable.createFromStream(ImageStream, null);
        imageHome.setImageDrawable(drawableImage);


        return view;
    }

}
