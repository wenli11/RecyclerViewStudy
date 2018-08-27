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
 * Created by b on 2018/8/23.
 */

public class LinearHorizontalAdapter extends RecyclerView.Adapter<LinearHorizontalAdapter.ViewHolder> {

    List<String> mList;

    Context mContext;

    public LinearHorizontalAdapter(Context mContext, List<String> mList){
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public LinearHorizontalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearHorizontalAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_adapter_linear_horizontal, parent, false));
    }

    @Override
    public void onBindViewHolder(LinearHorizontalAdapter.ViewHolder holder, int position) {
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
