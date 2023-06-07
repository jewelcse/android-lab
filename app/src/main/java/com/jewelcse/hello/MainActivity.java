package com.jewelcse.hello;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.*;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.jewelcse.hello.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import com.jewelcse.hello.db.Cart;
import com.jewelcse.hello.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText inputEditText;
    private Button saveButton;
    private List<Cart> dataListView;
    private ArrayAdapter<Cart> dataAdapter;


    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        saveButton = findViewById(R.id.saveButton);
        dataListView = findViewById(R.id.dataListView);


        databaseHelper = new DatabaseHelper(this);

        dataListView.setAdapter(dataAdapter);

        dataListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataModel data = dataList.get(position);
                deleteRecord(data.getId());
            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputEditText.getText().toString().trim();
                if (!input.isEmpty()) {
                    // Save the record in the in-memory database
                    saveRecord(input);

                    // Refresh the list view
                    refreshListView();

                    // Clear the input field
                    inputEditText.getText().clear();
                }
            }
        });
        checkExistingRecords();

    }

    public void onDeleteButtonClick(View view) {
        int position = dataListView.getPositionForView(view);
        deleteRecord(position);
    }


    private void checkExistingRecords() {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            // There are existing records, so fetch and display them
            refreshListView();
        }

        cursor.close();
        db.close();
    }

    private void refreshListView() {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);

        dataList.clear();

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String data = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DATA));
                dataList.add(data);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        dataAdapter.notifyDataSetChanged();
    }

    private void deleteRecord(int position) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        // Get the ID of the record to be deleted from the position
        Cursor cursor = dataAdapter.getCursor();
        cursor.moveToPosition(position);
        int idIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_ID);
        int recordId = cursor.getInt(idIndex);

        String selection = DatabaseHelper.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(recordId)};
        int deletedRows = db.delete(DatabaseHelper.TABLE_NAME, selection, selectionArgs);
        if (deletedRows > 0) {
            Toast.makeText(this, "Record deleted successfully", Toast.LENGTH_SHORT).show();
            refreshListView();
        } else {
            Toast.makeText(this, "Failed to delete record", Toast.LENGTH_SHORT).show();
        }
        cursor.close();
        db.close();
    }

    private void saveRecord(String input) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_DATA, input);
        long newRowId = db.insert(DatabaseHelper.TABLE_NAME, null, values);
        if (newRowId != -1) {
            Toast.makeText(this, "Record saved successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to save record", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

}