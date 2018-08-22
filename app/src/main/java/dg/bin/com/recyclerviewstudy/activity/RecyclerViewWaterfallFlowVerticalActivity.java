package dg.bin.com.recyclerviewstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import dg.bin.com.recyclerviewstudy.R;
import dg.bin.com.recyclerviewstudy.adapter.VerticalAdapter;

public class RecyclerViewWaterfallFlowVerticalActivity extends AppCompatActivity {

    RecyclerView mRecyclerViewVitical;

    List<String> mList;

    VerticalAdapter mVerticalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_waterfall_flow_vertical);

        initData();

        initView();
    }

    private void initView() {
        mRecyclerViewVitical = findViewById(R.id.rv_vertical);
        StaggeredGridLayoutManager mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerViewVitical.setLayoutManager(mStaggeredGridLayoutManager);

        mVerticalAdapter = new VerticalAdapter(this, mList);
        mRecyclerViewVitical.setAdapter(mVerticalAdapter);
    }

    private void initData() {
        mList = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            mList.add(i+"");
        }
    }
}
