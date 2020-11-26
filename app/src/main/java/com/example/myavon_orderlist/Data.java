package com.example.myavon_orderlist;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Data {
    private static String db = "Campaign";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    public static ArrayList<Campaign> campaigns = new ArrayList<>();

    public static String getId(){
        return databaseReference.push().getKey();
    }

    public static void saveCampaign(Campaign c){
        //databaseReference.child(db).child(c.getId()).setValue(c);
        campaigns.add(c);
    }

    public static ArrayList<Campaign> getCampaigns(){
        return campaigns;
    }

    /*public static void setCampaigns(ArrayList<Campaign> c){
        campaigns = c;
    }*/
}
