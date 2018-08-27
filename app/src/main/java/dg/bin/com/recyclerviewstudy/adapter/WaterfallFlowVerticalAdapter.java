package dg.bin.com.recyclerviewstudy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dg.bin.com.recyclerviewstudy.R;

/**
 * Created by b on 2018/8/27.
 */

public class WaterfallFlowVerticalAdapter extends RecyclerView.Adapter<WaterfallFlowVerticalAdapter.ViewHolder> {

    List<String> mList;

    Context mContext;

    public WaterfallFlowVerticalAdapter(Context mContext, List<String> mList){
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public WaterfallFlowVerticalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WaterfallFlowVerticalAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_adapter_water_fall_flow_vertical, parent, false));
    }

    @Override
    public void onBindViewHolder(WaterfallFlowVerticalAdapter.ViewHolder holder, int position) {
        holder.mTextViewContent.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mTextViewContent;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextViewContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
