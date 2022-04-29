package com.example.readingapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class LibraryFragment extends Fragment implements View.OnClickListener {
    private Button Tambah;

    public LibraryFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_library, container, false);
    }

    @Override
    public void onClick(View view) {

    }
}