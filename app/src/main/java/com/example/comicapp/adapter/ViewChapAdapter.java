package com.example.comicapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comicapp.R;
import com.example.comicapp.object.Chapter;
import com.example.comicapp.object.ViewChap;
import com.example.comicapp.viewholder.ChapterViewHolder;
import com.example.comicapp.viewholder.ComicViewHolder;
import com.example.comicapp.viewholder.ViewChapViewHolder;

import java.util.List;

public class ViewChapAdapter extends RecyclerView.Adapter<ViewChapViewHolder>{

    private Context context;
    private List<ViewChap> viewChapList;
    private LayoutInflater inflater;

    public ViewChapAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDataViewChap(List<ViewChap> list){
        this.viewChapList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewChapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_chapter, parent, false);
        return new ViewChapViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewChapViewHolder holder, int position) {
        ViewChap c = viewChapList.get(position);
        if(c == null){
            return;
        }
        holder.setViewChap(c, this.context);
    }

    @Override
    public int getItemCount() {
        if (viewChapList != null) {
            return viewChapList.size();
        }
        return 0;
    }
}
