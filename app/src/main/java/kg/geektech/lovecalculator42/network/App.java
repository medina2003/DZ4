package kg.geektech.lovecalculator42.network;

import android.app.Application;

import kg.geektech.lovecalculator42.network.LoveApi;
import kg.geektech.lovecalculator42.network.RetrofitService;

public class App extends Application {
    public static LoveApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitService retrofitService = new RetrofitService();
        api = retrofitService.getLoveApi();

    }
}
