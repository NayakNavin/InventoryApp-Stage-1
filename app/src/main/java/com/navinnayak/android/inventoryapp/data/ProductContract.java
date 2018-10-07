package com.navinnayak.android.inventoryapp.data;

import android.provider.BaseColumns;

public final class ProductContract {

    private ProductContract() {
    }

    /**
     * Inner class that defines constant values for the productss database table.
     * Each entry in the table represents a single products.
     */
    public static final class ProductEntry implements BaseColumns {

        /**
         * Name of database table for products
         */
        public final static String TABLE_NAME = "products";

        /**
         * Unique ID number for the products (only for use in the database table).
         * <p>
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the product.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_PRODUCT_NAME = "product_name";

        /**
         * Price of the product.
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_PRICE = "price";

        /**
         * Quantity of the product.
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_QUANTITY = "quantity";

        /**
         * Supplier Name of the product.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_SUPPLIER_NAME = "supplier_name";

        /**
         * Supplier Phone Number of the product.
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_PHONE_NUMBER = "supplier_phone_number";
    }
}