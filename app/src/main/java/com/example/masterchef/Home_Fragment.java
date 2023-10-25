package com.example.masterchef;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.masterchef.My_Adapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search, menu);
        super.onCreateOptionsMenu(menu, inflater);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        // Xử lý sự kiện tìm kiếm
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Xử lý khi người dùng nhấn Enter hoặc nút tìm kiếm
                // Thực hiện tìm kiếm dữ liệu ứng với query
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Xử lý khi người dùng thay đổi nội dung của ô tìm kiếm
                // Cập nhật danh sách hiển thị dựa trên newText
                return true;
            }
        });
    }
}