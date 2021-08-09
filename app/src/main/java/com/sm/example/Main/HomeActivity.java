package com.sm.example.Main;


import android.annotation.SuppressLint;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myutils.MUtils;
import com.example.myutils.adapter.BaseAdapter;
import com.example.myutils.pop.DLPopItem;
import com.example.myutils.pop.DLPopupWindow;
import com.example.myutils.skudialog.GoodsDetailBean;
import com.example.myutils.skudialog.SkuDialog;
import com.sm.example.adapterdemo.Readapter;
import com.liyi.sutils.utils.ToastUtil;
import com.liyi.sutils.utils.log.LogUtil;
import com.liyi.sutils.utils.permission.OnPermissionListener;
import com.liyi.sutils.utils.permission.PermissionRequest;
import com.liyi.sutils.utils.permission.PermissionUtil;
import com.sm.example.Base.BaseActivity;
import com.sm.example.R;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeActivity extends BaseActivity implements HomeContract.View{
    protected HomeContract.Presenter presenter;
    private static String TAG="HomeActivity";
    private RecyclerView recycler;
    private ArrayList<String> list;//条目的数据

    @Override
    protected void initQx() {
        //初始化P层
        new HomePresenter(this);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void init() throws UnsupportedEncodingException {
        toPermissions();//获取权限
        //创建RecyclerView列表
        toRecyclerView();
    }


    private void initList(){
        list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            list.add("列表");
        }
        list.set(0," PopWindow ");
    }
    private void toRecyclerView() {//列表展示每个功能
        initList();//添加数据
        LinearLayoutManager manager = new LinearLayoutManager(this);

        recycler.setLayoutManager(manager);
        Readapter readapter = new Readapter(list, this, R.layout.theme);
        recycler.setAdapter(readapter);
        readapter.setAdapterOnItemClickListener(new BaseAdapter.AdapterOnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                setModel(position);//根据传入的position类别来弹出不同的功能
            }
        });
    }

    private void setModel(int i) {
        if(i==0){//弹出PopWindow
            // 标示这个pw添加到哪个window里面，对控制pw出现位置没有影响
            // popupWindow.showAtLocation(v, Gravity.LEFT, 0, 0);

            // popupWindow.showAsDropDown(v, Gravity.LEFT, 0, 0);
            // 以v(在此布局上显示)的左下角为原点，向X轴正方向偏移100个像素，Y轴方向偏移0个像素
            ArrayList<DLPopItem> items = new ArrayList<>();
            items.add(new DLPopItem(R.drawable.menu_open,"pop",Color.RED));
            items.add(new DLPopItem(R.drawable.scan,"dod",Color.BLUE));
            items.add(new DLPopItem(R.drawable.scan,"sos",Color.YELLOW));
            DLPopupWindow window = new DLPopupWindow(Basecontext, items, R.style.animTranslate);
            window.showAtLocation(recycler, Gravity.CENTER,0,0);
            window.setOnItemClickListener(new DLPopupWindow.OnItemClickListener() {
                @Override
                public void OnClick(int position) {
                    Toast.makeText(Basecontext, ""+position, Toast.LENGTH_SHORT).show();
                }
            });//Pop条目监听
        }


        if(i==1){
            List<GoodsDetailBean.GoodsSku> goodsSkus = new ArrayList<>();
            ArrayList<String> skuContent = new ArrayList<>();
            skuContent.add("[1.6GHz i5处理器, 2017年i5处理器升级版, i7处理器 定制版]");

            skuContent.add("[8GB内存/128GB SSD, 8GB内存/256GB SSD]");

            GoodsDetailBean.GoodsSku goodsSku =
                    new GoodsDetailBean.GoodsSku(1, "1.6GHz i5处理器,2017年i5处理器升级版,i7处理器 定制版", "版本", 1, Collections.singletonList(skuContent.get(0)), "版本");
            GoodsDetailBean.GoodsSku goodsSku2 =
                    new GoodsDetailBean.GoodsSku(1, "8GB内存/128GB SSD,8GB内存/256GB SSD, goodsSkuTitle=配置", "配置", 2, Collections.singletonList(skuContent.get(1)), "配置");
            goodsSkus.add(goodsSku);
            goodsSkus.add(goodsSku2);

            goodsSkus.add(new GoodsDetailBean.GoodsSku(1, "8GB内存/128GB SSD,8GB内存/256GB SSD", "配置", 2,
                    skuContent, "配置"));


            GoodsDetailBean goodsDetailBean = new GoodsDetailBean(14, "https://img11.360buyimg.com/n1/s450x450_jfs/t2968/143/2485546147/238650/70df281e/57b12a31N8f4f75a3.jpg,https://img13.360buyimg.com/n1/s450x450_jfs/t2632/157/4193453761/92922/2adb5ebc/57ad88f0Nb286ec7a.jpg,https://img11.360buyimg.com/n1/s450x450_jfs/t2977/86/2412624329/68019/dbe32c1f/57ad8846N64ac3c79.jpg"
                    , "10000000001", "https://img11.360buyimg.com/n7/jfs/t2968/143/2485546147/238650/70df281e/57b12a31N8f4f75a3.jpg"
                    , "100"
                    , "1.6GHz i5处理器,GB内存/128GB SSD,1件, goodsDesc=Apple MacBook Air 13.3英寸笔记本电脑 银色(Core i5 处理器/8GB内存/128GB SSD闪存 MMGF2CH/A)", "Apple MacBook Air 13.3英寸笔记本电脑 银色(Core i5 处理器/8GB内存/128GB SSD闪存 MMGF2CH/A)"
                    , "https://img20.360buyimg.com/vc/jfs/t3034/151/748569500/226790/d6cd86a2/57b15612N81dc489d.jpg", "https://img20.360buyimg.com/vc/jfs/t2683/60/4222930118/169462/233c7678/57b15616N1e285f09.jpg"
                    , 5000, goodsSkus, 1000, 1);

            new SkuDialog(Basecontext, goodsDetailBean).show();//弹窗
        }
    }

    PermissionRequest request;
    private void toPermissions() {
        ToastUtil.setBgColor(Color.BLACK);//设置吐司背景色
        PermissionUtil.with(this);//绑定要申请权限的界面activity
        request= new PermissionRequest(this);//申请权限工具
        if(PermissionUtil.hasPermissions(this,permissions)){//判断是否有此权限
            if(MUtils.isMIUI()){
                Toast.makeText(Basecontext, "已经授予全部权限", Toast.LENGTH_SHORT).show();
               return;
            }
            ToastUtil.show("已经授予全部权限");
        }else{
            //没有权限申请权限
            String[] strings = PermissionUtil.getDeniedPermissions(this, permissions);//获取缺少的权限
            for (String string : strings) {
                LogUtil.d("HomeActivity","缺少的权限  "+string+"\r\n");
            }
            LogUtil.d("HomeActivity","缺少的权限长度  "+strings.length+"\r\n");


            request.permissions(permissions);//设置要申请的权限
            request.requestCode(100);//设置请求码
            request.autoShowTip(true);//设置是否自动显示拒绝授权时的提示
            request.callback(new OnPermissionListener() {
                @Override
                public void onPermissionGranted(int requestCode, String[] grantPermissions) {
                    //用户同意授权
                    if(MUtils.isMIUI()){
                        Toast.makeText(Basecontext, "用户同意授权", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    ToastUtil.show("用户同意授权");
                    LogUtil.d("HomeActivity","用户同意授权  用户同意授权");
                }

                @Override
                public void onPermissionDenied(int requestCode, String[] deniedPermissions, boolean hasAlwaysDenied) {
                    //用户拒绝授权
//                    LogUtil.d("HomeActivity","用户拒绝授权  用户拒绝授权");
                    if(MUtils.isMIUI()){
                        Toast.makeText(Basecontext, "用户拒绝授权", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    ToastUtil.show("用户拒绝授权");
                    if(request.isAutoShowTip()){//是否自动显示缺少的权限
                        PermissionUtil.showTipDialog(HomeActivity.this,"你咋不给权限,快跳到系统手动授权！！！");
                    }
                }
            });
            request.execute();//执行权限请求
        }


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        OnPermissionListener listener = request.getPermissionListener();//授权成功失败的回调监听
        LogUtil.d("HomeActivity","onRequestPermissionsResult  requestCode"+requestCode + " permissions "+permissions.length+"\r\n");
        for (int grantResult : grantResults) {
            LogUtil.d("HomeActivity","onRequestPermissionsResult  grantResult"+grantResult);
        }
        if(requestCode==request.getRequestCode()){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] ==PackageManager.PERMISSION_GRANTED) {
                // Permission Granted 授予权限
                //处理授权之后逻辑
                listener.onPermissionGranted(requestCode, permissions);
            } else {
                // Permission Denied 权限被拒绝
                listener.onPermissionDenied(requestCode, permissions, request.isAutoShowTip());
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void findViews() {
        recycler = findViewById(R.id.recycler);//RecyclerView对象

        presenter.toPresenter(this);//调用P层

    }

    @Override
    protected int getViewLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void showView(String h) {
        Log.i("ylt", "showView: "+h);
    }
    @Override
    public void setPresenter(HomePresenter presenter) {
        this.presenter=presenter;
    }
}