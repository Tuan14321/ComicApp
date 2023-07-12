package com.example.comicapp.viewholder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comicapp.R;
import com.example.comicapp.ChapView;
import com.example.comicapp.object.Chapter;

import java.util.List;

public class ChapterViewHolder extends RecyclerView.ViewHolder {
    private String ChapterId;
    private TextView tvChapName;
    private TextView tvDatePost;
    private Context context;
    private List<Chapter> chapterList;

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    private void BindingView() {
        tvChapName = itemView.findViewById(R.id.tvChapName);
        tvDatePost = itemView.findViewById(R.id.tvDatePost);
    }

    private void BindingAction() {
        itemView.setOnClickListener(this::ItemViewClick);
    }
    private void ItemViewClick(View view) {
        int position = getAdapterPosition();
        if (position != RecyclerView.NO_POSITION && chapterList != null && position < chapterList.size()) {
            Chapter chapter = chapterList.get(position);
           //  Tạo Intent để chuyển đến layout mới
            Intent intent = new Intent(context, ChapView.class);
            // Truyền thông tin truyện tranh qua Intent (nếu cần thiết)
            intent.putExtra("chapter", chapter);
            // Thực hiện chuyển đổi đến layout mới
            context.startActivity(intent);
        }else{
            Toast.makeText(context, "fail" + chapterList.size(), Toast.LENGTH_SHORT).show();
        }
    }

    public void setChapter(Chapter c, Context context) {
        ChapterId = c.getChapId();
        tvChapName.setText(c.getChapterName());
        tvDatePost.setText(c.getDatePost());
    }

    public ChapterViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        BindingView();
        BindingAction();
    }
}
