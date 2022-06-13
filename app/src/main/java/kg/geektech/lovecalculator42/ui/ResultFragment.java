package kg.geektech.lovecalculator42.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import kg.geektech.lovecalculator42.R;
import kg.geektech.lovecalculator42.databinding.FragmentMainBinding;
import kg.geektech.lovecalculator42.databinding.FragmentResultBinding;
import kg.geektech.lovecalculator42.network.LoveModel;


public class ResultFragment extends Fragment {
    FragmentResultBinding binding;
    NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            LoveModel loveModel = (LoveModel) bundle.getSerializable("key");
            binding.named1.setText(loveModel.firstName);
            binding.named2.setText(loveModel.secondName);

            binding.result.setText(loveModel.percentage);
            binding.buttonBtn.setText(loveModel.result);
            binding.result.setText(loveModel.percentage+"%");

          //  getResult();
            initClick();
        }
//        String percentage = getArguments().getString("100%","99%");
//        binding.result.setText(percentage);

        navController = NavHostFragment.findNavController(this);
        binding.buttonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigateUp();

            }
        });
    }



    private void initClick() {
        binding.buttonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.mainFragment);
                navController.navigateUp();

            }
        });

    }
}

//    private void getResult() {
//        assert getArguments() != null;
//        String fName = getArguments().getString("fName");
//        String sName = getArguments().getString("sName");
//        String result = getArguments().getString("result");
//        String percentage = getArguments().getString("percentage");
//
//        binding.named1.setText(fName);
//        binding.named2.setText(sName);
//        if (result.equals(result)) {
//            binding.result.setText(result);
//        } else if (result.equals(result)) {
//            binding.result.setText(result);
//        } else if (result.equals(result)) {
//            binding.result.setText(result);
//
//
//        }
//        binding.result.setText(percentage+" %");
//    }
//}




