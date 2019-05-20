package com.app.nobleapp;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainFragment extends Fragment {

    public MainFragment() {
    }

    public View mainView = null;

    public String gpsLocation = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        TextView newsScrolling = (TextView) rootView.findViewById(R.id.newsScrolling);
        newsScrolling.startAnimation((Animation) AnimationUtils.loadAnimation(getActivity(),R.anim.scrolling));

        mainView = rootView;
        return rootView;
    }


}
