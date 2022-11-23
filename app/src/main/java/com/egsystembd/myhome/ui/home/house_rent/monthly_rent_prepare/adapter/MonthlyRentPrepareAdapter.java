package com.egsystembd.myhome.ui.home.house_rent.monthly_rent_prepare.adapter;

import android.app.AlertDialog;
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
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;


import com.egsystembd.myhome.R;
import com.egsystembd.myhome.model.house_rent.Deed;
import com.egsystembd.myhome.model.house_rent.Tenant;
import com.egsystembd.myhome.view_model.DeedViewModel;
import com.egsystembd.myhome.view_model.TenantViewModel;

import java.util.ArrayList;
import java.util.List;

public class MonthlyRentPrepareAdapter extends RecyclerView.Adapter<MonthlyRentPrepareAdapter.MonthlyRentPrepareViewHolder> {

    List<Tenant> tenants;
    List<Tenant> matchedMonthlyRentPrepares;
    Context context;
    DeedViewModel deedViewModel;

    public MonthlyRentPrepareAdapter(Context context, List<Tenant> tenants) {
        this.context = context;
        this.tenants = tenants;
        matchedMonthlyRentPrepares = new ArrayList<>(tenants);

        deedViewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(DeedViewModel.class);

    }

    public void searchMonthlyRentPrepare(List<Tenant> filteredMonthlyRentPrepares) {
        this.tenants = filteredMonthlyRentPrepares;
        notifyDataSetChanged();
    }

    @Override
    public MonthlyRentPrepareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MonthlyRentPrepareViewHolder(LayoutInflater.from(context).inflate(R.layout.single_item_tenant, parent, false));
    }

    @Override
    public void onBindViewHolder(MonthlyRentPrepareViewHolder holder, int position) {

        Tenant tenant = tenants.get(position);

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

        int id = tenant.id;
        Deed deed = deedViewModel.getSpecificDeed(id);


        holder.tv_name.setText(tenant.name);
        holder.tv_flat_no.setText("ফ্ল্যাট নংঃ " + deed.flat_id);
        holder.tv_total_rent.setText("মোট ভারাঃ " + deed.monthly_rent);
        holder.tv_total_payable_rent.setText("মোট প্রদেয় ভারাঃ " + "---");

        if (holder.tv_total_payable_rent.getText().toString().equalsIgnoreCase("মোট প্রদেয় ভারাঃ " + "---")){
            holder.tv_create_rent.setVisibility(View.VISIBLE);
            holder.tv_correction.setVisibility(View.GONE);
        }else {
            holder.tv_correction.setVisibility(View.VISIBLE);
            holder.tv_create_rent.setVisibility(View.GONE);
        }



//        if (note.taskType != null) {
//            if (note.taskType.equalsIgnoreCase("Completed")) {
//                holder.tv_type.setTextColor(context.getResources().getColor(R.color.green_700));
//            }
//        }

//        holder.itemView.setOnClickListener(v -> {
//            Intent intent = new Intent(context, UpdateMonthlyRentPrepareActivity.class);
//            intent.putExtra("note_id", note.id);
//            intent.putExtra("note_title", note.noteTitle);
//            intent.putExtra("note_sub_title", note.noteSubTitle);
//            intent.putExtra("note_date", note.noteDate);
//            intent.putExtra("note_priority", note.notePriority);
//            intent.putExtra("note_details", note.noteDetails);
//            context.startActivity(intent);
//        });

        holder.iv_more.setOnClickListener(v -> {
//            showPopUpMenu(v, position);
        });

    }

    @Override
    public int getItemCount() {
        Log.d("tag666", "note number in adapter: " + tenants.size());
        return tenants.size();
    }


//    public void showPopUpMenu(View view, int position) {
//        final MonthlyRentPrepare note = tenants.get(position);
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
//                                noteViewModel.deleteMonthlyRentPrepare(note.id);
//                            })
//                            .setNegativeButton(R.string.no, (dialog, which) -> dialog.cancel()).show();
//                    break;
//                case R.id.menuUpdate:
//
//                    Intent intent = new Intent(context, UpdateMonthlyRentPrepareActivity.class);
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

//            Tenant note1 = new Tenant();
//            note1.id = id;
//            note1.noteTitle = noteTitle;
//            note1.noteSubTitle = noteSubTitle;
//            note1.noteDate = noteDate;
//            note1.notePriority = notePriority;
//            note1.noteDetails = noteDetails;
//            note1.taskCompletionStatus = "Complete";
//
//            noteViewModel.updateTenant(note1);

            Toast.makeText(context, "MonthlyRentPrepare updated successfully", Toast.LENGTH_SHORT).show();

            dialog.dismiss();
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }


    class MonthlyRentPrepareViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name, tv_flat_no, tv_total_rent, tv_total_payable_rent, tv_correction, tv_create_rent;
        View view_note_priority;
        ImageView iv_more, iv_tick;

        public MonthlyRentPrepareViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_flat_no = itemView.findViewById(R.id.tv_flat_no);
            tv_total_rent = itemView.findViewById(R.id.tv_total_rent);
            tv_total_payable_rent = itemView.findViewById(R.id.tv_total_payable_rent);
            tv_correction = itemView.findViewById(R.id.tv_correction);
            tv_create_rent = itemView.findViewById(R.id.tv_create_rent);
            tv_create_rent = itemView.findViewById(R.id.tv_create_rent);


            iv_more = itemView.findViewById(R.id.iv_more);


        }
    }
}
