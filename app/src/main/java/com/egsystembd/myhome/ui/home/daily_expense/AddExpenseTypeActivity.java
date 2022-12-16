package com.egsystembd.myhome.ui.home.daily_expense;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.egsystembd.myhome.R;
import com.egsystembd.myhome.adapter.ExpenseTypeAdapter;
import com.egsystembd.myhome.databinding.ActivityAddDailyExpenseBinding;
import com.egsystembd.myhome.databinding.ActivityAddExpenseTypeBinding;
import com.egsystembd.myhome.model.daily_expense.ExpenseType;
import com.egsystembd.myhome.view_model.daily_expense.ExpenseTypeViewModel;
import com.egsystembd.myhome.view_model.daily_expense.ExpenseViewModel;

import java.util.Date;
import java.util.List;

public class AddExpenseTypeActivity extends AppCompatActivity {

    private ActivityAddExpenseTypeBinding binding;

    View rootView;
    TextView tv_cross, tv_create_new_expense;
    ImageView img_back;
    ExpenseTypeAdapter adapter;

    ExpenseTypeViewModel expenseTypeViewModel;
    List<ExpenseType> expenseTypeList;

//    boolean isPreloadedDataInserted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_expense_type);

        binding = ActivityAddExpenseTypeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initComponents();

        expenseTypeViewModel = new ViewModelProvider(this).get(ExpenseTypeViewModel.class);

        expenseTypeViewModel.getAllExpenseType.observe(this, expenseTypes -> {
            setAdapter(expenseTypes);
//            filteredNoteList = notes;
        });

    }


    private void initComponents() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

//        expenseTypeViewModel.getExpenseType.observe(this, expenseTypes -> {
//            setAdapter(expenseTypes);
//
//        });


        binding.tvCreateNewTask.setOnClickListener(v -> {
            final EditText et_expense_type = new EditText(this);
            et_expense_type.setHint("খরচের ধরণ");

            new AlertDialog.Builder(this)
                    .setTitle("খরচের ধরণ")
                    .setMessage("খরচের ধরণ এড করুন")
                    .setView(et_expense_type)
                    .setPositiveButton("Create", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {

                            String expenseTypeName = et_expense_type.getText().toString();
                            addExpenseType(expenseTypeName);

                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                        }
                    })
                    .show();

        });


    }

    private void setAdapter(List<ExpenseType> expenseTypes) {

        Log.d("tag666", "note number: " + expenseTypes.size());
        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter = new ExpenseTypeAdapter(this, expenseTypes);
        binding.recyclerView.setAdapter(adapter);
    }

    private void addExpenseType(String expenseTypeName) {
        Date date = new Date();
        CharSequence sequence = DateFormat.format("MMMM d,yyyy", date.getTime());

        ExpenseType expenseType1 = new ExpenseType();
        expenseType1.name = expenseTypeName;

        expenseTypeViewModel.insertExpenseType(expenseType1);

    }




}