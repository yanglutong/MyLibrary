package com.sm.example.Main;

import android.content.Context;

import com.sm.example.Base.BaseView;

/**
 * @author: 小杨同志
 * @date: 2021/8/3
 */
public interface HomeContract {
    interface View extends BaseView<HomePresenter>{//Activity 实现此接口
        void showView(String h);
    }
    interface Presenter{//presenter 实现
        void  toPresenter(Context context);
    }
}
