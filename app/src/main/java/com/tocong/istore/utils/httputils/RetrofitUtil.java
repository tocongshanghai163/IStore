package com.tocong.istore.utils.httputils;

import com.tocong.istore.utils.APIService;
import com.tocong.istore.utils.Constants;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Jialebao on 2017/4/7.
 */

public class RetrofitUtil {
    private static RetrofitUtil retrofitUtil;
    private Retrofit retrofit;
    private static final int TIMEOUT_READ = 30;
    private static final int TIMEOUT_CONNECTION = 30;


    private RetrofitUtil() {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cookieJar(new JavaNetCookieJar(cookieManager))
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Constants.URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

    }

    public static RetrofitUtil getInstance() {
        if (retrofitUtil == null) {
            synchronized (RetrofitUtil.class) {
                if (retrofitUtil == null) {
                    retrofitUtil = new RetrofitUtil();
                }
            }
        }
        return retrofitUtil;
    }


    public APIService getAPIService() {
        return retrofit.create(APIService.class);
    }
}
