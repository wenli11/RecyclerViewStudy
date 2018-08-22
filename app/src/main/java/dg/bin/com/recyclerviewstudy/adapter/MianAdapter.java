package dg.bin.com.recyclerviewstudy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import dg.bin.com.recyclerviewstudy.R;
import dg.bin.com.recyclerviewstudy.model.RecyclerViewTypeModel;

/**
 * Created by b on 2018/8/9.
 */

public class MianAdapter extends RecyclerView.Adapter<MianAdapter.ViewHolder> {

    Context mContext;

    List<RecyclerViewTypeModel> mList;

    private OnItemClickListener onItemClickListener;

    public MianAdapter(Context mContext, List<RecyclerViewTypeModel> mList){
        this.mContext = mContext;
        this.mList = mList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_adapter_main, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mNameTextView.setText(mList.get(position).getName());
        holder.mContentTextView.setText(mList.get(position).getContent());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.OnItemClickListener(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnItemClickListener{
        void OnItemClickListener(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mNameTextView, mContentTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mNameTextView = itemView.findViewById(R.id.tv_name);
            mContentTextView = itemView.findViewById(R.id.tv_content);
        }
    }
}
