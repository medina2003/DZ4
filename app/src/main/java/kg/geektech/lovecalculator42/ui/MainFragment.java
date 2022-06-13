package kg.geektech.lovecalculator42.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import kg.geektech.lovecalculator42.network.App;
import kg.geektech.lovecalculator42.R;
import kg.geektech.lovecalculator42.databinding.FragmentMainBinding;
import kg.geektech.lovecalculator42.network.LoveModel;
import kg.geektech.lovecalculator42.viewmodel.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFragment extends Fragment {

    FragmentMainBinding binding;
    NavController navController;

    private final String HOST = "love-calculator.p.rapidapi.com";
    public static final String KEY = "5699688dc9msh809376b312571d4p1e9b63jsnf8f87e86c059";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment);
        initClickers();





        }

    private void initClickers() {
        binding.tryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromLaveApi();


            }
        });
    }

    private void getDataFromLaveApi() {
        String firstName = binding.firstNameEd.getText().toString();
        String secondName = binding.secondNameEd.getText().toString();
        NavController navController = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment);


        App.api.loveCalculator(firstName,secondName,HOST,KEY).enqueue(new Callback<LoveModel>() {

            @Override
            public void onResponse(Call<LoveModel> call, Response<LoveModel> response) {
                if (response.isSuccessful()) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("key",response.body());
                    navController.navigate(R.id.resultFragment,bundle);
//                    assert response.body() != null;
//                    String firstName = response.body().firstName;
//                    String secondName = response.body().secondName;
//                    String percentage = response.body().percentage;
//                    String resultNum = response.body().result;
//                    result.putString("firstName", firstName);
//                    result.putString("secondName", secondName);
//                    result.putString("result", resultNum);
//                    result.putString("percentage", percentage);

                }
            }

            @Override
            public void onFailure(Call<LoveModel> call, Throwable t) {
                Toast.makeText(requireActivity(), "Error:" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}