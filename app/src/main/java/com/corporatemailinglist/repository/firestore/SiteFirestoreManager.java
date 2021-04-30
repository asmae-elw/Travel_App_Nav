package com.corporatemailinglist.repository.firestore;


import com.corporatemailinglist.repository.datamodels.Site;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


public class SiteFirestoreManager {


    private static final String COLLECTION_NAME = "Site";
    /* ContactsFirestoreManager object **/
    private static SiteFirestoreManager hotelsFirestoreManager;
    /* Firestore objects */
    private FirebaseFirestore firebaseFirestore;
    private CollectionReference hotelsCollectionReference;

    public static SiteFirestoreManager newInstance() {
        if (hotelsFirestoreManager == null) {
            hotelsFirestoreManager = new SiteFirestoreManager();
        }
        return hotelsFirestoreManager;
    }

    private SiteFirestoreManager() {
        firebaseFirestore = FirebaseFirestore.getInstance();
        hotelsCollectionReference = firebaseFirestore.collection(COLLECTION_NAME);
    }

    public void createDocument(Site site) {
        hotelsCollectionReference.add(site);
    }


    public void getAllHotels(OnCompleteListener<QuerySnapshot> onCompleteListener)
    {
        hotelsCollectionReference.get().addOnCompleteListener(onCompleteListener);
    }


    public void updateHotel(Site site) {
        String documentId = site.getDocumentId();
        DocumentReference documentReference = hotelsCollectionReference.document(documentId);
        documentReference.set(site);
    }

    public void deleteHotel(String documentId) {
        DocumentReference documentReference = hotelsCollectionReference.document(documentId);
        documentReference.delete();
    }

    public void sendHotelsBulk() {

        // Create a new Contact document map of values and add it to the collection
        createDocument(new Site("Place Jemaa el-Fna", "marrakech", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTD1bj431krUF0ZQArv_vkbxWtOAO2nMYYYP6z3vgW_ch8TOk6QJ9JYkBs2snK6JJ-duPjTJbVk6fThnNKTcDGkww"));

        // Create a new Contact document map of values and add it to the collection
        createDocument(new Site("Palais de la Bahia", "marrakech", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSzUBfhw3iu1WzqrIJnaB6I3ZJRyW6n6kmWrm-lRBX_BbLU_lzqTpDvk93bSMT7WBt2v4OBXYPFi11jVbfbitPCkA"));

        // Create a new Contact document map of values and add it to the collection
        createDocument(new Site("Palais El Badii", "marrakech", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT46dcw5hjoXuhPE8pf88ZW_OBlqDP2ofoBw_uHnfYamyBeZRCN5BtNDpMaxxKEMPzqbsLHBy2X6a83CAwQfEFp3w"));

        // Create a new Contact document map of values and add it to the collection
        createDocument(new Site("Les jardins de la Ménara", "marrakech", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcR7TqtFt_PKNb-tJye4yiydZwRqoLRyDJLXhprb_a55bGfWk6IThPb8x-_By13vECAd8g9liUwDpyc-O3SXKkJXoA"));
    }


}
