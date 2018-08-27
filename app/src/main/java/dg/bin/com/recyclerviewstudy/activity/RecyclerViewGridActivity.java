package dg.bin.com.recyclerviewstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dg.bin.com.recyclerviewstudy.GridDividerItemDecoration;
import dg.bin.com.recyclerviewstudy.R;
import dg.bin.com.recyclerviewstudy.adapter.GridAdapter;
import dg.bin.com.recyclerviewstudy.adapter.LinearHorizontalAdapter;
import dg.bin.com.recyclerviewstudy.adapter.LinearVerticalAdapter;

public class RecyclerViewGridActivity extends AppCompatActivity {

    RecyclerView mRecyclerViewVitical;

    List<String> mList;

    GridAdapter mGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_horizontal);

        initData();

        initView();
    }

    private void initView() {
        mRecyclerViewVitical = findViewById(R.id.rv_vertical);
        recyclerViewShow();
        addDividerItemDecoration();
    }

    //recyclerView基本展示
    private void recyclerViewShow(){
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerViewVitical.setLayoutManager(mGridLayoutManager);

        mGridAdapter = new GridAdapter(this, mList);
        mRecyclerViewVitical.setAdapter(mGridAdapter);
    }

    private void addDividerItemDecoration(){
        //自定义
        mRecyclerViewVitical.addItemDecoration(new GridDividerItemDecoration(this));
    }

    private void initData() {
        mList = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            mList.add(i+"");
        }
    }
}
