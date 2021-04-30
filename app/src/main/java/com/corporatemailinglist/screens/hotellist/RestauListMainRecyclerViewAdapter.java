package com.corporatemailinglist.screens.hotellist;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.corporatemailinglist.R;
import com.corporatemailinglist.repository.datamodels.Restau;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RestauListMainRecyclerViewAdapter extends RecyclerView.Adapter<RestauListMainRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = null ;
    private List hotelList;

    private RestauListMainActivity.RestauListRecyclerViewOnItemClickListener restauListRecyclerViewOnItemClickListener;

    RestauListMainRecyclerViewAdapter(List hotelList, RestauListMainActivity.RestauListRecyclerViewOnItemClickListener restauListRecyclerViewOnItemClickListener) {
        this.hotelList = hotelList;
        this.restauListRecyclerViewOnItemClickListener = restauListRecyclerViewOnItemClickListener;
    }

    @NonNull
    @Override
    public RestauListMainRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.restau_item_cardview, parent, false);
        itemView.setOnClickListener(restauListRecyclerViewOnItemClickListener);

        return new RestauListMainRecyclerViewAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RestauListMainRecyclerViewAdapter.ViewHolder holder, int position) {

        Restau restau = (Restau) hotelList.get(position);
        // String i_am_tired = ville.toStringImage()

        holder.hotelname.setText(restau.getNom_hotel());
        holder.cityname.setText(restau.getNom_ville());

        Picasso.get()
                .load(restau.getImageURI())
                .into(holder.image_url , new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        // will load image
                    }

                    @Override
                    public void onError(Exception e) {

                    }



                });
        //holder.image_url.setImageURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/projets4-d3262.appspot.com/o/travel.jpg?alt=media&token=51af0d8b-55af-48c8-961b-01ade515e347"));
        //Log.d(TAG, hotel.getImageURI() + " " + hotel.getNom_hotel());

    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    /** ViewHolder pattern: Inner class needed to keep the references between widgets and data to improve the performance */
    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image_url;
        TextView cityname;
        TextView hotelname;


        ViewHolder(View itemView) {

            super(itemView);

            hotelname = itemView.findViewById(R.id.textView1);
            cityname = itemView.findViewById(R.id.textView2);
            image_url= itemView.findViewById(R.id.image1);
        }
    }
}

