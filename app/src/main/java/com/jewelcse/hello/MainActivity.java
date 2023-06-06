package com.jewelcse.hello;

import android.content.Intent;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView profileImageView;


    private TextView firstNameTextView, lastNameTextView, emailTextView, departmentTextView, sessionTextView, mobileTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameTextView = findViewById(R.id.firstNameTextView);
        lastNameTextView = findViewById(R.id.lastNameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        departmentTextView = findViewById(R.id.departmentTextView);
        sessionTextView = findViewById(R.id.sessionTextView);
        mobileTextView = findViewById(R.id.mobileTextView);
        profileImageView = findViewById(R.id.profileImageView);



        // Retrieve the user profile data from an API or any other data source
        String firstName = "John";
        String lastName = "Doe";
        String email = "johndoe@example.com";
        String department = "Engineering";
        String session = "2021-2022";
        String mobileNumber = "+1234567890";

        // Set the retrieved data to the respective TextViews
        firstNameTextView.setText("First Name: " + firstName);
        lastNameTextView.setText("Last Name: " + lastName);
        emailTextView.setText("Email: " + email);
        departmentTextView.setText("Department: " + department);
        sessionTextView.setText("Session: " + session);
        mobileTextView.setText("Mobile Number: " + mobileNumber);

        profileImageView.setImageResource(R.drawable.profile_photo);

    }

}