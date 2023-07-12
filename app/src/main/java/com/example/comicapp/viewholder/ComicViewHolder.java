package com.example.comicapp.viewholder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comicapp.ChapActivity;
import com.example.comicapp.R;
import com.example.comicapp.adapter.ComicAdapter;
import com.example.comicapp.object.Comic;

import java.io.Serializable;
import java.util.List;

public class ComicViewHolder extends RecyclerView.ViewHolder {
    private String ComicId;
     private ImageView comicImage;
     private TextView tvComicName;
     private TextView tvChaptername;
    private Context context;
    private List<Comic> comicList;

    public void setComicList(List<Comic> comicList) {
        this.comicList = comicList;
    }


    private void BindingView(){
         comicImage = itemView.findViewById(R.id.ComicImage);
         tvComicName = itemView.findViewById(R.id.tvComicName);
         tvChaptername = itemView.findViewById(R.id.tvChapterName);
     }

     private void BindingAction(){
         comicImage.setOnClickListener(this::onComicImageClick);
     }

    private void onComicImageClick(View view) {
        int position = getAdapterPosition();
        if (position != RecyclerView.NO_POSITION && comicList != null && position < comicList.size()) {
            Comic comic = comicList.get(position);
            // Tạo Intent để chuyển đến layout mới
            Intent intent = new Intent(context, ChapActivity.class);
            // Truyền thông tin truyện tranh qua Intent (nếu cần thiết)
            intent.putExtra("comic", comic);
            // Thực hiện chuyển đổi đến layout mới
            context.startActivity(intent);
        }
    }

    public void setComic(Comic c, Context context){
        ComicId = c.getComicId();
        tvComicName.setText(c.getComicName());
        tvChaptername.setText(c.getChapterName());
        Glide.with(context).load(c.getImageLink()).into(comicImage);
    }

    public ComicViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        BindingView();
        BindingAction();
    }

}
