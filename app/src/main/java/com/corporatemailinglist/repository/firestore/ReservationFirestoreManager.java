package com.corporatemailinglist.repository.firestore;


import com.corporatemailinglist.repository.datamodels.Reservation_form;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class ReservationFirestoreManager {
    private static final String COLLECTION_NAME = "Reservation_form";

    // TODO: 2.3 Creating a Database Manager


    private CollectionReference contactsCollectionReference;

    /* Firestore objects */
    private FirebaseFirestore firebaseFirestore;

    /* ContactsFirestoreManager object **/
    private static ReservationFirestoreManager contactsFirestoreManager;
    public static ReservationFirestoreManager newInstance() {
        if (contactsFirestoreManager == null) {
            contactsFirestoreManager = new ReservationFirestoreManager();
        }
        return contactsFirestoreManager;
    }

    private ReservationFirestoreManager() {
        firebaseFirestore = FirebaseFirestore.getInstance();
        contactsCollectionReference = firebaseFirestore.collection(COLLECTION_NAME);
    }

    public void createDocument(Reservation_form reservation_form) {
        contactsCollectionReference.add(reservation_form);
    }

    public void getAllContacts(OnCompleteListener<QuerySnapshot> onCompleteListener)
    {
        contactsCollectionReference.get().addOnCompleteListener(onCompleteListener);
    }

    public void updateContact(Reservation_form reservation_form) {
        String documentId = reservation_form.getDocumentId();
        DocumentReference documentReference = contactsCollectionReference.document(documentId);
        documentReference.set(reservation_form);
    }

    public void deleteContact(String documentId) {
        DocumentReference documentReference = contactsCollectionReference.document(documentId);
        documentReference.delete();
    }

    public void sendContactsBulk() {

        // Create a new Contact document map of values and add it to the collection
        createDocument(new Reservation_form(07/07/2019,2021-07-15, "08:00", "19:00", 1000));

        /* Create a new Contact document map of values and add it to the collection
        createDocument(new Reservation_form("Michael", "Johnson", "m_johnson@gmail.com"));

        // Create a new Contact document map of values and add it to the collection
        createDocument(new Reservation_form("Chris", "Stanley", "chrisstnl@gmail.com"));

        // Create a new Contact document map of values and add it to the collection
        createDocument(new Reservation_form("Jane", "Smith", "jsmith@gmail.com"));*/
    }


}
