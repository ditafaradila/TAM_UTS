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

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    static String jd1 = "Her World";
    static String jd2 = "Kita";
    static String jd3 = "Kita Bicarakan Tentang Luka";
    static String jd4 = "Antariksa";
    static String jd5 = "97Line";
    static String jd6 = "Rosie";
    static String jd7 = "Dinding";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerViewAdapter recyclerViewAdapter;
        RecyclerView recyclerView;
        ArrayList<DataBuku> dataItems;

        recyclerView = view.findViewById(R.id.recyclerView);
        dataItems = new ArrayList<>();


        dataItems.add(new DataBuku(R.drawable.cv1, jd1, "Rosemunk", "20 Oktober 2021"));
        dataItems.add(new DataBuku(R.drawable.cv2, jd2, "Markohun", "12 September 2019"));
        dataItems.add(new DataBuku(R.drawable.cv3, jd3, "Farahqueen", "20 Maret 2019"));
        dataItems.add(new DataBuku(R.drawable.cv5, jd4, "Lala", "14 Januari 2016"));
        dataItems.add(new DataBuku(R.drawable.cv6, jd5, "Xmun", "18 Juni 2020"));
        dataItems.add(new DataBuku(R.drawable.cv7, jd6, "Jeprix", "14 Mei 2019"));
        dataItems.add(new DataBuku(R.drawable.cv8, jd7, "Bingkasa", "25 April 2015"));

        recyclerViewAdapter = new RecyclerViewAdapter(dataItems, getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}