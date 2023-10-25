package com.example.masterchef;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.masterchef.My_Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Home_Fragment extends Fragment {
    private RecyclerView recyclerView;
    private My_Adapter adapter;
    private List<Mydata> listMonan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        listMonan = new ArrayList<>(); // Tạo danh sách món ăn

        // Thêm dữ liệu mẫu vào danh sách món ăn
        listMonan.add(new Mydata("hello", "https://cdnimg.vietnamplus.vn/t620/uploaded/hotnnz/2020_04_28/bun_rieu_2.jpg"));
        listMonan.add(new Mydata("hello", "android.resource://com.example.masterchef/R.drawable.monchien"));
        listMonan.add(new Mydata("hello", "android.resource://com.example.masterchef/R.drawable.monchien"));

        adapter = new My_Adapter(listMonan);
        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}