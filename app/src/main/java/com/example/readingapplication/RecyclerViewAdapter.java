package com.example.readingapplication;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.KategoriViewHolder> {
    private List<DataBuku> dataItem;
    Context context;

    public RecyclerViewAdapter(List<DataBuku> dataItem, Context context){
        this.dataItem = dataItem;
        this.context = context;
    }

    @NonNull
    @Override
    public KategoriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //mengembangkan tata letak item dan mengembalikan ViewHolder dengan tata letak dan adapter
        return new KategoriViewHolder(
                //membaca deskripsi XML tata letak dan mengubahnya menjadi Viewitem yang sesuai
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_buku, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull final KategoriViewHolder holder, final int position) {
        //menghubungkan data ke view holder
        DataBuku dItem = dataItem.get(position);
        holder.textItem.setText(dItem.getJudul());
        holder.textItem2.setText(dItem.getPenulis());
        holder.textItem3.setText(dItem.getWaktu());
        holder.imageItem.setImageResource(dItem.getCover());

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(context, "Item no " + position, Toast.LENGTH_SHORT);
                t.setGravity(Gravity.CENTER,0,0);
                t.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        //mengembalikan ukuran dataItem
        return dataItem.size();
    }

    public static class KategoriViewHolder extends RecyclerView.ViewHolder{
        TextView textItem, textItem2, textItem3;
        ImageView imageItem;
        LinearLayout itemLayout;

        KategoriViewHolder(@NonNull View itemView) {
            super(itemView);
            textItem = itemView.findViewById(R.id.judul_buku);
            textItem2 = itemView.findViewById(R.id.penulis_buku);
            textItem3 = itemView.findViewById(R.id.waktu_buku);
            imageItem = itemView.findViewById(R.id.cover_buku);
            itemLayout = itemView.findViewById(R.id.itemLayout);
        }
    }
}
