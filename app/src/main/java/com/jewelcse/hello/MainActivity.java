package com.jewelcse.hello;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText inputEditText;
    private Button saveButton;
    private ListView dataListView;
    private List<String> dataList;
    private ArrayAdapter<String> dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        saveButton = findViewById(R.id.saveButton);
        dataListView = findViewById(R.id.dataListView);

        dataList = new ArrayList<>();
        dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        dataListView.setAdapter(dataAdapter);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputEditText.getText().toString().trim();
                if (!input.isEmpty()) {
                    dataList.add(input);
                    dataAdapter.notifyDataSetChanged();
                    inputEditText.getText().clear();
                }
            }
        });
    }
}