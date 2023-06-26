package com.example.comicapp.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comicapp.R;
import com.example.comicapp.object.Comic;

public class ComicViewHolder extends RecyclerView.ViewHolder {
     private ImageView comicImage;
     private TextView tvComicName;
     private TextView tvChaptername;

     private void BindingView(){
         comicImage = itemView.findViewById(R.id.ComicImage);
         tvComicName = itemView.findViewById(R.id.tvComicName);
         tvChaptername = itemView.findViewById(R.id.tvChapterName);
     }

     private void BindingAction(){

     }

    public void setComic(Comic c, Context context){
//        comicImage.setImageResource(c.getImageLink());
        tvComicName.setText(c.getComicName());
        tvChaptername.setText(c.getChapterName());
        Glide.with(context).load(c.getImageLink()).into(comicImage);
    }

    public ComicViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        BindingView();
        BindingAction();
    }
}
