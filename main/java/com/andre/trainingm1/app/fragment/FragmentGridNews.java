package com.andre.trainingm1.app.fragment;



import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.andre.trainingm1.app.R;
import android.widget.GridView;
import com.andre.trainingm1.app.ViewNewsImage;
import com.andre.trainingm1.app.adapter.GridViewAdapter;
import com.andre.trainingm1.app.models.InfoModels;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class FragmentGridNews extends Fragment {
GridView gridView;
    GridViewAdapter gridViewAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragmentgridnews, container, false);
        gridView=(GridView)view.findViewById(R.id.gridView);
        GridViewAdapter gridViewAdapter=new GridViewAdapter(getActivity());
        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent FullImage=new Intent(getActivity(), ViewNewsImage.class);
                FullImage.putExtra("id",i);
                startActivity(FullImage);
            }
        });
        return view;
    }

}
