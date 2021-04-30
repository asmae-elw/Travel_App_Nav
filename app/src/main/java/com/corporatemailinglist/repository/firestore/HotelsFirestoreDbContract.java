package com.corporatemailinglist.repository.firestore;


public final class HotelsFirestoreDbContract {

    // Root collection name
    public static final String COLLECTION_NAME = "Hotel";

    // Document ID
    public static final String DOCUMENT_ID = "document_id";

    // Document field names
    public static final String FIELD_HOTEL_NAME = "nom_hotel";
    public static final String FIELD_CITY_NAME = "nom_ville";
    public static final String FIELD_IMAGE_URL = "imageURI";

    // To prevent someone from accidentally instantiating the contract class, make the constructor private
    private HotelsFirestoreDbContract() {}
}