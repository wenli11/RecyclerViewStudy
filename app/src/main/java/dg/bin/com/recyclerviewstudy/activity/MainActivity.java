package dg.bin.com.recyclerviewstudy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dg.bin.com.recyclerviewstudy.R;
import dg.bin.com.recyclerviewstudy.adapter.MianAdapter;
import dg.bin.com.recyclerviewstudy.model.RecyclerViewTypeListModel;
import dg.bin.com.recyclerviewstudy.model.RecyclerViewTypeModel;
import dg.bin.com.recyclerviewstudy.tools.ReadDataTool;

public class MainActivity extends AppCompatActivity {

    RecyclerView mMianRecyclerView;
    MianAdapter mMainAdapter;
    List<RecyclerViewTypeModel> mRecyclerViewTypeList;
    private MianAdapter.OnItemClickListener onItemClickListener = new MianAdapter.OnItemClickListener() {
        @Override
        public void OnItemClickListener(int position) {
            switch (position){
                case 0:
                    goActivity(RecyclerViewLinearActivity.class);
                    break;
                case 1:
                    goActivity(RecyclerViewGridActivity.class);
                    break;
                case 2:
                    goActivity(RecyclerViewWaterfallFlowHorizontalActivity.class);
                    break;
                case 3:
                    goActivity(RecyclerViewWaterfallFlowVerticalActivity.class);
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
        RecyclerViewTypeListModel mRecyclerViewTypeListModel = new ReadDataTool().readDataFromAssets(this, "RecyclerViewType", RecyclerViewTypeListModel.class);
        mRecyclerViewTypeList = mRecyclerViewTypeListModel.getRecyclerViewType();
    }

    private void initView() {
        if(mRecyclerViewTypeList != null && mRecyclerViewTypeList.size() != 0){
            mMianRecyclerView = findViewById(R.id.mian_rv);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            mMianRecyclerView.setLayoutManager(linearLayoutManager);
            mMainAdapter = new MianAdapter(this, mRecyclerViewTypeList);
            mMainAdapter.setOnItemClickListener(onItemClickListener);
            mMianRecyclerView.setAdapter(mMainAdapter);
        }

    }

    private void goActivity(Class<?> cla){
        Intent intent = new Intent(this, cla);
        startActivity(intent);
    }
}
