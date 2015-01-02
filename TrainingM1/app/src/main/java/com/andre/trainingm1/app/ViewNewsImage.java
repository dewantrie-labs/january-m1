package com.andre.trainingm1.app;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.andre.trainingm1.app.adapter.FullImageAdapter;
import com.andre.trainingm1.app.adapter.GridViewAdapter;
import com.andre.trainingm1.app.models.InfoModels;


public class ViewNewsImage extends ActionBarActivity {
ViewPager viewPager;
    PagerAdapter pagerAdapter;
    int[] flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_news_image);
        Intent FullImage=getIntent();
        Integer position=FullImage.getExtras().getInt("id");
        Log.d("position",position.toString());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GridViewAdapter adapter=new GridViewAdapter(this);
        flag=adapter.ForImage;
        viewPager=(ViewPager)findViewById(R.id.pager);
        pagerAdapter=new FullImageAdapter(this,flag);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(position);
    }
    @Override
    public void onPause(){
        super.onPause();
        System.gc();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        return super.onCreateOptionsMenu(menu);
    }

}
