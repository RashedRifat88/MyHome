package com.egsystembd.myhome.adapter;

import static android.content.Context.CLIPBOARD_SERVICE;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import com.egsystembd.myhome.R;
import com.egsystembd.myhome.model.daily_expense.ExpenseType;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTypeAdapter extends RecyclerView.Adapter<ExpenseTypeAdapter.ExpenseTypeViewHolder> {

    List<ExpenseType> taskTypes;
    List<ExpenseType> matchedExpenseTypes;
    Context context;
    private ClipboardManager clipboardManager;
    private ClipData clipData;

    private AdapterCallback adapterCallback;


    public ExpenseTypeAdapter(Context context, List<ExpenseType> taskTypes) {
        this.context = context;
        this.taskTypes = taskTypes;
        matchedExpenseTypes = new ArrayList<>(taskTypes);

        clipboardManager = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);

        try {
            adapterCallback = ((AdapterCallback) context);
        } catch (ClassCastException e) {
//            throw new ClassCastException("Activity must implement AdapterCallback.", e);
        }

    }

    public void searchExpenseType(List<ExpenseType> filteredExpenseTypes) {
        this.taskTypes = filteredExpenseTypes;
        notifyDataSetChanged();
    }

    @Override
    public ExpenseTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ExpenseTypeViewHolder(LayoutInflater.from(context).inflate(R.layout.single_item_expense_types, parent, false));
    }

    @Override
    public void onBindViewHolder(ExpenseTypeViewHolder holder, int position) {

        ExpenseType type = taskTypes.get(position);

        holder.tv_title.setText(type.name);

    }

    @Override
    public int getItemCount() {
        Log.d("tag666", "note number in adapter: " + taskTypes.size());
        return taskTypes.size();
    }


    public void checkBox_addData(View view, int position) {
        final ExpenseType note = taskTypes.get(position);

        adapterCallback.onMethodCallback(note, position, "add_item");
    }

    public void checkBox_removeData(View view, int position) {
        final ExpenseType note = taskTypes.get(position);

        adapterCallback.onMethodCallback(note, position, "remove_item");
    }


    public void copyTextInClip(String clipText, String forWhom) {

        clipData = ClipData.newPlainText("text", clipText);
        clipboardManager.setPrimaryClip(clipData);

//        Toast.makeText(context,  forWhom +"Text Copied", Toast.LENGTH_SHORT).show();
        Toast.makeText(context, forWhom + " Text Copied", Toast.LENGTH_SHORT).show();

    }


    class ExpenseTypeViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title, tv_sub_title, tv_date, tv_type, tv_details;
        View view_note_priority;

        ImageView iv_more;
        CheckBox cb_select;

        public ExpenseTypeViewHolder(View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);

        }
    }


    public interface AdapterCallback {
        void onMethodCallback(ExpenseType note, int position, String whatToDo);
    }



}
