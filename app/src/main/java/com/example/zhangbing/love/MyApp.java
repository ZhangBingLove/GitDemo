package com.example.zhangbing.love;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.zhangbing.love.dao.entity.DaoMaster;
import com.example.zhangbing.love.dao.entity.DaoSession;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.SPCookieStore;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.OkHttpClient;

/**
 * 创建时间: 2017/9/30.
 * 编写人:
 * 功能描述:
 */
public class MyApp extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
//        OkGo.getInstance().init(this);

        initOkGo();
        setUpDateBase();
    }

    /**
     * 创建GreenDao的数据库
     */
    private void setUpDateBase() {

        // 创建数据库
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(this, "my.db", null);
        //获得可写的数据库
        SQLiteDatabase db = openHelper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }

    /**
     * okGo的全局配置
     */
    private void initOkGo() {
        //################## 构建build #############
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        //################### 配置log #####################
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OkGo");
        //log打印级别，决定了log显示的详细程度
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        //log颜色级别，决定了log在控制台显示的颜色
        loggingInterceptor.setColorLevel(Level.INFO);
        builder.addInterceptor(loggingInterceptor);

        //################ 配置超时时间 默认的超时时间是60秒 ###############
        //全局的读取超时时间
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
//全局的写入超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
//全局的连接超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);

        //################ 使用SP保存cookie #################
        builder.cookieJar(new CookieJarImpl(new SPCookieStore(this)));

        //######################### 配置全局的header ###################
        HttpHeaders httpHeaders = new HttpHeaders();//服务器约定的全局header
        httpHeaders.put("clientType", "Android" + android.os.Build.VERSION.RELEASE);//Android版本号
        httpHeaders.put("clientCompany", android.os.Build.MODEL);//设备型号
//        httpHeaders.put("appVersion", versionName);//版本号
        httpHeaders.put("requestFrom", "1");//终端来源

        OkGo.getInstance().init(this)                       //必须调用初始化
                .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置将使用默认的
                .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)   //全局统一缓存时间，默认永不过期，可以不传
                .setRetryCount(3)                               //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                .addCommonHeaders(httpHeaders);                   //全局公共头


    }
}
