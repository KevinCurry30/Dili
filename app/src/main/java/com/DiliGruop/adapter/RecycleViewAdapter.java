package com.DiliGruop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.DiliGruop.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Kevin on 2016/5/12.
 */
public class RecycleViewAdapter extends Adapter<ViewHolder> {
    private List<String> mDatas;
    private LayoutInflater mInflater;
    Context context;
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public interface OnItemClickListener {
        void onItemClicked(View view, int position);

        void onItemLongClicked(View view, int position);
    }


    public RecycleViewAdapter(Context context, List<String> data) {
        this.context = context;
        this.mDatas = data;
        this.mInflater = LayoutInflater.from(context);
    }

    public OnItemClickListener mOnItemClickListener;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.mOnItemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent,
                    false);
            return new MyViewHolder(view);
        } else if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_foot, parent,
                    false);
            return new FootViewHolder(view);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {

            Glide.with(context).load(mDatas.get(position)).into(((MyViewHolder) holder).item_food_image);
            ((MyViewHolder) holder).item_food_text.setText("菜品 相关描述信息 菜品 相关描述信息 菜品 相关描述信息");
            if (mOnItemClickListener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickListener.onItemClicked(holder.itemView, pos);
                    }
                });
                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickListener.onItemLongClicked(holder.itemView, pos);
                        return false;
                    }
                });
            }
        }
//            holder.item_food_image.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//            holder.item_food_text.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });

    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size() == 0 ? 0 : mDatas.size() + 1;
    }

    static class MyViewHolder extends ViewHolder {
        ImageView item_food_image;
        TextView item_food_text;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_food_image = (ImageView) itemView.findViewById(R.id.item_food_image);
            item_food_text = (TextView) itemView.findViewById(R.id.item_food_text);
        }
    }

    public void addData(int position) {
        mDatas.add(position, "Insert One");
        notifyItemInserted(position);
    }


    public void removeData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    static class FootViewHolder extends ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}
