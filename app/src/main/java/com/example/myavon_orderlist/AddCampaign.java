package com.example.myavon_orderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class AddCampaign extends AppCompatActivity implements View.OnClickListener{

    private int day, month_, year_;
    private EditText campNum, endDate;
    private InputMethodManager im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_campaign);

        campNum = findViewById(R.id.txtCampNum);
        endDate = findViewById(R.id.txtEndDate);

        endDate.setOnClickListener(this);
    }

    public void save(View v){
        String num, date, id;
        Campaign campaign;

        im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(campNum.getWindowToken(), 0);

        num = campNum.getText().toString();
        date = endDate.getText().toString();
        //id = Data.getId();
        id = "";

        campaign = new Campaign(num, date, id);
        campaign.save();
        clear();
        Snackbar.make(v, R.string.camp_success_msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.txtEndDate:
                showDatePickerDialog();
                break;
        }
    }

    public void clear(View v){
        clear();
    }

    public void clear(){
        campNum.setText("");
        endDate.setText("");
        campNum.requestFocus();
    }

    private void showDatePickerDialog(){

        final Calendar calendar = Calendar.getInstance();

        day = calendar.get(Calendar.DAY_OF_MONTH);
        month_ = calendar.get(Calendar.MONTH);
        year_ = calendar.get(Calendar.YEAR);

        DatePickerDialog dialog;
        dialog = new DatePickerDialog(AddCampaign.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                endDate.setText(dayOfMonth+" - "+(month+1)+" - "+year);
            }
        }, year_, month_, day);
        dialog.show();
    }

    public void  onBackPressed(){
        finish();
        Intent intent = new Intent(AddCampaign.this, MainActivity.class);
        startActivity(intent);
    }

}