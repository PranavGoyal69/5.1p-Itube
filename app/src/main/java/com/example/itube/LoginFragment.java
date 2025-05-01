package com.example.itube;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LoginFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        view.findViewById(R.id.btnLogin).setOnClickListener(v -> {
            // Validate credentials
            ((MainActivity)requireActivity()).navigateToHomeScreen();
        });

        view.findViewById(R.id.btnGoToSignUp).setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new SignUpFragment())
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}