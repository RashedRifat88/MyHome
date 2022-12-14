package com.egsystembd.myhome.ui.home.daily_expense.adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.egsystembd.myhome.R;
import com.egsystembd.myhome.model.daily_expense.Expense;
import com.egsystembd.myhome.model.house_rent.Deed;

import com.egsystembd.myhome.ui.home.daily_expense.DailyExpenseDetailsActivity;
import com.egsystembd.myhome.ui.home.daily_expense.EditDailyExpenseActivity;
import com.egsystembd.myhome.view_model.DeedViewModel;
import com.egsystembd.myhome.view_model.RentCollectionViewModel;

import java.util.ArrayList;
import java.util.List;

public class DailyExpenseAdapter extends RecyclerView.Adapter<DailyExpenseAdapter.DailyExpenseViewHolder> {

    List<Expense> expenses;
    List<Expense> matchedExpenses;
    Context context;
    DeedViewModel deedViewModel;
    RentCollectionViewModel rentCollectionViewModel;
    String date1 = "";
    String date2 = "";

    public DailyExpenseAdapter(Context context, List<Expense> expenses) {
        this.context = context;
        this.expenses = expenses;
        matchedExpenses = new ArrayList<>(expenses);

        deedViewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(DeedViewModel.class);

    }

    public void searchExpense(List<Expense> filteredExpenses) {
        this.expenses = filteredExpenses;
        notifyDataSetChanged();
    }

    @Override
    public DailyExpenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DailyExpenseViewHolder(LayoutInflater.from(context).inflate(R.layout.single_item_expense, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(DailyExpenseViewHolder holder, int position) {

        Expense expense = expenses.get(position);

//        switch (note.notePriority) {
//            case "1":
//                holder.view_note_priority.setBackgroundResource(R.drawable.circle_shape_green);
//                break;
//            case "2":
//                holder.view_note_priority.setBackgroundResource(R.drawable.circle_shape_yellow);
//                break;
//            case "3":
//                holder.view_note_priority.setBackgroundResource(R.drawable.circle_shape_red);
//                break;
//        }
//
//        if (note.taskCompletionStatus != null) {
//
//            Log.d("tag666", "note.taskCompletionStatus adapter: " + note.taskCompletionStatus);
//            if (note.taskCompletionStatus.equalsIgnoreCase("Complete")) {
//                holder.iv_tick.setVisibility(View.VISIBLE);
//            } else {
//                holder.iv_tick.setVisibility(View.GONE);
//            }
//
//        }

        int id = expense.id;
        String id1 = String.valueOf(id);
        Deed deed = deedViewModel.getSpecificDeed(id);

//        rentCollectionViewModel.getAllRentCollection.observe((LifecycleOwner) context, dataList -> {
//            if (!dataList.isEmpty()) {
//                RentCollection rentCollection = rentCollectionViewModel.getSpecificRentCollection(id);
//                holder.tv_total_payable_rent.setText("মোট প্রদেয় ভারাঃ   " + rentCollection.total_payable_rent);
//            }
//        });


//        Log.d("tag666", "rentCollection: " + rentCollection.total_payable_rent);

        int sl = position + 1;

        if (sl == 1) {
            date1 = expense.date;
        }else {
            date2 = expense.date;
        }

        if (sl == 1) {
            holder.relative_date.setVisibility(View.VISIBLE);
        } else {
            if (date1.equalsIgnoreCase(date2)) {
                holder.relative_date.setVisibility(View.GONE);
            } else {
                holder.relative_date.setVisibility(View.VISIBLE);
                date1 = date2;
            }
        }


        Log.d("tag666", "date1: " + date1);
        Log.d("tag666", "date2: " + date2);

        holder.tv_sl.setText(String.valueOf(sl));
        holder.tv_date.setText(expense.date);
        holder.tv_amount.setText(String.valueOf("\u09F3 " + expense.amount));
        holder.tv_expense_type.setText(expense.expense_name);


        holder.tv_date2.setText(expense.date);
        holder.tv_date_total.setText(expense.expense_name);


        holder.tv_details.setOnClickListener(v -> {
            Intent intent = new Intent(context, DailyExpenseDetailsActivity.class);
            intent.putExtra("expense_id", id1);
            context.startActivity(intent);
        });

        holder.tv_edit.setOnClickListener(v -> {
            Intent intent2 = new Intent(context, EditDailyExpenseActivity.class);
            intent2.putExtra("expense_id", id1);
            context.startActivity(intent2);
        });


//        if (note.taskType != null) {
//            if (note.taskType.equalsIgnoreCase("Completed")) {
//                holder.tv_type.setTextColor(context.getResources().getColor(R.color.green_700));
//            }
//        }

//        holder.itemView.setOnClickListener(v -> {
//            Intent intent = new Intent(context, UpdateExpenseActivity.class);
//            intent.putExtra("note_id", note.id);
//            intent.putExtra("note_title", note.noteTitle);
//            intent.putExtra("note_sub_title", note.noteSubTitle);
//            intent.putExtra("note_date", note.noteDate);
//            intent.putExtra("note_priority", note.notePriority);
//            intent.putExtra("note_details", note.noteDetails);
//            context.startActivity(intent);
//        });

//        holder.iv_more.setOnClickListener(v -> {
////            showPopUpMenu(v, position);
//        });

    }

    @Override
    public int getItemCount() {
        Log.d("tag666", "note number in adapter: " + expenses.size());
        return expenses.size();
    }


//    public void showPopUpMenu(View view, int position) {
//        final Expense note = expenses.get(position);
//        PopupMenu popupMenu = new PopupMenu(context, view);
//
//        if (note.taskCompletionStatus != null) {
//            if (note.taskCompletionStatus.equalsIgnoreCase("Complete")) {
//                popupMenu.getMenuInflater().inflate(R.menu.menu_task_options2, popupMenu.getMenu());
//            } else {
//                popupMenu.getMenuInflater().inflate(R.menu.menu_task_options, popupMenu.getMenu());
//            }
//        }else {
//            popupMenu.getMenuInflater().inflate(R.menu.menu_task_options, popupMenu.getMenu());
//        }
//
//        popupMenu.setOnMenuItemClickListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.menuDelete:
//                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context, R.style.AppTheme_Dialog);
//                    alertDialogBuilder.setTitle(R.string.delete_confirmation).setMessage(R.string.sureToDelete).
//                            setPositiveButton(R.string.yes, (dialog, which) -> {
////                                deleteTaskFromId(note.getTaskId(), position);
//                                noteViewModel.deleteExpense(note.id);
//                            })
//                            .setNegativeButton(R.string.no, (dialog, which) -> dialog.cancel()).show();
//                    break;
//                case R.id.menuUpdate:
//
//                    Intent intent = new Intent(context, UpdateExpenseActivity.class);
//                    intent.putExtra("note_id", note.id);
//                    intent.putExtra("note_title", note.noteTitle);
//                    intent.putExtra("note_sub_title", note.noteSubTitle);
//                    intent.putExtra("note_date", note.noteDate);
//                    intent.putExtra("note_priority", note.notePriority);
//                    intent.putExtra("note_details", note.noteDetails);
//                    context.startActivity(intent);
//
//                    break;
//                case R.id.menuComplete:
//                    AlertDialog.Builder completeAlertDialog = new AlertDialog.Builder(context, R.style.AppTheme_Dialog);
//                    completeAlertDialog.setTitle(R.string.confirmation).setMessage(R.string.sureToMarkAsComplete)
//                            .setPositiveButton(R.string.yes, (dialog, which) -> showCompleteDialog(note.id, note.noteTitle, note.noteSubTitle, note.noteDate,
//                                    note.notePriority, note.noteDetails, position))
//                            .setNegativeButton(R.string.no, (dialog, which) -> dialog.cancel()).show();
//                    break;
//            }
//            return false;
//        });
//        popupMenu.show();
//    }

    public void showCompleteDialog(int id, String noteTitle, String noteSubTitle, String noteDate, String notePriority, String noteDetails, int position) {
        Dialog dialog = new Dialog(context, R.style.AppTheme_Dialog);
        dialog.setContentView(R.layout.layout_dialog_completed);
        Button close = dialog.findViewById(R.id.closeButton);
        close.setOnClickListener(view -> {

//            Expense note1 = new Expense();
//            note1.id = id;
//            note1.noteTitle = noteTitle;
//            note1.noteSubTitle = noteSubTitle;
//            note1.noteDate = noteDate;
//            note1.notePriority = notePriority;
//            note1.noteDetails = noteDetails;
//            note1.taskCompletionStatus = "Complete";
//
//            noteViewModel.updateExpense(note1);

            Toast.makeText(context, "Expense updated successfully", Toast.LENGTH_SHORT).show();

            dialog.dismiss();
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }


    class DailyExpenseViewHolder extends RecyclerView.ViewHolder {

        TextView tv_sl, tv_date, tv_amount, tv_expense_type, tv_edit, tv_details, tv_date2, tv_date_total;
        View view_note_priority;
        ImageView iv_more, iv_tick;
        RelativeLayout relative_date;

        public DailyExpenseViewHolder(View itemView) {
            super(itemView);

            tv_sl = itemView.findViewById(R.id.tv_sl);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_amount = itemView.findViewById(R.id.tv_amount);
            tv_expense_type = itemView.findViewById(R.id.tv_expense_type);
            tv_date2 = itemView.findViewById(R.id.tv_date2);
            tv_date_total = itemView.findViewById(R.id.tv_date_total);

            tv_edit = itemView.findViewById(R.id.tv_edit);
            tv_details = itemView.findViewById(R.id.tv_details);
//            tv_details = itemView.findViewById(R.id.tv_details);


            iv_more = itemView.findViewById(R.id.iv_more);

            relative_date = itemView.findViewById(R.id.relative_date);

        }
    }
}
