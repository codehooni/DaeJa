package com.app.daeja.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.daeja.Activity.Domain.History;
import com.app.daeja.Adapter.HistoryAdapter;
import com.app.daeja.R;

import java.util.ArrayList;

public class HistroyFragment extends Fragment {
    private View view;
    private Context ct;
    protected RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_histroy, container, false);
        ct = container.getContext();

        recyclerViewHistory();

        return view;
    }

    private void recyclerViewHistory() {
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(ct, LinearLayoutManager.VERTICAL, false);
        recyclerView = view.findViewById(R.id.view);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<History> historyArrayList = new ArrayList<>();

        historyArrayList.add(new History("서울시 공영", "단국대 소프트웨어관1"));
        historyArrayList.add(new History("구로디지털단지역", "단국대학교 인문관주차장"));
        historyArrayList.add(new History("가짜", "진짜"));
        historyArrayList.add(new History("무", "유"));
        historyArrayList.add(new History("무", "유"));

        adapter = new HistoryAdapter(historyArrayList);
        recyclerView.setAdapter(adapter);
    }

}
