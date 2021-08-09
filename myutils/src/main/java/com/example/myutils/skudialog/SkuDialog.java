package com.example.myutils.skudialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;


import com.example.myutils.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

/**SKU弹窗 例如：京东的点击购买该物品所弹出的界面
 * @description
 * @param
 * @return
 * @author lutong
 * @time 2021/8/6 17:14
 */

public class SkuDialog extends BottomSheetDialog {
    private GoodsDetailBean goodsDetailBean;
    private Context context;

    public SkuDialog(@NonNull Context context, GoodsDetailBean goodsDetailBean) {
        super(context);
        this.goodsDetailBean = goodsDetailBean;
        this.context = context;
        initView();
    }

    private void initView() {
        //popupWindow
        View view = LayoutInflater.from(context).inflate(R.layout.layout_sku_pop, null);
        //点击关闭弹窗
        ImageView mCloseIv = view.findViewById(R.id.mCloseIv);
        Button mAddCartBtn = view.findViewById(R.id.mAddCartBtn);
        mCloseIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        mAddCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        //流式布局
        LinearLayout mSkuView = view.findViewById(R.id.mSkuView);
        setContentView(view);

        List<GoodsDetailBean.GoodsSku> goodsSku = goodsDetailBean.getGoodsSku();

        //遍历集合 获取每个集合元素的数据
        for (GoodsDetailBean.GoodsSku sku : goodsSku) {
            //动态加载控件
            View skuItemView = LayoutInflater.from(context).inflate(R.layout.layout_sku_view, null);
            //获取集合里 数据设置到动态 控件上
            TextView mSkuTitleTv = skuItemView.findViewById(R.id.mSkuTitleTv);mSkuTitleTv.setText(sku.getSkuTitle());
            TagFlowLayout flowLayout = skuItemView.findViewById(R.id.mSkuContentView);

            //将数组内容进行逗号分隔
            String[] split = sku.getGoodsSkuContent().split(",");

            flowLayout.setAdapter(new TagAdapter<String>(split) {
                @Override
                public View getView(FlowLayout parent, final int position, String s) {
                    TextView tvItem = (TextView) LayoutInflater.from(context).inflate(R.layout.layout_sku_item, null);
                    tvItem.setText(s);
                    return tvItem;
                }
            });
            mSkuView.addView(skuItemView);
        }


        //遍历集合 获取每个集合元素的数据
        for (GoodsDetailBean.GoodsSku sku : goodsSku) {
            //动态加载控件
            View skuItemView = LayoutInflater.from(context).inflate(R.layout.layout_sku_view, null);
            //获取集合里 数据设置到动态 控件上
            TextView mSkuTitleTv = skuItemView.findViewById(R.id.mSkuTitleTv);mSkuTitleTv.setText(sku.getSkuTitle());
            TagFlowLayout flowLayout = skuItemView.findViewById(R.id.mSkuContentView);

            //将数组内容进行逗号分隔
            String[] split = sku.getGoodsSkuContent().split(",");

            flowLayout.setAdapter(new TagAdapter<String>(split) {
                @Override
                public View getView(FlowLayout parent, final int position, String s) {
                    TextView tvItem = (TextView) LayoutInflater.from(context).inflate(R.layout.layout_sku_item, null);
                    tvItem.setText(s);
                    return tvItem;
                }
            });
            mSkuView.addView(skuItemView);
        }

        mSkuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "蓝色部分", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
