package com.example.comicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.example.comicapp.adapter.ComicAdapter;
import com.example.comicapp.object.Comic;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvComic;

    private ComicAdapter comicAdapter;

    private void BindingView() {
        rcvComic = findViewById(R.id.comicList);
    }

    private void BindingAction() {

    }

    private List<Comic> getListComic() {
        List<Comic> list = new ArrayList<>();
        list.add(new Comic("VÕ LUYỆN ĐỈNH PHONG", "Chap 1", "https://st.nettruyenmax.com/data/comics/32/vo-luyen-dinh-phong.jpg"));
        list.add(new Comic("NHẤT KIẾM ĐỘC TÔN", "Chap 1", "https://st.nettruyenmax.com/data/comics/232/nhat-kiem-doc-ton.jpg"));
        list.add(new Comic("SIEU PHÀM TÍN HÓA", "Chap 1", "https://st.nettruyenmax.com/data/comics/103/sieu-pham-tien-hoa.jpg"));
        list.add(new Comic("KARATE SHOUKOUSHI KOHINATA MINORU", "Chap 1", "https://st.nettruyenmax.com/data/comics/115/karate-shoukoushi-kohinata-minoru.jpg"));
        list.add(new Comic("THẢNH THƠI THÚ THẾ CHỦNG CHỦNG ĐIỀN, SINH SINH TỂ", "Chap 1", "https://st.nettruyenmax.com/data/comics/153/thanh-thoi-thu-the-chung-chung-dien-sinh-2875.jpg"));
        list.add(new Comic("HỆT NHƯ HÀN QUANG GẶP NẮNG GẮT", "Chap 1", "https://st.nettruyenmax.com/data/comics/87/het-nhu-han-quang-gap-nang-gat.jpg"));
        list.add(new Comic("VNGƯỜI TRÊN VẠN NGƯỜI", "Chap 1", "https://www.nettruyenmax.com/truyen-tranh/nguoi-tren-van-nguoi-409120"));
        list.add(new Comic("TA KHÔNG MUỐN TRÙNG SINH ĐÂU", "Chap 1", "https://st.nettruyenmax.com/data/comics/249/ta-khong-muon-trung-sinh-dau.jpg"));
        list.add(new Comic("BIÊN KỊCH THIÊN TÀI", "Chap 1", "https://st.nettruyenmax.com/data/comics/67/bien-kich-thien-tai.jpg"));
        list.add(new Comic("VÕ ĐẠO ĐỘC TÔN", "Chap 1", "https://st.nettruyenmax.com/data/comics/228/vo-dao-doc-ton-7886.jpg"));
        return list;
    }

    private void initGridView(){
        comicAdapter = new ComicAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rcvComic.setLayoutManager(gridLayoutManager);
        comicAdapter.setData(getListComic());
        rcvComic.setAdapter(comicAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BindingView();
        BindingAction();
        initGridView();
    }
}