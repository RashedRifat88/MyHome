//package com.egsystembd.myhome.ui.home.house_rent.monthly_rent_prepare.adapter;
//
//
//import android.content.Context;
//import android.database.Cursor;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//import com.egsystembd.myhome.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MonthlyRentPrepareAdapter extends RecyclerView.Adapter<MonthlyRentPrepareAdapter.MonthlyRentPrepareViewHolder> {
//
//    private List<String> dataSet = new ArrayList<>();
//    private List<MonthlyRentPrepareModel.AppointmentResponse> appointmentList = new ArrayList<>();
//    private List<String> popularTopicTitleList = new ArrayList<>();
//    private List<String> popularTopicPriceList = new ArrayList<>();
//    private boolean allItemStatus = false;
//    Context context;
//    String from_where = "";
//
//    Cursor dataCursor;
//
////    private List<String> favTopicList = new ArrayList<>();
//
//
//    String categoryName = "";
//
//    String title;
//    String category_id;
//    private List<String> memberListFiltered = new ArrayList<>();
//
//
//    private AdapterCallback adapterCallback;
//
//    public MonthlyRentPrepareAdapter(Context context) {
//        this.context = context;
//
//        try {
//            adapterCallback = ((AdapterCallback) context);
//        } catch (ClassCastException e) {
////            throw new ClassCastException("Activity must implement AdapterCallback.", e);
//        }
//
//    }
//
//
//    public MonthlyRentPrepareAdapter(Context context, Cursor cursor) {
//        dataCursor = cursor;
//        this.context = context;
//        Log.d("tag1wwwww", " adapter: ");
//    }
//
//
//    public void setData(List<MonthlyRentPrepareModel.AppointmentResponse> appointmentList, String from_where) {
//        this.appointmentList = appointmentList;
//        this.from_where = from_where;
//        Log.d("tagResponse", " appointmentList: " + appointmentList);
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return appointmentList.size();
//    }
//
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//
//    @Override
//    public MonthlyRentPrepareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.single_item_monthly_rent_prepare_list, parent, false);
//        MonthlyRentPrepareViewHolder myViewHolder = new MonthlyRentPrepareViewHolder(view);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                listener.onItemClick(v, myViewHolder.getPosition());
//            }
//        });
//        return myViewHolder;
//    }
//
//
//    @Override
//    public void onBindViewHolder(final MonthlyRentPrepareAdapter.MonthlyRentPrepareViewHolder holder, int position) {
//        TextView txtSlNo = holder.txtSlNo;
//        TextView tv1 = holder.tv1;
//        TextView tv2 = holder.tv2;
//        TextView tv3 = holder.tv3;
//        TextView tv4 = holder.tv4;
//        TextView tv_price = holder.tv_price;
//        TextView tv_remove_item = holder.tv_remove_item;
//        LinearLayout linear1 = holder.linear1;
//        RelativeLayout relative1 = holder.relative1;
//        ImageView imageView = holder.imageView;
//        ImageView imageViewTick = holder.imageViewTick;
//        CardView card1 = holder.card1;
//
//
////        imageView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_transition_animation));
////        cardview.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fall_down_animation));
//
//
//        MonthlyRentPrepareModel.AppointmentResponse appointment = appointmentList.get(position);
//
//
//        String date = appointment.getDate();
//        String doctorName = appointment.getDoctor();
//        String aStatus = appointment.getStatus();
//        String hospital = "";
//
//        tv1.setText("Dr. " + doctorName);
//        tv2.setText(date);
//        tv3.setText( "Status: " +  aStatus);
//        tv4.setText(date);
//
//
//
//
////        Glide.with(context).load(imageLink).into(imageView);
//
//        card1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////                Intent intent = new Intent(context, PopularProgrammsDetailsActivity.class);
////                context.startActivity(intent);
//
////                boolean wrapInScrollView = true;
////                MaterialDialog dialog = new MaterialDialog.Builder(context)
////                        .customView(R.layout.material_dialog_appointment_view, wrapInScrollView)
////                        .build();
////
////                TextView tv_name_dialog = dialog.getCustomView().findViewById(R.id.tv_name);
////                TextView tv_desig_dialog = dialog.getCustomView().findViewById(R.id.tv_desig);
////                ImageView iv_dialog = dialog.getCustomView().findViewById(R.id.iv_dialog);
////
////                tv_name_dialog.setText(title);
////
////                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
////                    tv_desig_dialog.setText(Html.fromHtml(designation, Html.FROM_HTML_MODE_COMPACT));
////                } else {
////                    tv_desig_dialog.setText(Html.fromHtml(designation));
////                }
//////                tv_desig_dialog.setText(designation);
////                Glide.with(context).load(imageLink).into(iv_dialog);
////
////                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
////                WindowManager.LayoutParams wmlp = dialog.getWindow()
////                        .getAttributes();
////                wmlp.width = WindowManager.LayoutParams.MATCH_PARENT;
////                wmlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
////                dialog.show();
////
////                dialog.setCancelable(true);
////                dialog.setCanceledOnTouchOutside(true);
//
//
//            }
//        });
//
//
//    }
//
//
//    class MonthlyRentPrepareViewHolder extends RecyclerView.ViewHolder {
//
//        TextView txtSlNo;
//        TextView tv1;
//        TextView tv2;
//        TextView tv3;
//        TextView tv4;
//
//        TextView tv_price;
//        TextView tv_remove_item;
//        LinearLayout linear1;
//        RelativeLayout relative1;
//
//        ImageView imageView;
//        ImageView imageViewTick;
//        CardView card1;
//
//        public MonthlyRentPrepareViewHolder(View itemView) {
//            super(itemView);
//            tv1 = itemView.findViewById(R.id.tv1);
//            tv2 = itemView.findViewById(R.id.tv2);
//            tv3 = itemView.findViewById(R.id.tv3);
//            tv4 = itemView.findViewById(R.id.tv4);
//            imageView = itemView.findViewById(R.id.imageView);
//            relative1 = itemView.findViewById(R.id.relative1);
//            linear1 = itemView.findViewById(R.id.linear1);
//            card1 = itemView.findViewById(R.id.card1);
//
//        }
//    }
//
//
////    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
////    public void filter(CharSequence charText) {
////
////        List<String> filteredList = new ArrayList<>();
////        String charString = charText.toString();
////
////        if (charString.length() == 0) {
////////         memberListFiltered = dataSet;
//////         filteredList.addAll(dataSet);
////            Log.i("tag", String.valueOf("1:  "+charString.length())+dataSet);
////
////
////        }
////
////        if (charString.isEmpty() || charString.equalsIgnoreCase("")) {
////            memberListFiltered = titleList;
////        } else {
//////         List<MemberInfoModel.Result> filteredList = new ArrayList<>();
////            for (String row : titleList) {
////                if (
////                        row.toLowerCase().contains(charString.toLowerCase())
//////                                ||
//////                                row.getMobile().toLowerCase().contains(charString.toLowerCase())
//////                                ||
//////                                row.getYear().toLowerCase().contains(charString.toLowerCase())
//////                                ||
//////                                row.getMember_id_String().toLowerCase().contains(charString.toLowerCase())
//////                             ||
//////                             row.getTakaAmount().toLowerCase().contains(charString.toLowerCase()) ||
//////                             row.getPaymentStatus().toLowerCase().contains(charString.toLowerCase())
////                ) {
////                    filteredList.add(row);
////                }
////            }
////
////            Log.i("tag", "2:  "+String.valueOf(charString.length())+filteredList);
////
////            memberListFiltered = filteredList;
////        }
////
//////     Filter.FilterResults filterResults = new Filter.FilterResults();
//////     filterResults.values = memberListFiltered;
////        this.setData(memberListFiltered, memberListFiltered, memberListFiltered);
////        this.notifyDataSetChanged();
////    }
//
//
//    public interface AdapterCallback {
//        void onMethodCallback(List<String> favTopicList);
//
//        void onMethodCallback();
//    }
//
//
//}
//
