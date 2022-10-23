package com.egsystembd.myhome.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.egsystembd.myhome.R;
import com.egsystembd.myhome.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        adSlider();

        return root;
    }


    private void adSlider() {

        ArrayList<SlideModel> imageList = new ArrayList<>();

        imageList.add(new SlideModel(R.drawable.medical, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.admission, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.service, ScaleTypes.FIT));

        binding.imageSlider.setImageList(imageList);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}