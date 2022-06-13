package kg.geektech.lovecalculator42.repesitori;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import kg.geektech.lovecalculator42.network.App;
import kg.geektech.lovecalculator42.network.LoveModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repesetery {
    final String HOST = "love-calculator.p.rapidapi.com";
    final String KEY = "5699688dc9msh809376b312571d4p1e9b63jsnf8f87e86c059";

    public MutableLiveData<LoveModel> getData(String first, String second) {

        MutableLiveData<LoveModel> LocalMutableLivedata = new MutableLiveData<>();

        App.api.loveCalculator(first, second, HOST, KEY).enqueue(new Callback<LoveModel>() {
            @Override
            public void onResponse(Call<LoveModel> call, Response<LoveModel> response) {
                if (response.isSuccessful()) {
                    LocalMutableLivedata.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<LoveModel> call, Throwable t) {
                Log.e("ololo", "onFailure: " + t.getMessage());

            }
        });
        return LocalMutableLivedata;
    }
}
