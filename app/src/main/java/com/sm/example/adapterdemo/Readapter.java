package com.sm.example.adapterdemo;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.myutils.adapter.BaseAdapter;
import com.example.myutils.adapter.BaseViewHolder;
import com.sm.example.R;

import java.util.List;

/**
 * @author: 小杨同志
 * @date: 2021/8/6
 */
public class Readapter extends BaseAdapter<String> {
    public Readapter(List<String> strings, Context context, int layoutId) {
        super(strings, context, layoutId);
    }
    @Override
    public void bindData(BaseViewHolder baseViewHolder, int position) {
        TextView tv = baseViewHolder.itemView.findViewById(R.id.text);
        tv.setText(data.get(position));
    }
}
