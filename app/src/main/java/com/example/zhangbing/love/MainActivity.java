package com.example.zhangbing.love;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zhangbing.love.activity.BaseRecyclerViewAdapterHelperActivity;
import com.example.zhangbing.love.activity.ConstraintLayoutActivity;
import com.example.zhangbing.love.activity.Text2Activity;
import com.example.zhangbing.love.base.BaseActivity;
import com.example.zhangbing.love.bean.LoginBean;
import com.example.zhangbing.love.http.GitHubApi;
import com.example.zhangbing.love.http.HttpUrl;
import com.example.zhangbing.love.okgo.JsonCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.base.Request;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button request;
    private Button rxJava;
    private Button btnDouble;
    private Button btnOkGo;
    private Button btn_Base_RecycleView;
    private ImageView ivImage;

    public String userName = "zhangbing";
    public String Pwd = "E10ADC3949BA59ABBE56E057F20F883E";


    @Override
    protected int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        findViewById(R.id.but_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ConstraintLayoutActivity.class));
            }
        });


        request = (Button) findViewById(R.id.but_request);
        rxJava = (Button) findViewById(R.id.but_rxjava);
        btnDouble = (Button) findViewById(R.id.btn_double);
        btnOkGo = (Button) findViewById(R.id.btn_okGo);
        btn_Base_RecycleView = (Button) findViewById(R.id.btn_Base_RecycleView);
        ivImage = (ImageView) findViewById(R.id.iv_image);


        request.setOnClickListener(this);
        rxJava.setOnClickListener(this);
        btnOkGo.setOnClickListener(this);
        btn_Base_RecycleView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_request: //网络请求

                requtestURl();

                break;

            case R.id.but_rxjava: //rxjava

                TextRxJava();

                break;
            case R.id.btn_double: //RxJava和Retrofit结合的网络请求

                TextRxJavaAndRetrofit();

                break;

            case R.id.btn_okGo:

                okGoHttpRequest();

                break;
            case R.id.btn_Base_RecycleView:

                startActivity(new Intent(MainActivity.this, BaseRecyclerViewAdapterHelperActivity.class));

                break;

        }
    }

    /**
     * okGo的网络请求
     */
    private void okGoHttpRequest() {

//        OkGo.<LoginBean>post(HttpUrl.login)
//                .tag(this)
//                .params("userName", userName)
//                .params("password", Pwd)
//                .execute(new com.lzy.okgo.callback.Callback<LoginBean>() {
//                    @Override
//                    public void onStart(Request<LoginBean, ? extends Request> request) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(com.lzy.okgo.model.Response<LoginBean> response) {
//                        Log.e("haha", response.toString());
//                    }
//
//                    @Override
//                    public void onCacheSuccess(com.lzy.okgo.model.Response<LoginBean> response) {
//
//                    }
//
//                    @Override
//                    public void onError(com.lzy.okgo.model.Response<LoginBean> response) {
//
//                    }
//
//                    @Override
//                    public void onFinish() {
//
//                    }
//
//                    @Override
//                    public void uploadProgress(Progress progress) {
//
//                    }
//
//                    @Override
//                    public void downloadProgress(Progress progress) {
//
//                    }
//
//                    @Override
//                    public LoginBean convertResponse(okhttp3.Response response) throws Throwable {
//                        Log.e("haha", response.toString());
//                        return null;
//
//                    }
//                });


        OkGo.<LoginBean>post(HttpUrl.login)
                .tag(this)
                .params("userName", userName)
                .params("password", Pwd)
                .execute(new JsonCallback<LoginBean>() {

                    @Override
                    public void onStart(Request<LoginBean, ? extends Request> request) {
                        super.onStart(request);
                    }

                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<LoginBean> response) {
                        Log.e("haha", response.body().toString());
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<LoginBean> response) {
                        super.onError(response);

                    }
                });

    }


    /**
     * 测试Rxjava和Retrofit相结合的网络请求
     */
    private void TextRxJavaAndRetrofit() {


    }


    private void TextRxJava() {
        // Observer 即观察者,它决定事件触发的时候将有怎样的行为

//        Observer observer = new Observer<String>() {
//
//
//            @Override
//            public void update(Observable o, Object arg) {
//
//            }
//        };
        //1.创建Observe 观察者
        Subscriber<String> subscriber = new Subscriber<String>() {

            @Override
            public void onNext(String s) {
                Log.d("text", "Item: " + s);
            }

            @Override
            public void onCompleted() {
                Log.d("text", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("text", "onError");
            }

        };

        //2.创建Observable被观察者
        rx.Observable<String> stringObservable = rx.Observable.create(new rx.Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                subscriber.onNext("hello");
                subscriber.onNext("rx");
                subscriber.onNext("java");
                subscriber.onCompleted();

            }

        });

        stringObservable.subscribe(subscriber);


        /**
         * 打印字符串数组
         */
        String[] names = {"白", "咪", "咪"};

        rx.Observable.from(names).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("text", s);
            }
        });


        /**
         * 由id取得图片并显示
         */
        final int drableId = R.mipmap.ic_launcher;

        rx.Observable.create(new rx.Observable.OnSubscribe<Drawable>() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = getTheme().getDrawable(drableId);

                subscriber.onNext(drawable);
                subscriber.onCompleted();


            }
        })
                .subscribeOn(Schedulers.io()) //指定被观察者发生在IO线程
                .observeOn(AndroidSchedulers.mainThread()) //指定观察者发生在主线程中
                .subscribe(new Subscriber<Drawable>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, "出错了", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(Drawable drawable) {
                        ivImage.setImageDrawable(drawable);
                    }
                });


    }


    private void requtestURl() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://1.119.11.190/API/")
                .build();

        GitHubApi repo = retrofit.create(GitHubApi.class);

        repo.login(userName, Pwd).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("haha", response.body().toString());

//                Gson gson = new Gson();
//                HttpBean contributorsList = gson.fromJson(call.toString(), new TypeToken<HttpBean>() {
//                }.getType());
//
//                Log.e("haha", contributorsList.toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("haha", "失败了");
            }
        });


    }
}
