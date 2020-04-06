package com.example.parkinggo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.Realm;
import io.realm.RealmResults;

public class PrevListFragment extends Fragment implements MyAdapter.OnItemClickListener {
    RealmResults<Booking> mbooking;
    static int count;

    PrevListFragment(RealmResults<Booking> results) {
        mbooking = results;
        count = 0;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_prevlist, container, false);
        RecyclerView recyclerView = (RecyclerView) rootview.findViewById(R.id.booking_recyclerview);
        // recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyAdapter mAdapter = new MyAdapter(mbooking, this);
        recyclerView.setAdapter(mAdapter);
        return rootview;
    }






    public void onItemClick(int position)
    {
        Booking b=mbooking.get(position);
        FragmentTransaction ft=getActivity().getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frame_container,new BookingDetails(b.getCarNo(),b.getCarModel(),b.getDateFrom(),b.getDateTo(),b.getTimeFrom(),b.getTimeTo()));
        ft.addToBackStack(null);
        ft.commit();
    }

}