package com.andre.trainingm1.app.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andre.trainingm1.app.R;
import com.andre.trainingm1.app.models.InfoModels;

import java.io.IOException;
import java.io.InputStream;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailHome.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class DetailHome extends Fragment {
    private static InfoModels data;

    public static DetailHome newInstance(Object o) {
        data = (InfoModels) o;
        return new DetailHome();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_home, container, false);
        ImageView imageTitle;
        TextView Title;
        TextView Detail;
        imageTitle = (ImageView) view.findViewById(R.id.imageViewdetailhome);
        Title = (TextView) view.findViewById(R.id.textViewtitledetailhome);
        Detail = (TextView) view.findViewById(R.id.textViewinfodetailhome);
        try {
            InputStream StreamImage = getActivity().getAssets().open(data.getImageName());
            Drawable drawableImage = Drawable.createFromStream(StreamImage, null);
            imageTitle.setImageDrawable(drawableImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Title.setText(data.getTitle());
        Detail.setText(data.getInfo());
        return view;
    }

}