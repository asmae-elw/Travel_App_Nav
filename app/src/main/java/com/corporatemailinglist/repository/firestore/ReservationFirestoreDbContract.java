package com.corporatemailinglist.repository.firestore;

public final class ReservationFirestoreDbContract {

    // TODO: 2.2 Defining the Database Contract


        // Root collection name
        public static final String COLLECTION_NAME = "Reservation_form";

        // Document ID
        public static final String DOCUMENT_ID = "document_id";

        // Document field names
        public static final String FIELD_DATE_DEBUT = "date_debut";
        public static final String FIELD_DATE_FIN = "date_fin";
        public static final String FIELD_HEURE_DEBUT = "heure_debut";
        public static final String FIELD_HEURE_FIN = "heure_fin";
        public static final String FIELD_PRIX = "prix";

        // To prevent someone from accidentally instantiating the contract class, make the constructor private
        private ReservationFirestoreDbContract() {}

}
