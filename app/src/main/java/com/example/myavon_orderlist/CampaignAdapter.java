package com.example.myavon_orderlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CampaignAdapter extends RecyclerView.Adapter<CampaignAdapter.CampaignViewHolder>{

    private ArrayList<Campaign> campaigns;

    public CampaignAdapter(ArrayList<Campaign> campaigns){
        this.campaigns = campaigns;
    }

    @NonNull
    @Override
    public CampaignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.campaign_item, parent, false);
        return new CampaignViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CampaignViewHolder holder, int position) {
        Campaign c = campaigns.get(position);
        holder.campNumber.setText(c.getNumber());
        holder.endDate.setText(c.getEnd_date());

    }

    @Override
    public int getItemCount() {
        return campaigns.size();
    }

    public static class CampaignViewHolder extends RecyclerView.ViewHolder{
        private TextView campNumber, endDate;
        private View v;

        public CampaignViewHolder(View itemView){
            super(itemView);
            v = itemView;
            campNumber = v.findViewById(R.id.lblCampNumber);
            endDate = v.findViewById(R.id.lblEndDate);
        }
    }
}
