package com.corporatemailinglist.screens.hotellist;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.corporatemailinglist.R;
import com.corporatemailinglist.repository.datamodels.Hotel;
import com.corporatemailinglist.repository.firestore.HotelsFirestoreManager;
import com.corporatemailinglist.screens.hoteldetails.HotelDetailsActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class HotelListMainActivity extends AppCompatActivity {
    private static String TAG = com.corporatemailinglist.screens.hotellist.HotelListMainActivity.class.toString();


    /* Widgets */
    private Toolbar toolbar;
    private RecyclerView hotelListRecyclerView;

    private FloatingActionButton sendBulkDataFloatingButton;
    private FloatingActionButton addFloatingButton;
    private TextView emptyTextView;

    /* Content objects */
    private List<Hotel> hotelList;

    /* Repository reference */
    private HotelsFirestoreManager hotelsFirestoreManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_list_main_activity);

        // Get a reference of ContactsFirestoreManager
        hotelsFirestoreManager = HotelsFirestoreManager.newInstance();

        // Get a reference of contactsFirestoreManager
        // TODO: 3.1 Getting the Backend Reference

        // Set up the toolbar
       // toolbar = findViewById(R.id.toolbar);
       // toolbar.setTitle(getString(R.string.app_alias));
//        setSupportActionBar(toolbar);

        // Set up the contactListRecyclerView
        hotelListRecyclerView = findViewById(R.id.hotelListRecyclerView);
        hotelListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Set up the emptyTextView
        //emptyTextView = findViewById(R.id.emptyTextView);

        // Set up the sendBulkDataFloatingButton
        sendBulkDataFloatingButton = findViewById(R.id.sendBulkDataFloatingButton);
        sendBulkDataFloatingButton.setOnClickListener(new com.corporatemailinglist.screens.hotellist.HotelListMainActivity.SendHotelsBulkFloatingButtonOnClickListener());

        // Set up the addFloatingButton
        addFloatingButton = findViewById(R.id.addFloatingButton);
        addFloatingButton.setOnClickListener(new com.corporatemailinglist.screens.hotellist.HotelListMainActivity.AddFloatingButtonOnClickListener());
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Populate the HotelListMainActivity with the available data
        // TODO: 3.3 Reading Contacts

        // Populate the ContactListMainActivity with the available data
        hotelsFirestoreManager.getAllHotels(new com.corporatemailinglist.screens.hotellist.HotelListMainActivity.GetAllHotelsOnCompleteListener());
    }

    private class GetAllHotelsOnCompleteListener implements OnCompleteListener<QuerySnapshot> {


        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {

            if (task.isSuccessful()) {

                // Get the query snapshot from the task result
                QuerySnapshot querySnapshot = task.getResult();

                if (querySnapshot != null) {

                    // Get the contact list from the query snapshot
                    hotelList = querySnapshot.toObjects(Hotel.class);
                    populateHotelRecyclerView(hotelList);
                }

            } else {
                Log.w(TAG, "Error getting documents: ", task.getException());
            }


        }


    }


//    Uncomment this class...
//    private class GetAllContactsOnCompleteListener implements OnCompleteListener<QuerySnapshot> {
//
//        @Override
//        public void onComplete(@NonNull Task<QuerySnapshot> task) {
//
//            // TODO: 3.3 Reading Contacts
//
//            // TODO 3.4 Populating the Main Screen
//
//            // If the contactList is empty, show the emptyTextView. Otherwise, show the contactListRecyclerView
//            if (contactList == null || contactList.size() == 0) {
//                contactListRecyclerView.setVisibility(View.GONE);
//                emptyTextView.setVisibility(View.VISIBLE);
//
//            } else {
//                contactListRecyclerView.setVisibility(View.VISIBLE);
//                emptyTextView.setVisibility(View.GONE);
//            }
//        }
//    }

    /** Sets the contact List in the Adapter to populate the RecyclerView */
    private void populateHotelRecyclerView(List<Hotel> contactList) {

        // TODO: 3.4 Populating the Main Screen


        // Set the contactListMainRecyclerViewAdapter in the contactListRecyclerView
        HotelListMainRecyclerViewAdapter hotelListMainRecyclerViewAdapter = new HotelListMainRecyclerViewAdapter(hotelList, new com.corporatemailinglist.screens.hotellist.HotelListMainActivity.HotelListRecyclerViewOnItemClickListener());
        hotelListRecyclerView.setAdapter(hotelListMainRecyclerViewAdapter);
    }

    /** Called when the user clicks on an item of the contact list */
    public class HotelListRecyclerViewOnItemClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            int itemIndex = hotelListRecyclerView.indexOfChild(view);
            Log.d("HotelListMainActivity", "" + itemIndex);

            Hotel hotel = hotelList.get(itemIndex);

            Intent intent = new Intent();
            intent.setClass(com.corporatemailinglist.screens.hotellist.HotelListMainActivity.this, HotelDetailsActivity.class);
            intent.putExtra(HotelDetailsActivity.OPERATION, HotelDetailsActivity.EDITING);

            // TODO: 4.2 Updating a Contact

            startActivity(intent);
        }
    }

    /** Called when the user clicks the Send Contacts button */
    private class SendHotelsBulkFloatingButtonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // TODO: 3.2 Sending Bulk Data to Firestore

            hotelsFirestoreManager.sendHotelsBulk();

            Toast.makeText(com.corporatemailinglist.screens.hotellist.HotelListMainActivity.this, "Contacts bulk sent", Toast.LENGTH_LONG).show();
        }
    }

    /** Called when the user clicks the Add button */
    private class AddFloatingButtonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            Intent intent = new Intent();
            intent.setClass(com.corporatemailinglist.screens.hotellist.HotelListMainActivity.this, HotelDetailsActivity.class);
            intent.putExtra(HotelDetailsActivity.OPERATION, HotelDetailsActivity.CREATING);

            startActivity(intent);
        }
    }
}

