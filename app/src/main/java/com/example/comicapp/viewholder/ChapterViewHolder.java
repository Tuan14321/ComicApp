package com.example.comicapp.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comicapp.R;
import com.example.comicapp.object.Chapter;
import com.example.comicapp.object.Comic;

public class ChapterViewHolder extends RecyclerView.ViewHolder {
    private TextView tvChapName;
    private TextView tvDatePost;




    private void BindingView(){
     tvChapName = itemView.findViewById(R.id.tvChapName);
     tvDatePost = itemView.findViewById(R.id.tvDatePost);
    }

    private void BindingAction(){

    }

    public void setChapter(Chapter c, Context context){
        tvChapName.setText(c.getChapterName());
        tvDatePost.setText(c.getDatePost());
    }
    public ChapterViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        BindingView();
        BindingAction();
    }
}
