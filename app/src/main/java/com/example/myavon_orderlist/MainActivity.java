package com.example.myavon_orderlist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private RecyclerView lstCamp;
    private CampaignAdapter adapter;
    private LinearLayoutManager llm;
    private ArrayList<Campaign> campaigns;
    //private DatabaseReference databaseReference;
    //private static String db = "Campaign";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fabAddCampaign);
        lstCamp = findViewById(R.id.lstCampaign);

        campaigns = Data.getCampaigns();
        llm = new LinearLayoutManager(this);
        adapter = new CampaignAdapter(campaigns);

        llm.setOrientation(RecyclerView.VERTICAL);
        lstCamp.setLayoutManager(llm);
        lstCamp.setAdapter(adapter);

       /* databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(db).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                campaigns.clear();
                if (snapshot.exists()) {
                    for (DataSnapshot snap: snapshot.getChildren()) {
                        Campaign c = snap.getValue(Campaign.class);
                        campaigns.add(c);
                    }
                }
                adapter.notifyDataSetChanged();
                Data.setCampaigns(campaigns);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/


    }

    public void addCampaign(View v){
        Intent intent = new Intent(MainActivity.this, AddCampaign.class);
        startActivity(intent);
    }


   /* @Override
    public void onCampaignClick(Campaign c) {

        Bundle bundle = new Bundle();
        Intent intent = new Intent(MainActivity.this, ClientsList.class);

        startActivity(intent);
    }*/
}