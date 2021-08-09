package com.example.myutils;

import android.os.Build;

/**检测手机的制造商
 * @author: 小杨同志
 * @date: 2021/8/6
 */
public class MUtils {
    private static final String MANUFACTURER_HUAWEI = "Huawei";//华为
    private static final String MANUFACTURER_MEIZU = "Meizu";//魅族
    private static final String MANUFACTURER_XIAOMI = "Xiaomi";//小米
    private static final String MANUFACTURER_SONY = "Sony";//索尼
    private static final String MANUFACTURER_OPPO = "OPPO";
    private static final String MANUFACTURER_LG = "LG";
    private static final String MANUFACTURER_VIVO = "vivo";
    private static final String MANUFACTURER_SAMSUNG = "samsung";//三星
    private static final String MANUFACTURER_LETV = "Letv";//乐视
    private static final String MANUFACTURER_ZTE = "ZTE";//中兴
    private static final String MANUFACTURER_YULONG = "YuLong";//酷派
    private static final String MANUFACTURER_LENOVO = "LENOVO";//联想

    /**是否为小米手机
     * @description
     * @param
     * @return
     * @author lutong
     * @time 2021/8/6 10:01
     */
    public static boolean isMIUI() {
        //MANUFACTURER 制造商
        String manufacturer = Build.MANUFACTURER;
        //这个字符串可以自己定义,例如判断华为就填写huawei,魅族就填写meizu
        if (MANUFACTURER_XIAOMI.equalsIgnoreCase(manufacturer)) {
            return true;
        }
        return false;
    }
    /**是否为华为
     * @description
     * @param
     * @return
     * @author lutong
     * @time 2021/8/6 10:01
     */
    public static boolean isHuaWei() {
        //MANUFACTURER 制造商
        String manufacturer = Build.MANUFACTURER;
        //这个字符串可以自己定义,例如判断华为就填写huawei,魅族就填写meizu
        if (MANUFACTURER_HUAWEI.equalsIgnoreCase(manufacturer)) {
            return true;
        }
        return false;
    }
}
