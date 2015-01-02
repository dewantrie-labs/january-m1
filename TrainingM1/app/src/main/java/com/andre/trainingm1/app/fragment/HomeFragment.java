package com.andre.trainingm1.app.fragment;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.andre.trainingm1.app.adapter.HomeAdapter;
import com.andre.trainingm1.app.models.InfoModels;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends ListFragment {
    public OnCall listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnCall) {
            listener = (OnCall) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implemenet MyListFragment.OnItemSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        new ImageSet().execute();
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    public interface OnCall {
        public void onCall(Object o);
    }

    private class ImageSet extends AsyncTask<Void, Void, InfoModels[]> {
        @Override
        protected InfoModels[] doInBackground(Void... voids) {
            Gson gson = new Gson();
            try {
                InputStream inputStream = getActivity().getAssets().open("DataInfo.json");
                Reader reader = new InputStreamReader(inputStream);
                try {
                    InfoModels[] info = gson.fromJson(reader, InfoModels[].class);
                    return info;
                } finally {
                    reader.close();
                }
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(final InfoModels[] result) {
            if (result != null) {
                final HomeAdapter homeAdapter = new HomeAdapter(getActivity(), result);
                setListAdapter(homeAdapter);
                homeAdapter.notifyDataSetChanged();
                getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        InfoModels info = (InfoModels) homeAdapter.getItem(i);
                        listener.onCall(info);
                    }
                });
            }
        }
    }

}
