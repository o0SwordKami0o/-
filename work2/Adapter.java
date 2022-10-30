package com.example.work2;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.myviewholder> {

    private List<String> list;
    private Context context;
    private View inflater;

    public Adapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public myviewholder onCreateViewHolder(ViewGroup viewGroup, int i) {
        inflater = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        myviewholder myviewholder = new myviewholder(inflater);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(myviewholder myviewholder, int j) {
        myviewholder.textView.setText(list.get(j));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class myviewholder extends RecyclerView.ViewHolder{
        TextView textView;
        public myviewholder( View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView2);
        }
    }
}