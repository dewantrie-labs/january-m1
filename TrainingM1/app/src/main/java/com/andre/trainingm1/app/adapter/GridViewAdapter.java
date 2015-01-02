package com.andre.trainingm1.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.andre.trainingm1.app.R;
import com.andre.trainingm1.app.models.InfoModels;

/**
 * Created by Andree on 12/29/2014.
 */
public class GridViewAdapter extends BaseAdapter {
    ImageView ImageNews;
    TextView DetailNews;
    Context context;
    public int[] ForImage={
            R.drawable.ciem1,
            R.drawable.ciem2,
            R.drawable.ciem3,
            R.drawable.ciem4,
            R.drawable.ciem5,
            R.drawable.ciem6,
            R.drawable.ciem7};
public GridViewAdapter(Context context){
    this.context=context;
}
    @Override
    public int getCount() {
        return ForImage.length;
    }

    @Override
    public Object getItem(int i) {
        return ForImage[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.fragment_fragment_grid_adapter,viewGroup,false);
        DetailNews=(TextView)view.findViewById(R.id.textviewgrid);
        ImageNews=(ImageView)view.findViewById(R.id.imagenews);
        DetailNews.setText(ForImage[position]);
        //Drawable ForSetImage= view.getResources().getDrawable(R.drawable.ciem1);
        //ImageNews.setImageDrawable(ForSetImage);
        FrameLayout.LayoutParams layoutParams=new FrameLayout.LayoutParams(200,200);
       ImageNews.setImageResource(ForImage[position]);
        ImageNews.setLayoutParams(layoutParams);

        return view;
    }
}
