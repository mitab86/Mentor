package com.example.mitab.mentor.Movies.Pages.TopRated;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.mitab.mentor.Movies.Pages.MyApplication;
import com.example.mitab.mentor.Movies.Pages.VolleySingleton;
import com.example.mitab.mentor.Movies.Pages.movie;
import com.example.mitab.mentor.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.mitab.mentor.Movies.Pages.Keys.EndpointToprated.*;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopratedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopratedFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String Top_rated="http://api.themoviedb.org/3/movie/top_rated";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private VolleySingleton volleySingleton;
    private ImageLoader imageLoader;
    private RequestQueue requestQueue;
    private ArrayList<movie> listMovies=new ArrayList<>();
    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    private RecyclerView listMovieHits;
    private AdapterToprated adapterToprated;


    public TopratedFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TopratedFragment newInstance(String param1, String param2) {
        TopratedFragment fragment = new TopratedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        volleySingleton= VolleySingleton.getsInstance();
        requestQueue=volleySingleton.getRequestQueue();
        sendJsonRequest();

    }

    private void sendJsonRequest(){
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, getRequestUrl(1), (String)null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                listMovies=parseJSONResponse(response);
                adapterToprated.setMovieList(listMovies);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }

    private ArrayList<movie> parseJSONResponse(JSONObject response){
        ArrayList<movie> listMovies=new ArrayList<>();
        if (response==null || response.length()>0){



        try {
                JSONArray arrayMovies=response.getJSONArray(KEY_MOVIES);
                for (int i=0;i<arrayMovies.length();i++){

                    long id=-1;
                    String title="NA";
                    String poster="NA";
                    String release="NA";
                    String overview="NA";
                    String vote="NA";
                    String votecount="NA";

                    JSONObject currentMovie=arrayMovies.getJSONObject(i);

                    //get the id of current movie
                    if (currentMovie.has(KEY_ID)&& !currentMovie.isNull(KEY_ID)){
                        id=currentMovie.getLong(KEY_ID);
                    }

                    if (currentMovie.has(KEY_TITLE)&& !currentMovie.isNull(KEY_TITLE)){
                        title=currentMovie.getString(KEY_TITLE);
                    }

                    if (currentMovie.has(KEY_POSTER_PATH)&& !currentMovie.isNull(KEY_POSTER_PATH)){
                        poster=currentMovie.getString(KEY_POSTER_PATH);
                    }

                    if (currentMovie.has(KEY_RELEASE_DATE)&& !currentMovie.isNull(KEY_RELEASE_DATE)){
                        release=currentMovie.getString(KEY_RELEASE_DATE);
                    }

                    if (currentMovie.has(KEY_OVERVIEW)&& !currentMovie.isNull(KEY_OVERVIEW)){
                        overview=currentMovie.getString(KEY_OVERVIEW);
                    }

                    if (currentMovie.has(KEY_AVERAGE_VOTE)&& !currentMovie.isNull(KEY_AVERAGE_VOTE)){
                        vote=currentMovie.getString(KEY_AVERAGE_VOTE);
                    }

                    if (currentMovie.has(KEY_VOTE_COUNT)&& !currentMovie.isNull(KEY_VOTE_COUNT)){
                        votecount=currentMovie.getString(KEY_VOTE_COUNT);
                    }







                    JSONArray genre=currentMovie.getJSONArray(KEY_GENRE_IDS);

                    if (currentMovie.has(KEY_GENRE_IDS)&& !currentMovie.isNull(KEY_GENRE_IDS)){
                        for (int j=0;j<genre.length();j++){
                            try {
                                String itemInArray=genre.getString(j);

                            }
                            catch (JSONException e){

                            }
                        }
                    }


                    movie movie=new movie();
                    movie.setId(id);
                    movie.setTitle(title);
                    movie.setOverview(overview);
                    movie.setAveragevote(vote);
                    Date date=null;
                    try {
                        date=dateFormat.parse(release);
                    }
                    catch (ParseException e){

                    }

                    movie.setReleasedate(date);
                    movie.setImage(poster);
                    movie.setVotecount(votecount);

                    if (id!=-1 && !title.equals("NA"))
                    {
                        listMovies.add(movie);
                    }


                }



        }
        catch (JSONException e){

        }
    }
        return listMovies;
    }

    public static String getRequestUrl(int page){
        return Top_rated +"?api_key="+ MyApplication.API_KEY + "&page="+page;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_toprated, container, false);
        listMovieHits=(RecyclerView) view.findViewById(R.id.listMovieHits);
        listMovieHits.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterToprated=new AdapterToprated(getActivity());
        listMovieHits.setAdapter(adapterToprated);
        sendJsonRequest();

        // Inflate the layout for this fragment
        return view;
    }


}
