package com.example.readingapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CreateFragment extends Fragment implements View.OnClickListener{


    public CreateFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_create, container, false);
    }

    @Override
    public void onClick(View view) {

    }
}