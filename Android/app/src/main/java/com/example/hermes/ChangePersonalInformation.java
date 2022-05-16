package com.example.hermes;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.hermes.databinding.ActivityChangePersonalInformationBinding;

public class ChangePersonalInformation extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityChangePersonalInformationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChangePersonalInformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       /* setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_change_personal_information);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_change_personal_information);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();

        */


    }
    public void savePersonalInformation(View view){
        Intent intent = new Intent(this, SaveUpdates.class);
        startActivity(intent);
    }

    public void goBack(View view){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

}

