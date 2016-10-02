package com.developer.platzigram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.developer.platzigram.R;
import com.developer.platzigram.model.Picture;
import com.developer.platzigram.view.PictureDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Developer on 29/09/2016.
 */

public class PrictureAdapterRecyclerView extends RecyclerView.Adapter<PrictureAdapterRecyclerView.PrictureViewHolder> {
    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;

    public PrictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public PrictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new PrictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PrictureViewHolder holder, int position) {
        Picture picture = pictures.get(position);
        holder.usernameCard.setText(picture.getUsername());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumbreCard.setText(picture.getLike_number());
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(
                                    activity,view,activity.getString(R.string.transtiorname_picture)).toBundle());
                }
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }


    public class PrictureViewHolder extends RecyclerView.ViewHolder{
        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likeNumbreCard;
        public PrictureViewHolder(View itemView) {
            super(itemView);
            pictureCard = (ImageView) itemView.findViewById(R.id.pictureCards);
            usernameCard = (TextView) itemView.findViewById(R.id.userNemaCard);
            timeCard = (TextView) itemView.findViewById(R.id.timeCard);
            likeNumbreCard = (TextView) itemView.findViewById(R.id.likenamecArd);
        }
    }
}
