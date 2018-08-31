package dg.bin.com.recyclerviewstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dg.bin.com.recyclerviewstudy.LinearDividerItemDecoration;
import dg.bin.com.recyclerviewstudy.R;
import dg.bin.com.recyclerviewstudy.adapter.LinearVerticalAdapter;

public class RecyclerViewLinearVerticalActivity extends AppCompatActivity implements View.OnClickListener{

    RecyclerView mRecyclerViewVitical;

    List<String> mList;

    LinearVerticalAdapter mVerticalAdapter;

    TextView mTextViewAdd, mTextViewRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_vertical);

        initData();

        initView();
    }

    //基本展示的设置
    private void initView() {
        mTextViewAdd = findViewById(R.id.tv_add);
        mTextViewAdd.setOnClickListener(this);
        mTextViewRemove = findViewById(R.id.tv_remove);
        mTextViewRemove.setOnClickListener(this);
        mRecyclerViewVitical = findViewById(R.id.rv_vertical);
        recyclerViewShow();
        addItenDecoration();
    }

    //recyclerView基本展示
    private void recyclerViewShow(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewVitical.setLayoutManager(linearLayoutManager);
        mVerticalAdapter = new LinearVerticalAdapter(this, mList);
        mRecyclerViewVitical.setAdapter(mVerticalAdapter);
    }

    //设置分隔线
    private void addItenDecoration(){
        //系统默认
//        mRecyclerViewVitical.addItemDecoration( new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //自定义
        mRecyclerViewVitical.addItemDecoration(new LinearDividerItemDecoration(this, LinearDividerItemDecoration.VERTICAL));
    }

    private void initData() {
        mList = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            mList.add(i+"");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_add:
                mVerticalAdapter.addView();
                mRecyclerViewVitical.scrollToPosition(mList.size()-1);
                break;
            case R.id.tv_remove:
                int i = new Random().nextInt(mList.size());
                mRecyclerViewVitical.scrollToPosition(i);
                mVerticalAdapter.removeView(i);

                break;
        }
    }
}
