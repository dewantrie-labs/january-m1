package com.andre.trainingm1.app.session;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Andree on 12/30/2014.
 */
public class PositionArrayList {
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor edit;


    public PositionArrayList(Context context) {
        sharedPreferences =context.getSharedPreferences("position",Context.MODE_PRIVATE);
        edit = sharedPreferences.edit();
        edit.commit();
    }
    public void setInt(int pos){
        edit.putInt("position",pos);
        edit.commit();
    }
    public Integer getInt(){
        return sharedPreferences.getInt("position",0);
    }
    public void clearInt(){
        edit.clear();
        edit.commit();
    }
}
