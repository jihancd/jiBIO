package com.jihan.jibio.teman;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.jihan.jibio.R;
import com.jihan.jibio.User;

import java.util.List;


public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.ViewHolder> {

    private List<User> mDataSet;
    private TemanFragment.TemanListener listener;

    public TemanAdapter(List<User> mDataSet, TemanFragment.TemanListener listener) {
        this.mDataSet = mDataSet;
        Log.d("cek", "TemanAdapter: "+mDataSet.size());
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teman,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindItem(mDataSet.get(position),listener, position);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        ImageView btnDelete;
        ImageView btnCalling;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.item_friend_nama);
            btnDelete = itemView.findViewById(R.id.btn_friend_delete);
            btnCalling = itemView.findViewById(R.id.btnPhone);
        }

        void bindItem(final User user, final TemanFragment.TemanListener listener, final int position){
            tvName.setText(user.getUsername());
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { listener.onBtnDeleteClick(user);}
            });

            btnCalling.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { listener.onBtnCallClick(user);}
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { listener.onTemanClick(mDataSet, user, position);}
            });


        }

    }
}
