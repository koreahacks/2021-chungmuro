package com.example.budd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder>{
    Context context;
    ArrayList<Diary> items = new ArrayList<Diary>();

    public SearchResultAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public Diary getItem(int p){
        return items.get(p);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.search_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Diary item = items.get(position);
        holder.setItem(item);

        holder.setOnItemClickListener(listener);
    }

    public void addItem(Diary item){
        items.add(item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_username;
        TextView txt_date;
        TextView txt_title;
        OnItemClickListener listener;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //search_item.xml
            txt_username = itemView.findViewById(R.id.txt_username);
            txt_date = itemView.findViewById(R.id.txt_date);
            txt_title = itemView.findViewById(R.id.txt_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, v, position);
                    }
                }
            });
        }

        public void setItem(Diary item){
            txt_username.setText("From. "+item.writer);
            txt_date.setText(item.date);
            txt_title.setText(item.title);
        }

        public void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }
    }

    OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public static interface OnItemClickListener{
        public void onItemClick(ViewHolder holder, View view, int position);
    }
}
