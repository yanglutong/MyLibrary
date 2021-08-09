package com.example.myutils.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/*smoothScrollToPosition(position)和scrollToPosition(position)效果基本相似，
也是把你想显示的项显示出来，只要那一项现在看得到了，那它就罢工了，
不同的是smoothScrollToPosition是平滑到你想显示的项，而scrollToPosition是直接定位显示

//每次都让最后一条显示到当前界面
linearLayoutManager.scrollToPositionWithOffset(ryZmAdapterdw.getItemCount() - 1, Integer.MIN_VALUE);

linearLayoutManager.setStackFromEnd(true);//recyview显示最底部一条
*/
/**
 * 项目名：2007  BaseAdapter<DATA>  data放的是Bean类</>
 * 包名：  com.example.myapplication.adapter
 * 文件名：BaseAdapter
 * 创建者：杨路通
 * 创建时间：2020/11/11  9:38
 * 描述：TODO
 */
public abstract class BaseAdapter<DATA> extends RecyclerView.Adapter<BaseViewHolder>{

    protected   List<DATA> data;
    protected Context  context;
    protected LayoutInflater inflater;
    private int layoutId;
    public BaseAdapter(List<DATA> data, Context context ,int layoutId
    ) {
        this.data = data;
        this.context = context;
        inflater=LayoutInflater.from(context);
        this.layoutId=layoutId;
    }
    //追加数据
    public void setData(List<DATA>data){
        this.data=data;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new BaseViewHolder(inflater.inflate(layoutId,viewGroup,false),context);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, final int position) {
        bindData(viewHolder,position);
        viewHolder.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("杨路通", "onClick: ");
                if(adapterOnItemClickListener!=null){
                    adapterOnItemClickListener.OnItemClick(position);
                }
            }
        });
    }

    public abstract void bindData(BaseViewHolder baseViewHolder,int position);
    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface AdapterOnItemClickListener {
        void  OnItemClick(int position);
    }
    private AdapterOnItemClickListener adapterOnItemClickListener;

    public void setAdapterOnItemClickListener(AdapterOnItemClickListener adapterOnItemClickListener) {
        this.adapterOnItemClickListener = adapterOnItemClickListener;
    }
}
