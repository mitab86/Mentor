package com.example.mitab.mentor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitab on 12/8/2015.
 */
public class CatagoryAdapter extends RecyclerView.Adapter<CatagoryAdapter.MyViewHolder> {

    List<first> mItems;

    public CatagoryAdapter(){
        super();
        mItems = new ArrayList<first>();
        first label= new first();
        label.setName("Sports");
        label.setThumbnail(R.drawable.sample);
        mItems.add(label);

        label=new first();
        label.setName("Movies");
        label.setThumbnail(R.drawable.sample_0);
        mItems.add(label);

        label=new first();
        label.setName("Series");
        label.setThumbnail(R.drawable.sample_1);
        mItems.add(label);

        label=new first();
        label.setName("Channels");
        label.setThumbnail(R.drawable.sample_2);
        mItems.add(label);

        label=new first();
        label.setName("Watchlist");
        label.setThumbnail(R.drawable.sample_3);
        mItems.add(label);

        label=new first();
        label.setName("Channels");
        label.setThumbnail(R.drawable.sample_2);
        mItems.add(label);

        for (int loop=1;loop<100;loop++){

            label=new first();
            label.setName("Watchlist");
            label.setThumbnail(R.drawable.sample_3);
            mItems.add(label);

            label=new first();
            label.setName("Trending");
            label.setThumbnail(R.drawable.sample_4);
            mItems.add(label);
        }

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_main, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {

        first nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());

    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imgThumbnail;
        public TextView tvspecies;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvspecies = (TextView)itemView.findViewById(R.id.tv_species);
            imgThumbnail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //initialize context
            Context context = itemView.getContext();
            Toast.makeText(context,"item clicked at"+getAdapterPosition(),Toast.LENGTH_LONG).show();
        }
    }
}
