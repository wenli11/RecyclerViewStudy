package dg.bin.com.recyclerviewstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import dg.bin.com.recyclerviewstudy.GridDividerItemDecoration;
import dg.bin.com.recyclerviewstudy.LinearDividerItemDecoration;
import dg.bin.com.recyclerviewstudy.R;
import dg.bin.com.recyclerviewstudy.adapter.LinearVerticalAdapter;
import dg.bin.com.recyclerviewstudy.adapter.WaterfallFlowVerticalAdapter;

public class RecyclerViewWaterfallFlowVerticalActivity extends AppCompatActivity {

    RecyclerView mRecyclerViewVitical;

    List<String> mList;

    WaterfallFlowVerticalAdapter mWaterfallFlowVerticalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_waterfall_flow_vertical);

        initData();

        initView();
    }

    private void initView() {
        mRecyclerViewVitical = findViewById(R.id.rv_vertical);
        recyclerViewShow();
        addItenDecoration();
    }

    //recyclerView基本展示
    private void recyclerViewShow(){
        StaggeredGridLayoutManager mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerViewVitical.setLayoutManager(mStaggeredGridLayoutManager);

        mWaterfallFlowVerticalAdapter = new WaterfallFlowVerticalAdapter(this, mList);
        mRecyclerViewVitical.setAdapter(mWaterfallFlowVerticalAdapter);

        mRecyclerViewVitical.addItemDecoration(new GridDividerItemDecoration(this));
    }

    //设置分隔线
    private void addItenDecoration(){
        //系统默认
//        mRecyclerViewVitical.addItemDecoration( new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
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
