package com.dev.honda.network;

import android.content.Context;

import com.dev.honda.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private static ApiService service;

    public static ApiService getInstance(Context context, boolean isUploading, boolean isSalesForce) {
        if (service != null) {
            service = null;
        }
        if (service == null) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .excludeFieldsWithModifiers(Modifier.TRANSIENT)
                    .create();
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
//            if (isUploading) {
//                builder.readTimeout(30, TimeUnit.MINUTES);
//                builder.connectTimeout(30, TimeUnit.MINUTES);
//                builder.writeTimeout(30, TimeUnit.MINUTES);
//            } else {
            builder.readTimeout(50, TimeUnit.SECONDS);
            builder.connectTimeout(50, TimeUnit.SECONDS);
            builder.writeTimeout(50, TimeUnit.SECONDS);
//            }
//            builder.addInterceptor(new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    Request request = chain.request().newBuilder().addHeader("apiVersion", "3")
//                            .build();
//                    return chain.proceed(request);
//                }
//            });
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addNetworkInterceptor(interceptor);
            }
            int cacheSize = 2 * 1024 * 1024; // 2 MiB
            Cache cache = new Cache(context.getCacheDir(), cacheSize);
            builder.cache(cache);
            String baseURL = AppWebServicesURL.BASE_URL;
            Retrofit retrofit = new Retrofit
                    .Builder()
                    .client(builder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseURL).build();
            service = retrofit.create(ApiService.class);

            return service;
        } else {
            return service;
        }
    }
}
