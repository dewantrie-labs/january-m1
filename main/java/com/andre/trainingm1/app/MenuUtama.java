package com.andre.trainingm1.app;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import com.andre.trainingm1.app.fragment.FragmentGridNews;
import com.andre.trainingm1.app.fragment.HomeFragment;


public class MenuUtama extends ActionBarActivity {
private String[] menulist;
   private ListView listViewutama;
    private ArrayAdapter<String> adapter;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawertoggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
        Resources resources=getResources();
        menulist=resources.getStringArray(R.array.option);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawe);
        listViewutama=(ListView)findViewById(R.id.listviewutama);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menulist);
        listViewutama.setAdapter(adapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        listViewutama.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                setFragmentContent(i);
                setTitle(adapter.getItem(i));

            }
        });
        drawertoggle=new ActionBarDrawerToggle(this,drawerLayout, 0, 0 ){
            public void onDrawerClosed(View view){
            }
            public void onDrawerOpened(View drawerview){
            }
        };
        drawerLayout.setDrawerListener(drawertoggle);
    }

private void setFragmentContent(int position){
    drawerLayout.closeDrawer(listViewutama);
    Fragment fragment=getFragmentContent(position);
    FragmentManager fragmentManager=getSupportFragmentManager();

    if (fragment!=null){
        fragmentManager.beginTransaction().replace(R.id.detailutama,fragment).commit();

    }
    else {
        Intent out=new Intent(this,MainActivity.class);
        startActivity(out);
        finish();
    }
}


private Fragment getFragmentContent(int position){
    switch (position){
        case 0:return new HomeFragment();
        case 1:return new FragmentGridNews();
        default:return null;
    }
}


@Override
    public boolean onCreateOptionsMenu(Menu menu){
return super.onCreateOptionsMenu(menu);
}
@Override
    public boolean onOptionsItemSelected(MenuItem item){
    if (drawertoggle.onOptionsItemSelected(item)) {
        return true;
    }
    switch (item.getItemId()) {
        return super.onOptionsItemSelected(item);
    }
    }

    @Override
    public void onPostCreate(Bundle savedInstancestate){
        super.onPostCreate(savedInstancestate);
        drawertoggle.syncState();
    }
}

