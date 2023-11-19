package com.app.daeja.Adapter;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.app.daeja.Activity.Domain.Location;
import com.app.daeja.Activity.InformationActivity;
import com.app.daeja.Activity.RecomendActivity;
import com.app.daeja.Fragment.SearchFragment;
import com.app.daeja.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SearchLocationAdapter extends RecyclerView.Adapter<SearchLocationAdapter.Viewholder>{

    ArrayList<Location> locations;
    DecimalFormat formatter;

    SearchFragment searchFragment;

    public SearchLocationAdapter(ArrayList<Location> locations, SearchFragment searchFragment){
        this.locations = locations;
        this.searchFragment = searchFragment;
        formatter= new DecimalFormat("###,###,###,###");
    }


    @NonNull
    @Override
    public SearchLocationAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_search_location, parent, false);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.tv_locateName.setText(locations.get(position).getName());
        holder.tv_address.setText(locations.get(position).getAddress());
        holder.tv_tel.setText(locations.get(position).getTel());
        getContext();
        Intent intent = new Intent(searchFragment.getActivity(), RecomendActivity.class);
        intent.putExtra("WHO", "location");
        intent.putExtra("lat", locations.get(position).getLat());
        intent.putExtra("lng", locations.get(position).getLng());
        holder.img_recommend.setOnClickListener(v -> {
            searchFragment.startActivity(intent);
                });
        holder.constraintLayout.setOnClickListener(v -> {
            Intent intent1 = new Intent(searchFragment.getActivity(), InformationActivity.class);
            intent1.putExtra("name", locations.get(position).getName());
            intent1.putExtra("subName", locations.get(position).getSubName());
            intent1.putExtra("address", locations.get(position).getAddress());
            intent1.putExtra("tel", locations.get(position).getTel());
            searchFragment.startActivity(intent1);
        });
    }

    @Override
    public int getItemCount() { return locations.size(); }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView tv_locateName, tv_address, tv_tel;
        ImageView img_recommend;
        ConstraintLayout constraintLayout;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tv_locateName = itemView.findViewById(R.id.tv_locateName);
            tv_address = itemView.findViewById(R.id.tv_address);
            tv_tel = itemView.findViewById(R.id.tv_tel);
            img_recommend = itemView.findViewById(R.id.img_recommend);
            constraintLayout = itemView.findViewById(R.id.cl_showInfo);
        }
    }

}
