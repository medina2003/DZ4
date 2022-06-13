package kg.geektech.lovecalculator42.viewmodel;

import androidx.lifecycle.LiveData;

import kg.geektech.lovecalculator42.network.LoveModel;
import kg.geektech.lovecalculator42.repesitori.Repesetery;

public class ViewModel extends androidx.lifecycle.ViewModel {
    Repesetery repesetery = new Repesetery();

    public LiveData<LoveModel> getLoveModelLivedata(String first, String second) {
        return repesetery.getData(first, second);

    }

}
