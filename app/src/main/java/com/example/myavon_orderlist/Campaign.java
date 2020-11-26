package com.example.myavon_orderlist;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;

public class Campaign {
    private String number, end_date, id;
    private ArrayList<Client> clients;

    public Campaign(String number, String end_date, String id) {
        this.number = number;
        this.end_date = end_date;
        this.id = id;
    }

    public Campaign(){

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void save(){
        Data.saveCampaign(this);
    }
}
