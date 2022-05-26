package com.example.hermes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.hermes.databinding.ActivitySaveUpdatesBinding;

public class SaveUpdates extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySaveUpdatesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySaveUpdatesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_save_updates2);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void savePersonalInformation(View view) {
        Intent intent = new Intent(this, ChangePersonalInformation.class);
        startActivity(intent);
    }

    public void goBack(View view){
        Intent intent = new Intent(this, ChangePersonalInformation.class);
        startActivity(intent);
    }
}