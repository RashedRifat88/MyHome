package com.egsystembd.myhome.ui.emergency_service_call;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.egsystembd.myhome.databinding.FragmentEmergencyServiceCallBinding;


public class EmergencyServiceCallFragment extends Fragment {

    private FragmentEmergencyServiceCallBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentEmergencyServiceCallBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}