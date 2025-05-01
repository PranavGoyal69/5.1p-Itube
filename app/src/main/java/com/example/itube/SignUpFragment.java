package com.example.itube;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
public class SignUpFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        EditText etFullName = view.findViewById(R.id.etFullName);
        EditText etUsername = view.findViewById(R.id.etUsername);
        // ... other fields

        view.findViewById(R.id.btnCreateAccount).setOnClickListener(v -> {
            // Validate inputs
            // Save to SharedPreferences or database
        });

        return view;
    }
}