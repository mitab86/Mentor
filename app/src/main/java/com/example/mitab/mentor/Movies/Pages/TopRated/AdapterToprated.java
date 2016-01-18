package com.example.mitab.mentor.Movies.Pages.TopRated;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.example.mitab.mentor.Movies.Pages.VolleySingleton;
import com.example.mitab.mentor.Movies.Pages.movie;
import com.example.mitab.mentor.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mitab on 1/15/2016.
 */
public class AdapterToprated extends RecyclerView.Adapter<AdapterToprated.ViewHolderToprated>{

    private LayoutInflater layoutInflater;
    private VolleySingleton volleySingleton;
    private ImageLoader imageLoader;
    private ArrayList<movie> listMovies=new ArrayList<>();
    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");


    public AdapterToprated(Context context){
        layoutInflater=LayoutInflater.from(context);
        volleySingleton=VolleySingleton.getsInstance();
        imageLoader=volleySingleton.getImageLoader();
    }

    public void setMovieList(ArrayList<movie> listMovies){
        this.listMovies=listMovies;
        notifyItemRangeChanged(0, listMovies.size());
    }
    @Override
    public ViewHolderToprated onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.individual_toprated, parent, false);
        ViewHolderToprated viewHolderToprated=new ViewHolderToprated(view);
        return viewHolderToprated;
    }

    @Override
    public void onBindViewHolder(final ViewHolderToprated holder, int position) {
        movie currentMovie=listMovies.get(position);
        holder.movieTitle.setText(currentMovie.getTitle());
        Date movieReleaseDate=currentMovie.getReleasedate();
        if (movieReleaseDate!=null){
            String formattedDate=dateFormat.format(movieReleaseDate);
            holder.movieReleaseDate.setText(formattedDate);
        }else{
            holder.movieReleaseDate.setText("NA");
        }

        holder.movieRating.setText(currentMovie.getAveragevote());
        String urlThumnail=currentMovie.getImage();
        if (!urlThumnail.equals("NA")){
            imageLoader.get(urlThumnail, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.movieThumbnail.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    static class ViewHolderToprated extends RecyclerView.ViewHolder{

        private ImageView movieThumbnail;
        private TextView movieTitle;
        private TextView movieReleaseDate;
        private TextView movieRating;

        public ViewHolderToprated(View itemView) {
            super(itemView);
            movieThumbnail=(ImageView) itemView.findViewById(R.id.movieThumbnail);
            movieTitle=(TextView) itemView.findViewById(R.id.movieTitle);
            movieReleaseDate=(TextView) itemView.findViewById(R.id.movieReleaseDate);
            movieRating=(TextView) itemView.findViewById(R.id.movieRating);
        }
    }
}
