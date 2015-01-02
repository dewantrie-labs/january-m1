package com.andre.trainingm1.app;

import android.content.Intent;
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
import android.widget.*;
import com.andre.trainingm1.app.fragment.DetailHome;
import com.andre.trainingm1.app.session.PositionArrayList;
import com.andre.trainingm1.app.fragment.FragmentGridNews;
import com.andre.trainingm1.app.fragment.HomeFragment;


public class MenuUtama extends ActionBarActivity implements HomeFragment.OnCall{
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
                PositionArrayList pos=new PositionArrayList(MenuUtama.this);
                pos.setInt(i);
                setFragmentContent("position",new PositionArrayList(getApplicationContext()).getInt());
            }
        });
        setFragmentContent("position",new PositionArrayList(getApplicationContext()).getInt());
        drawertoggle=new ActionBarDrawerToggle(this,drawerLayout, 0, 0 ){
            public void onDrawerClosed(View view){
                invalidateOptionsMenu();
            }
            public void onDrawerOpened(View drawerView){
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(drawertoggle);

    }

private void setFragmentContent(String alfa,int position){
    drawerLayout.closeDrawer(listViewutama);
    Fragment fragment=getFragmentContent(position);
    FragmentManager fragmentManager=getSupportFragmentManager();
    if (fragment!=null){
        setTitle(adapter.getItem(position));
        fragmentManager.beginTransaction().replace(R.id.detailutama,fragment).commit();
        listViewutama.setItemChecked(position,true);

    }
    else {
        Intent out=new Intent(this,MainActivity.class);
        startActivity(out);
        PositionArrayList ForClear=new PositionArrayList(this);
        ForClear.clearInt();
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
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_menu_utama, menu);
return super.onCreateOptionsMenu(menu);
}
@Override
    public boolean onOptionsItemSelected(MenuItem item){
    if (drawertoggle.onOptionsItemSelected(item)) {
        return true;
    }
    switch (item.getItemId()) {

    }
    return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstancestate){
        super.onPostCreate(savedInstancestate);
        drawertoggle.syncState();
    }


    @Override
    public void onCall(Object o) {
    getSupportFragmentManager().beginTransaction().replace(R.id.detailutama, DetailHome.newInstance(o)).commit();
    }
    @Override
    public void onBackPressed() {
        getSupportFragmentManager().beginTransaction().replace(R.id.detailutama,new HomeFragment()).commit();
    }

}

