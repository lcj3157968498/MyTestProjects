package com.example.lcj.mytestprojects.RatingBarTest.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lcj.mytestprojects.R;
import com.example.lcj.mytestprojects.RatingBarTest.model.ResultTagsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcj on 2018/12/5.
 * Description:
 */

public class TagsAdapter extends BaseQuickAdapter<ResultTagsBean.DataBean.TagsBean, BaseViewHolder> {


    public TagsAdapter(List<ResultTagsBean.DataBean.TagsBean> data) {
        super(R.layout.item_tags_ratting, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, final ResultTagsBean.DataBean.TagsBean item) {

        helper.setText(R.id.tx_pingjia, item.getName());
        final TextView tx_pingjia = helper.getView(R.id.tx_pingjia);
        tx_pingjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentTextColor = tx_pingjia.getCurrentTextColor();
                if (Color.parseColor("#FF4081") == currentTextColor) {
                    tx_pingjia.setBackgroundResource(R.drawable.bg_shape2);
                    tx_pingjia.setTextColor(Color.parseColor("#3F51B5"));
                    item.setCheck(true);
                } else {
                    tx_pingjia.setTextColor(Color.parseColor("#FF4081"));
                    tx_pingjia.setBackgroundResource(R.drawable.bg_shape);
                    item.setCheck(false);

                }
            }
        });


    }
}


//    private OnItemClickListener mItemClickListener;
//    private List<ResultTagsBean.DataBean.TagsBean> myrecyList;
//    public List<String> mToastList=new ArrayList<>();
//
//
//
//    @NonNull
//    @Override
//    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tags_ratting, viewGroup, false);
//        VH vh = new VH(view);
//
//        vh.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mItemClickListener != null) {
//                    mItemClickListener.onItemClick((Integer) v.getTag());
//                }
//            }
//        });
//        return vh;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull final VH vh, final int i) {
//        final ResultTagsBean.DataBean.TagsBean a = myrecyList.get(i);
//
//
//        vh.textView.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceAsColor")
//            @Override
//            public void onClick(View v) {
//               /* if (flag == 0) {
//                    vh.textView.setBackgroundResource(R.drawable.bg_shape2);
//                    vh.textView.setTextColor(R.color.colorPrimary);
//                    flag = 1;
//                    String s = vh.textView.getText().toString();
//                    System.out.println("333333" + s);
//                } else {
//
//                    vh.textView.setBackgroundResource(R.drawable.bg_shape);
//                    vh.textView.setTextColor(R.color.colorAccent);
//                    flag = 0;
//                }*/
//                /*int currentTextColor = vh.textView.getCurrentTextColor();
//                if (Color.parseColor("#FF4081") == currentTextColor) {
//                    vh.textView.setBackgroundResource(R.drawable.bg_shape2);
//                    vh.textView.setTextColor(Color.parseColor("#3F51B5"));
//                    a.setCheck(true);
//                } else {
//                    vh.textView.setBackgroundResource(R.drawable.bg_shape);
//                    vh.textView.setTextColor(Color.parseColor("#FF4081"));
//                    a.setCheck(false);
//                }
//
//            }
//        });
//        vh.textView.setText(a.getName());
//        vh.itemView.setTag(i);
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return myrecyList.size();
//    }
//
//    public interface OnItemClickListener {
//        void onItemClick(int position);
//    }
//
//    public void setItemClickListener(OnItemClickListener itemClickListener) {
//        mItemClickListener = itemClickListener;
//    }
//



