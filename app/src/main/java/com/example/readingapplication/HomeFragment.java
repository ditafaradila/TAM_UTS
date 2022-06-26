package com.example.readingapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.readingapplication.API.ApiInterface;
import com.example.readingapplication.API.ApiRetrofit;
import com.example.readingapplication.API.Story;
import com.example.readingapplication.API.Wattpad;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        requestBook();
    }
    private void requestBook() {
        Call< Wattpad > storyCall = ApiRetrofit.request().getStory();
        storyCall.enqueue(new Callback< Wattpad >() {
            @Override
            public void onResponse(Call< Wattpad > call, Response< Wattpad > response) {
                if (response.isSuccessful()){
                    AdapterStory adapterStory = new AdapterStory(response.body(), requireActivity());
                    recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
                    recyclerView.setAdapter(adapterStory);
                }
            }

            @Override
            public void onFailure(Call< Wattpad > call, Throwable t) {

            }
        });
    }
}