package com.egsystembd.myhome.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.egsystembd.myhome.R;
import com.egsystembd.myhome.databinding.FragmentHomeBinding;
import com.egsystembd.myhome.model.house_rent.DivisionDistrictThana;
import com.egsystembd.myhome.model.house_rent.Months;
import com.egsystembd.myhome.ui.home.house_rent.HouseRentActivity;
import com.egsystembd.myhome.view_model.DivisionDistrictThanaViewModel;
import com.egsystembd.myhome.view_model.MonthsViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    DivisionDistrictThanaViewModel divisionDistrictThanaViewModel;
    MonthsViewModel monthsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initComponents();
        adSlider();

        divisionDistrictThanaViewModel = new ViewModelProvider(this).get(DivisionDistrictThanaViewModel.class);
//        divisionDistrictThanaViewModel.deleteAllDivisionDistrictThana();

        divisionDistrictThanaViewModel.getAllDivisionDistrictThana.observe(getActivity(), dataList -> {
            if (dataList.isEmpty()) {
                loadDivisionData();
            }
        });


        monthsViewModel = new ViewModelProvider(this).get(MonthsViewModel.class);
//        monthViewModel.deleteAllMonth();

        monthsViewModel.getAllMonth.observe(getActivity(), dataList -> {
            if (dataList.isEmpty()) {
                loadMonthData();
            }
        });

        return root;
    }

    private void initComponents() {

        binding.cardHouseRent.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), HouseRentActivity.class);
            getActivity().startActivity(intent);
        });
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


    private void loadDivisionData() {

        JSONArray divisions = loadJSONArray_division(getActivity());

        try {
            for (int i = 0; i < divisions.length(); i++) {
                JSONObject division = divisions.getJSONObject(i);

                String division_name = division.getString("name");
                String division_name_bn = division.getString("bn_name");

                JSONArray districtArray = division.getJSONArray("districts");

                Log.d("tagTTT", "division_name: " + division_name);

                for (int j = 0; j < districtArray.length(); j++) {

                    JSONObject district = districtArray.getJSONObject(j);

                    String district_name = district.getString("name");
                    String district_name_bn = district.getString("bn_name");
                    Log.d("tagTTT", "district_name: " + district_name);


                    JSONArray thanaArray = district.getJSONArray("upazilas");


                    for (int k = 0; k < thanaArray.length(); k++) {

                        JSONObject thana = thanaArray.getJSONObject(k);

                        String thana_name = thana.getString("name");
                        String thana_name_bn = thana.getString("bn_name");
                        Log.d("tagTTT", "thana_name: " + thana_name);

                        DivisionDistrictThana obj1 = new DivisionDistrictThana();
                        obj1.division = division_name;
                        obj1.division_bn = division_name_bn;
                        obj1.district = district_name;
                        obj1.district_bn = district_name_bn;
                        obj1.thana = thana_name;
                        obj1.thana_bn = thana_name_bn;

                        divisionDistrictThanaViewModel.insertDivisionDistrictThana(obj1);

                    }

                }


//                Toast.makeText(this, "DivisionDistrictThana created successfully", Toast.LENGTH_SHORT).show();


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public static JSONArray loadJSONArray_division(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = context.getResources().openRawResource(R.raw.division_district_thana);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            return jsonObject.getJSONArray("division_list");

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;
    }



    private void loadMonthData() {

        JSONArray months = loadJSONArray_month(getActivity());

        try {
            for (int i = 0; i < months.length(); i++) {
                JSONObject month = months.getJSONObject(i);

                String month_id = month.getString("id");
                String month_name = month.getString("name");
                String month_name_bn = month.getString("bn_name");

                Months obj1 = new Months();
                obj1.month_id = Integer.parseInt(month_id);
                obj1.month_name = month_name;
                obj1.month_name_bn = month_name_bn;

                monthsViewModel.insertMonth(obj1);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static JSONArray loadJSONArray_month(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = context.getResources().openRawResource(R.raw.month);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            return jsonObject.getJSONArray("month_list");

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


}