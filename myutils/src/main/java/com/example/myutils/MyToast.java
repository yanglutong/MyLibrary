package com.example.myutils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



/**吐司工具类
 * @description
 * @param
 * @return
 * @author lutong
 * @time 2021/8/9 10:04
 */

public class MyToast {
    /*Toast工具类记得在onDestroy中 if (MyToast.toast != null) MyToast.toast = null;*/
    //    //居中 自定义布局Toast
    public static void showToast(Context context,String text) {
        try {
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, -250);

            View view = LayoutInflater.from(context).inflate(R.layout.toast_item, null);
            TextView tv = (TextView) view.findViewById(R.id.tv);
            tv.setText(text + "");
            toast.setView(view);
            toast.show();
        } catch (Exception e) {

        }

    }
    private MyToast() { }

    public static boolean isShow = true;
    public static Toast toast;

    //短时间显示Toast
    public static void showShort(Context context, CharSequence message) {
        if (isShow) {
            if (toast != null) {
                toast.cancel();//关闭吐司显示
            }
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    //短时间显示Toast
    public static void showShort(Context context, int message) {
        if (isShow) {
            if (toast != null) {
                toast.cancel();//关闭吐司显示
            }
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    //长时间显示Toast
    public static void showLong(Context context, CharSequence message) {
        if (isShow) {
            if (toast != null) {
                toast.cancel();//关闭吐司显示
            }
            toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
            toast.show();
        }
    }

    //长时间显示Toast
    public static void showLong(Context context, int message) {
        if (isShow) {
            if (toast != null) {
                toast.cancel();//关闭吐司显示
            }
            toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
            toast.show();
        }
    }

    //自定义显示Toast时间
    public static void show(Context context, CharSequence message, int duration) {
        if (isShow) {
            Toast.makeText(context, message, duration).show();
        }
    }

    //自定义显示Toast时间
    public static void show(Context context, int message, int duration) {
        if (isShow) {
            Toast.makeText(context, message, duration).show();
        }
    }

}
