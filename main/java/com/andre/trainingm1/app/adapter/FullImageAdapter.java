package com.andre.trainingm1.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.andre.trainingm1.app.R;

/**
 * Created by Andree on 12/30/2014.
 */
public class FullImageAdapter extends PagerAdapter {
    Context context;
    private int[] ImageFull;
    LayoutInflater inflater;

    public FullImageAdapter(Context context,int[] flag){
        this.context=context;
        this.ImageFull=flag;
    }
    @Override
    public int getCount() {
        return ImageFull.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view==(RelativeLayout)o;
    }

    @Override
    public Object instantiateItem(ViewGroup container,int position){
        ImageView imageView;
        inflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.imagefulladapter,container,false);
        imageView=(ImageView)view.findViewById(R.id.imageViewFull);
        imageView.setImageResource(ImageFull[position]);
        ((ViewPager)container).addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container,int position,Object object){
        ((ViewPager)container).removeView((RelativeLayout)object);
    }
}
