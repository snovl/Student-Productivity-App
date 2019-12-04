package com.example.cpsc471app.ui.school;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.cpsc471app.R;

public class SchoolFragment extends Fragment {

    private SchoolViewModel schoolViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        schoolViewModel =
                ViewModelProviders.of(this).get(SchoolViewModel.class);
        View root = inflater.inflate(R.layout.fragment_school, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        schoolViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}