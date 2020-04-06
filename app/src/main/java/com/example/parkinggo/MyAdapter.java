package com.example.parkinggo;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;

import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    // private final Context mcontent;
    private RealmResults<Booking> mbooking;
    OnItemClickListener mlistener;

    public  MyAdapter(){}
    public MyAdapter(RealmResults<Booking> data,OnItemClickListener listener) {
        mbooking=data;
        mlistener=listener;
       // mbooking.addChangeListener((OrderedRealmCollectionChangeListener<RealmResults<Booking>>) this);
    }



    public interface OnItemClickListener
    {

        public void onItemClick(int position);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        Log.i("adapter","view holder called");
        return new MyViewHolder(view,mlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        Booking booking=mbooking.get(position);
        holder.carMod.setText(booking.getCarModel());
        holder.bookdate.setText(new SimpleDateFormat().format(booking.getDateFrom()));


        //holder.item.setBackgroundColor(Color.parseColor(task.getColor()));
        //Log.i("create","taskname : "+ task.getTaskName()+"checked : "+task.getChecked());
//        if(task.getChecked().equals("true")) {
//            Log.i("create","taskname : "+ task.getTaskName());
//            holder.button.setImageResource(R.drawable.mbuttoncheck);
//        }

       /* holder.button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //int pos=position;
                Realm realm= Realm.getDefaultInstance();
                realm.beginTransaction();
                Task task1=mtask.get(position);
                task1.deleteFromRealm();
                realm.commitTransaction();
                holder.button.setImageResource(R.drawable.ic_check_box1);
            }
        });*/
    }


    @Override
    public int getItemCount() {
        return mbooking.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //  private TextView ;
        private TextView carNo;
        private TextView carMod;
        private TextView bookdate;
        private RelativeLayout item;

        private OnItemClickListener mitem;

        public MyViewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);
            //carNo = itemView.findViewById(R.id.car_Number);
            carMod=itemView.findViewById(R.id.car_model);
            item=itemView.findViewById(R.id.background);
            bookdate=itemView.findViewById(R.id.date);
            mitem=listener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(getAdapterPosition()!=RecyclerView.NO_POSITION);
                    mitem.onItemClick(getAdapterPosition());
                }
            });

       }

        @Override
        public void onClick(View view) {
            if(getAdapterPosition()!=RecyclerView.NO_POSITION)
            { mitem.onItemClick(getAdapterPosition());}
            //button.setImageResource(R.drawable.mbuttoncheck);
                   /* if(x==1)
                        button.setImageResource(R.drawable.ic_check_box1);
                    else
                        button.setImageResource(R.drawable.ic_check_box);*/
        }


    }
}