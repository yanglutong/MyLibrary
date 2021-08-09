package com.sm.example.Main;

import android.content.Context;

import com.sm.example.OrmSqlLite.Bean.PersonBean;
import com.sm.example.OrmSqlLite.DBManagerPerson;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: 小杨同志
 * @date: 2021/8/3
 */
public class HomePresenter implements HomeContract.Presenter{
    HomeContract.View view;
    public HomePresenter(HomeContract.View view){
        this.view=view;
        view.setPresenter(this);
    }

    @Override
    public void toPresenter(Context context) {
        try {
            DBManagerPerson manager = new DBManagerPerson(context);

            for (PersonBean personBean : manager.getdemoBeanList()) {//先删除数据库的所有数据
                manager.deletedemoBean(personBean);
            }


            for (int i = 0; i <3 ; i++) {//添加数据
                PersonBean bean = new PersonBean();
                bean.setName("杨路通"+i);
                manager.insertdemoBean(bean);
            }

            List<PersonBean> list = manager.getdemoBeanList();//查询
            String string=list.toString();//网络请求来的数据 通过P 给到View
            view.showView(string);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
