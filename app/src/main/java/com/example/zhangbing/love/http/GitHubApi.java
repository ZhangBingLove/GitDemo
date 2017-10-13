package com.example.zhangbing.love.http;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 创建时间: 2017/9/29.
 * 编写人:
 * 功能描述:
 */

public interface GitHubApi {

    @FormUrlEncoded
    @POST("user/login")
    Call<ResponseBody> login(@Field("userName") String userName, @Field("password") String password);

    @FormUrlEncoded
    @POST("user/login")
    public Observable<HttpBean> login1(@Field("userName") String userName, @Field("password") String password);

}
