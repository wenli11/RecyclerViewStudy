package dg.bin.com.recyclerviewstudy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dg.bin.com.recyclerviewstudy.R;
import dg.bin.com.recyclerviewstudy.adapter.MianAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView mMianRecyclerView;
    MianAdapter mMainAdapter;
    List<Map<String, String>> mList;
    private MianAdapter.OnItemClickListener onItemClickListener = new MianAdapter.OnItemClickListener() {
        @Override
        public void OnItemClickListener(int position) {
            switch (position){
                case 0:
                    goActivity(RecyclerViewVerticalActivity.class);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        mList = new ArrayList<>();

        Map<String, String> map = new ArrayMap<>();
        map.put("name", "普通-纵向");

        mList.add(map);
    }

    private void initView() {
        mMianRecyclerView = findViewById(R.id.mian_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mMianRecyclerView.setLayoutManager(linearLayoutManager);
        mMainAdapter = new MianAdapter(this, mList);
        mMainAdapter.setOnItemClickListener(onItemClickListener);
        mMianRecyclerView.setAdapter(mMainAdapter);
    }

    private void goActivity(Class<?> cla){
        Intent intent = new Intent(this, cla);
        startActivity(intent);
    }
}
