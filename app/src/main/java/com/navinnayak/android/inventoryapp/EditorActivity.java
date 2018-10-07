package com.navinnayak.android.inventoryapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.navinnayak.android.inventoryapp.data.ProductContract.ProductEntry;
import com.navinnayak.android.inventoryapp.data.ProductDbHelper;

public class EditorActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mPriceEditText;
    private EditText mQuantityEditText;
    private EditText mSupplierNameEditText;
    private EditText mPhoneNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        mNameEditText = findViewById(R.id.product_name_edit_text);
        mPriceEditText = findViewById(R.id.product_price_edit_text);
        mQuantityEditText = findViewById(R.id.product_quantity_edit_text);
        mSupplierNameEditText = findViewById(R.id.product_supplier_name);
        mPhoneNumberEditText = findViewById(R.id.product_supplier_phone_number_edit_text);
    }

    private void insertProduct() {
        String productNameString = mNameEditText.getText().toString().trim();

        String productPriceString = mPriceEditText.getText().toString().trim();
        int productPriceInteger = Integer.parseInt(productPriceString);

        String productQuantityString = mQuantityEditText.getText().toString().trim();
        int productQuantityInteger = Integer.parseInt(productQuantityString);

        String productSupplierNameString = mSupplierNameEditText.getText().toString().trim();

        String productSupplierPhoneNumberString = mPhoneNumberEditText.getText().toString().trim();
        int productSupplierPhoneNumberInteger = Integer.parseInt(productSupplierPhoneNumberString);

        ProductDbHelper mDbHelper = new ProductDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ProductEntry.COLUMN_PRODUCT_NAME, productNameString);
        values.put(ProductEntry.COLUMN_PRICE, productPriceInteger);
        values.put(ProductEntry.COLUMN_QUANTITY, productQuantityInteger);
        values.put(ProductEntry.COLUMN_SUPPLIER_NAME, productSupplierNameString);
        values.put(ProductEntry.COLUMN_PHONE_NUMBER, productSupplierPhoneNumberInteger);

        long newRowId = db.insert(ProductEntry.TABLE_NAME, null, values);

        if (newRowId == -1) {
            Toast.makeText(this, "Error with saving product", Toast.LENGTH_SHORT).show();
            Log.d("Error message", "Doesn't insert row on table");

        } else {
            Toast.makeText(this, "Product saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
            Log.d("successfully message", "insert row on table");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                insertProduct();
                finish();

            case R.id.action_delete:
                // Do nothing for now
                return true;

            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}