package com.example.parkinggo;


import android.icu.text.TimeZoneFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingDetails extends Fragment {
    String carNo,carModel;
    Date dateFrom, dateTo;
    String timeFrom, timeTo;
    TextView mcn, mcm,md,mt;
    BookingDetails(String cn, String cm, Date df, Date dt, String tf, String tt)
    {
       carNo=cn;
       carModel=cm;
       dateFrom=df;
       dateTo=dt;
       timeFrom=tf;
       timeTo=tt;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View v=inflater.inflate(R.layout.bookingdetails, container, false);
        mcn=v.findViewById(R.id.vnum);
        mcm=v.findViewById(R.id.vmodel);
        md=v.findViewById(R.id.bdate1);
        mcn.setText(carNo);
        mcm.setText(carModel);
        md.setText((new SimpleDateFormat().format(dateFrom))+"to"+(new SimpleDateFormat().format(dateTo)));
        mt.setText(timeFrom+" to "+timeTo);



        return v;

    }
}
