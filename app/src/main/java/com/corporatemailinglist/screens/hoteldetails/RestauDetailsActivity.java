package com.corporatemailinglist.screens.hoteldetails;

import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.corporatemailinglist.repository.firestore.HotelsFirestoreManager;
import com.corporatemailinglist.repository.firestore.RestauFirestoreManager;

public class RestauDetailsActivity extends AppCompatActivity {

    /* Constants to define the database operation type */
    public static final String OPERATION = "OPERATION";
    public static final String CREATING = "CREATING";
    public static final String EDITING = "EDITING";

    private String operationTypeString;

    /* Repository reference */
    private RestauFirestoreManager hotelsFirestoreManager;

    /* Document ID of this particular Hotel item */
    private String documentId;

    // Widgets
    private EditText Nom_hotelEditText;
    private EditText Nom_villeEditText;
    private EditText ImageURLText;

    private Button deleteButton;
    private Button okButton;
/*
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_form_activity);

        // Get a reference of contactsFirestoreManager
        // TODO: 4.1 Creating a Contact

        Nom_hotelEditText = findViewById(R.id.Nom_hotelEditText);
        Nom_villeEditText = findViewById(R.id.Nom_villeEditText);
        ImageURLText = findViewById(R.id.ImageURLText);

        deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new DeleteButtonOnClickListener());

        okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(new OKButtonOnClickListener());

        // Get the extras from the Intent
        Bundle bundle = getIntent().getExtras();

        operationTypeString = bundle.getString(OPERATION);
        if (operationTypeString.equals(CREATING)) {
            okButton.setText("CREATE");
            deleteButton.setVisibility(View.GONE);

        } else if (operationTypeString.equals(EDITING)) {
            okButton.setText("UPDATE");
            deleteButton.setVisibility(View.VISIBLE);

            // TODO: 4.2 Updating a Contact
        }
    }

    private class OKButtonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            String firstNameString = firstNameEditText.getText().toString();
            String lastNameString = lastNameEditText.getText().toString();
            String emailString = emailEditText.getText().toString();

            // Contact contact = new Contact(documentId, firstNameString, lastNameString, emailString);

            if (operationTypeString.equals(CREATING)) {
                // TODO: 4.1 Creating a Contact

            } else if (operationTypeString.equals(EDITING)) {
                // TODO: 4.2 Updating a Contact
            }

            finish();
        }
    }

    private class DeleteButtonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            // TODO: 4.3 Deleting a Contact

            finish();
        }*/
}

