package dg.bin.com.recyclerviewstudy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import dg.bin.com.recyclerviewstudy.R;

/**
 * Created by b on 2018/8/10.
 */

public class LinearVerticalAdapter extends RecyclerView.Adapter<LinearVerticalAdapter.ViewHolder> {

    List<String> mList;

    Context mContext;

    public LinearVerticalAdapter(Context mContext, List<String> mList){
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //根据viewType显示需要的布局
        if(viewType == 0){

        }else {

        }
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_adapter_linear_vertical, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextViewContent.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //用于设置多布局
    @Override
    public int getItemViewType(int position) {
        if(position%2 == 0){
            return 0;
        }else {
            return 1;
        }
//        return super.getItemViewType(position);
    }

    //添加数据
    public void addView(){
        mList.add(mList.size(), (new Random()).nextInt(100)+"");
        notifyItemInserted(mList.size());
    }

    //移除数据
    public void removeView(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mTextViewContent;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextViewContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
