//package com.sm.example.Main;
//
//
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import com.sm.example.Base.BaseActivity;
//import com.sm.example.R;
//
//import java.io.UnsupportedEncodingException;
//
//
//public class MainActivity extends BaseActivity implements MainView.View {
//    MainView.MainPresenter presenter;
//    EditText editText;
//    Button button1;
//    @Override
//
//    protected void initQx() {
//        getPermissions();
//    }
//
//    @Override
//    protected void init() throws UnsupportedEncodingException {
//        new MainPersent(this);
//        //以下MVP示例
//        button1 = findViewById(R.id.bt_setEdit);
//        editText = findViewById(R.id.et_get);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                presenter.set("改成2好不好?");
//            }
//        });
//    }
//
//    @Override
//    protected void findViews() {
//    }
//
//    @Override
//    protected int getViewLayout() {
//        return R.layout.activity_main;
//    }
//
//    @Override
//    public void Up(String str, String strs) {
//        editText.setText(strs);//只做更新 回调
//    }
//
//    @Override
//    public void setPresenter(MainView.MainPresenter presenter) {
//        this.presenter = presenter;
//    }
//}