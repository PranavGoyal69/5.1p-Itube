package com.example.itube;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Show login fragment by default
        if (savedInstanceState == null) {
            showLoginFragment();
        }
    }

    private void showLoginFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new LoginFragment())
                .commit();
    }

    public void navigateToHomeScreen() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();
    }
}
