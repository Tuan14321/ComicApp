package com.example.comicapp.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comicapp.R;
import com.example.comicapp.object.ViewChap;

import java.util.List;

public class ViewChapViewHolder extends RecyclerView.ViewHolder{

    private ImageView imgViewChap;
    private Context context;
    private List<ViewChap> viewChapListList;

    public void setViewChapList(List<ViewChap> viewChapList) {
        this.viewChapListList = viewChapListList;
    }
    private void BindingView(){
        imgViewChap = itemView.findViewById(R.id.imgChaps);
    }

    private void BindingAction(){

    }

    public void setViewChap(ViewChap c, Context context) {
        Glide.with(context).load(c.getImgViewChap()).into(imgViewChap);
    }
    public ViewChapViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        BindingView();
        BindingAction();
    }
}
