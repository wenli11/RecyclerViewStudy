package dg.bin.com.recyclerviewstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dg.bin.com.recyclerviewstudy.LinearDividerItemDecoration;
import dg.bin.com.recyclerviewstudy.R;
import dg.bin.com.recyclerviewstudy.adapter.LinearHorizontalAdapter;
import dg.bin.com.recyclerviewstudy.adapter.LinearVerticalAdapter;

public class RecyclerViewLinearHorizontalActivity extends AppCompatActivity {

    RecyclerView mRecyclerViewVitical;

    List<String> mList;

    LinearHorizontalAdapter mLinearHorizontalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_linear_horizontal);

        initData();

        initView();
    }

    //基本展示的设置
    private void initView() {
        mRecyclerViewVitical = findViewById(R.id.rv_vertical);
        recyclerViewShow();
        addItenDecoration();
    }

    //recyclerView基本展示
    private void recyclerViewShow(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewVitical.setLayoutManager(linearLayoutManager);

        mLinearHorizontalAdapter = new LinearHorizontalAdapter(this, mList);
        mRecyclerViewVitical.setAdapter(mLinearHorizontalAdapter);
    }

    //设置分隔线
    private void addItenDecoration(){
        //系统默认
//        mRecyclerViewVitical.addItemDecoration( new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //自定义
        mRecyclerViewVitical.addItemDecoration(new LinearDividerItemDecoration(this, LinearDividerItemDecoration.HORIZONTAL));
    }

    private void initData() {
        mList = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            mList.add(i+"");
        }
    }
}
