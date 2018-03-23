package com.cong.huaweiappstore.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Cong
 * @date 2018/2/5
 * @description
 */

public class RetrofitClient {


    private static RetrofitClient retrofitClient;
    private OkHttpClient mOkHttpClient;
    private Retrofit mRetrofit;
    private ApiService mApiService;

    private RetrofitClient() {

    }

    //获得单例
    public static RetrofitClient getInstance() {
        if (retrofitClient == null) {
            synchronized (RetrofitClient.class) {
                if (retrofitClient == null) {
                    retrofitClient = new RetrofitClient();
                }
            }
        }
        return retrofitClient;
    }


    private OkHttpClient provideOkHttpClient() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    //.addInterceptor(new HttpParamInterceptor())  //公共参数的封装
                    //.cookieJar(new CookieJarImpl(new PersistentCookieStore(mContext))) //cookie 保存方案
                    .build();
        }


        return mOkHttpClient;
    }


    private Retrofit provideRetrofit() {

        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                     .baseUrl(Contacts.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())   //RxJava2 的CallAdapter
                    .addConverterFactory(GsonConverterFactory.create())       // FastJsonConvertFactory
                    .client(provideOkHttpClient())
                    .build();
        }

        return mRetrofit;
    }


    public ApiService provideApiService() {
        if (mApiService == null) {
            mApiService = provideRetrofit().create(ApiService.class);
        }
        return mApiService;
    }

}
