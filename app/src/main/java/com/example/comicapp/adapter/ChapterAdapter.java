package com.example.comicapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comicapp.R;
import com.example.comicapp.object.Chapter;
import com.example.comicapp.object.Comic;
import com.example.comicapp.viewholder.ChapterViewHolder;
import com.example.comicapp.viewholder.ComicViewHolder;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterViewHolder> {
    private Context context;
    private List<Chapter> chapterList;
    private LayoutInflater inflater;

    public ChapterAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDataChap(List<Chapter> list){
        this.chapterList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_chapter, parent, false);

        return new ChapterViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewHolder holder, int position) {
        Chapter c = chapterList.get(position);
        if(c == null){
            return;
        }
        holder.setChapter(c, this.context);
    }

    @Override
    public int getItemCount() {
        if (chapterList != null) {
            return chapterList.size();
        }
        return 0;
    }
}
