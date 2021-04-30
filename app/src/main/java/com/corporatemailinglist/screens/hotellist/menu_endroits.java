package com.corporatemailinglist.screens.hotellist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.corporatemailinglist.R;
import com.corporatemailinglist.repository.datamodels.Restau;

public class menu_endroits extends AppCompatActivity {

    private Button button_hotel;
    private Button button_restau;
    private Button button_site;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_endroits);

        button_hotel = (Button) findViewById(R.id.button_hotel);
        button_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHotelsList();
            }
        });


        button_restau = (Button) findViewById(R.id.button_restau);
        button_restau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRestauList();
            }
        });

        button_site = (Button) findViewById(R.id.button_site);
        button_site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSiteList();
            }
        });
    }

    public void openHotelsList(){
        Intent intent = new Intent(this, HotelListMainActivity.class);
        startActivity(intent);
    }

    public void openRestauList(){
        Intent intent = new Intent(this, RestauListMainActivity.class);
        startActivity(intent);
    }

    public void openSiteList(){
        Intent intent = new Intent(this, SiteListMainActivity.class);
        startActivity(intent);
    }
}