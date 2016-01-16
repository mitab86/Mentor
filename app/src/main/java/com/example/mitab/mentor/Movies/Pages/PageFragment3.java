package com.example.mitab.mentor.Movies.Pages;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mitab.mentor.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment3 extends Fragment {


    private int mPage;
    public static final String ARG_PAGE = "ARG_PAGE";

    public static PageFragment3 newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment3 fragment = new PageFragment3();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        TextView movie = (TextView) view.findViewById(R.id.movie);
        movie.setText("jude");
        // Inflate the layout for this fragment
        return view;
    }
}
