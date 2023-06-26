package com.example.comicapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comicapp.MainActivity;
import com.example.comicapp.R;
import com.example.comicapp.object.Comic;
import com.example.comicapp.viewholder.ComicViewHolder;

import java.util.List;

public class ComicAdapter extends RecyclerView.Adapter<ComicViewHolder> {

    private Context context;
    private List<Comic> comicList;
    private LayoutInflater inflater;

    public ComicAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<Comic> list){
        this.comicList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ComicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_comic, parent, false);

        return new ComicViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicViewHolder holder, int position) {
        Comic c = comicList.get(position);
        if(c == null){
            return;
        }
        holder.setComic(c, this.context);
    }

    @Override
    public int getItemCount() {
        if (comicList != null) {
            return comicList.size();
        }
        return 0;
    }
}
