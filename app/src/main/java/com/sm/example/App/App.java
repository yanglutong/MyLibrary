package com.sm.example.App;

import android.content.Context;

import com.example.myutils.JK;
import com.liyi.sutils.utils.SUtils;
import com.liyi.sutils.utils.log.CrashUtil;

//MVP  Main 继承 BaseMain P 继承 Presenter
public class App extends android.app.Application {
    public static Context instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SUtils.initialize(this);//初始化SUtils工具类
        CrashUtil.initialize();//初始化崩溃日志 UncaughtException

    }

    private static void myUtils() {//工具类导航2
        /*MUtils    检测手机的制造商*/
        /*adapter    RecyclerView适配器*/
        /*CProgressDialogUtils    加载进度条类*/
        /*DateUtil    日期工具类*/
        /*DateUtils    日期工具类*/
        /*FileUtil    File工具类 主要封装了一些对文件读写的操作*/
        /*GeneriArrayUtils    数组的增删改查*/
        /*JK    进制转换工具*/
        /*MyToast    吐司工具类*/
        /*MyViewPager    不可滑动的ViewPager*/
        /*TimerUtil    获取验证码倒计时*/
        /*TitleBar    标题栏工具*/
        /*GpsUtil    GPS工具类*/
        /*pop    PopWindow条目列表式弹窗*/

    }

    public static void sutils(){//工具类导航1


        /*NetworkType    网络类型*/

        /*RegexCst    常用正则表达式*/

        /*AesUtil    AES 加密工具类（对称加密，用于替代 DES）*/

        /*Base64Decoder    base64 解密*/

        /*Base64Encoder    base64加密*/

        /*Base64Util    Base64 加密工具类*/

        /*Md5Util    MD5加密工具类*/

        /*RsaUtil    RSA 加密工具类（非对称加密）*/

        /*XorUtil    异或加密工具类*/

        /*FastBlur    国外一位大神写的图片模糊算法*/

        /*RSBlur    调用 Android 自己的 RenderScript 实现图片模糊 仅在 SDK >= 17 时有用*/

        /*ImageUtil   Image 相关工具类*/

        /*ShapeUtil    Shape 工具类*/

        /*ACache    轻量级缓存工具类*/

        /*AssetUtil    assets 工具类*/

        /*FileUtil    File 相关工具类*/

        /*GsonUtil    gson 工具类*/

        /*SPUtil    SharedPreferences 工具类*/

        /*CrashUtil  Thread.UncaughtExceptionHandler     UncaughtException 处理类,当程序发生 Uncaught 异常的时候,有该类来接管程序,并记录发送错误报告.  异常管理类*/

        /*LogUtil    Log 相关工具类*/

        /*permission    权限管理类*/

        /*CountdownUtil    倒计时工具类*/

        /*TimeUtil    时间相关工具类*/

        /*AlertDialogUtil    系统弹出对话框工具类*/

        /*AppUtil    App 相关工具类*/

        /*AtyTransitionUtil    Activity 过渡动画工具类*/

        /*CleanUtil    清除相关工具类*/

        /*ClipboardUtil    剪贴板相关工具类*/

        /*DensityUtil    像素单位转换工具类*/

        /*DeviceUtil    设备相关工具类*/

        /*EmptyUtil    判空相关工具类*/

        /*EventBusUtil    EventBus 3.0 工具类*/


        /*DeviceUtil    设备相关工具类*/

        /*EmptyUtil    判空相关工具类*/

        /*HandlerUtil    Handler 相关工具类*/

        /*LocationUtil    位置相关工具类*/

        /*NetUtil    网络相关工具类*/

        /*NfcUtil    NFC 相关的工具类*/

        /*OrientationUtil    屏幕方向监听工具类*/

        /*PhoneUtil    手机相关工具类*/

        /*PinyinUtil    拼音相关工具类*/

        /*QRCodeUtil    二维码相关工具类*/

        /*ReflectUtil    反射相关工具类*/

        /*RegexUtil    正则表达式相关工具类*/

        /*ResourceUtil    资源相关工具类*/

        /*ScreenUtil    屏幕相关工具类*/

        /*ServiceUtil    Service 相关工具类*/

        /*ShellUtil    Shell 相关工具类  root  手机端执行shell命令*/

        /*SpanUtil    SpannableString 相关工具类  SpannableString能够更简便的设置文字样式  文本样式 例如：今天下雨了 今天(下 可以设置成别的颜色也可添加下划线)雨了*/

        /*StringUtil    String 相关工具类*/

        /*SUtils    管理Activity*/

        /*SystemBarUtil    系统状态栏与底部导航栏相关工具类  导航栏 沉浸式状态栏 */

        /*SystemSettingUtil    进入指定系统功能界面的相关工具类  例如 ：跳转到 Wifi 列表设置界面  跳转到系统设置界面*/

        /*ToastUtil   Toast 相关工具类*/

        /*ZipUtil    压缩相关工具类*/
    }
}