package com.corporatemailinglist.repository.firestore;


import com.corporatemailinglist.repository.datamodels.Restau;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


public class  RestauFirestoreManager {


    private static final String COLLECTION_NAME = "Restau";
    /* ContactsFirestoreManager object **/
    private static RestauFirestoreManager hotelsFirestoreManager;
    /* Firestore objects */
    private FirebaseFirestore firebaseFirestore;
    private CollectionReference hotelsCollectionReference;

    public static RestauFirestoreManager newInstance() {
        if (hotelsFirestoreManager == null) {
            hotelsFirestoreManager = new RestauFirestoreManager();
        }
        return hotelsFirestoreManager;
    }

    private RestauFirestoreManager() {
        firebaseFirestore = FirebaseFirestore.getInstance();
        hotelsCollectionReference = firebaseFirestore.collection(COLLECTION_NAME);
    }

    public void createDocument(Restau restau) {
        hotelsCollectionReference.add(restau);
    }


    public void getAllHotels(OnCompleteListener<QuerySnapshot> onCompleteListener)
    {
        hotelsCollectionReference.get().addOnCompleteListener(onCompleteListener);
    }


    public void updateHotel(Restau restau) {
        String documentId = restau.getDocumentId();
        DocumentReference documentReference = hotelsCollectionReference.document(documentId);
        documentReference.set(restau);
    }

    public void deleteHotel(String documentId) {
        DocumentReference documentReference = hotelsCollectionReference.document(documentId);
        documentReference.delete();
    }

    public void sendHotelsBulk() {

        // Create a new Contact document map of values and add it to the collection
        createDocument(new Restau(" Âme et Saveurs", "marrakech", "https://media-cdn.tripadvisor.com/media/photo-s/18/0a/d3/35/restaurant-sur-4-terrasses.jpg"));

        // Create a new Contact document map of values and add it to the collection
        createDocument(new Restau("Cuisine De Terroir", "marrakech", "https://media-cdn.tripadvisor.com/media/photo-p/14/85/13/a9/cuisine-de-terroir.jpg"));

        // Create a new Contact document map of values and add it to the collection
        createDocument(new Restau("VITA NOVA", "marrakech", "https://media-cdn.tripadvisor.com/media/photo-s/16/ba/3e/e7/esterno.jpg"));

        // Create a new Contact document map of values and add it to the collection
        createDocument(new Restau("La cuisine de mona", "marrakech", "https://media-cdn.tripadvisor.com/media/photo-s/08/2f/09/79/la-cuisine-de-mona.jpg"));
    }


}
