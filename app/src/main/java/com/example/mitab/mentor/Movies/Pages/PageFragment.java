package com.example.mitab.mentor.Movies.Pages;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mitab.mentor.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    private int mPage;

    public static final String ARG_PAGE = "ARG_PAGE";
    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_page, container, false);
        //TextView movie = (TextView) view.findViewById(R.id.movie);
        //movie.setText("Fragment #" + mPage);
        RequestQueue requestQueue=VolleySingleton.getsInstance().getRequestQueue();
        StringRequest request=new StringRequest(Request.Method.GET, "http://php.net/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(),"RESPONSE"+response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"ERROR"+error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });



        requestQueue.add(request);
        // Inflate the layout for this fragment
        return view;
    }


}