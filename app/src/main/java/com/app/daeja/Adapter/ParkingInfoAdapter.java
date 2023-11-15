package com.app.daeja.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.daeja.Activity.Domain.ParkingInfo;
import com.app.daeja.Activity.RecomendActivity;
import com.app.daeja.R;
import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ParkingInfoAdapter extends RecyclerView.Adapter<ParkingInfoAdapter.Viewholder> {
    ArrayList<ParkingInfo> parkingInfos;
    DecimalFormat formatter;
    private RecomendActivity recomendActivity;


    public ParkingInfoAdapter(ArrayList<ParkingInfo> parkingInfos, RecomendActivity recomendActivity){
        this.parkingInfos = parkingInfos;
        this.recomendActivity = recomendActivity;
        formatter= new DecimalFormat("###,###,###,###");
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_parking_info, parent, false);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.parkingNameTxt.setText(parkingInfos.get(position).getPARKING_NAME());
        holder.parkingStateTxt.setText("주차 잔여공간 " + parkingInfos.get(position).get주차혼잡도());
        holder.changePercentTxt.setText(formatter.format(parkingInfos.get(position).get현재_주차_차량수())+ " / " +
                formatter.format(parkingInfos.get(position).get총_주차면()));
        holder.parkingPriceTxt.setText(parkingInfos.get(position).get기본_주차_요금() + "원/" + parkingInfos.get(position).get기본_주차_시간_분_단위() + "분");
        String str_cng;
        if(parkingInfos.get(position).get주차혼잡도().equals("많음")){
            holder.changePercentTxt.setTextColor(Color.parseColor("#97B9AD"));
            str_cng = "ic_green";
        }else if (parkingInfos.get(position).get주차혼잡도().equals("보통")){
            holder.changePercentTxt.setTextColor(Color.parseColor("#FFF7E682"));
            str_cng = "ic_yellow";
        }else{ //적음
            holder.changePercentTxt.setTextColor(Color.parseColor("#FFD65745"));
            str_cng = "ic_red";
        }

        int drawableResourceID=holder.itemView.getContext().getResources()
                .getIdentifier(str_cng, "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceID)
                .into(holder.pinImg);

        holder.img_findPath.setOnClickListener(v ->
                recomendActivity.drawPathAsync(parkingInfos.get(position).getLAT(), parkingInfos.get(position).getLNG()) //tmap까지 static으로 해서 그런듯 ㄴㄴ 객체가 없으니까 업데이트가 안 되는 느낌? 나도 잘은 몰
                );
    }

    @Override
    public int getItemCount() {
        return parkingInfos.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView parkingNameTxt, parkingStateTxt, changePercentTxt, parkingPriceTxt;
        ImageView pinImg, img_findPath;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            parkingNameTxt = itemView.findViewById(R.id.parkingNameTxt);
            parkingStateTxt = itemView.findViewById(R.id.parkingStateTxt);
            changePercentTxt = itemView.findViewById(R.id.changePercentTxt);
            parkingPriceTxt = itemView.findViewById(R.id.parkingPriceTxt);
            pinImg = itemView.findViewById(R.id.pinImg);
            img_findPath = itemView.findViewById(R.id.img_findPath);
        }
    }
}
