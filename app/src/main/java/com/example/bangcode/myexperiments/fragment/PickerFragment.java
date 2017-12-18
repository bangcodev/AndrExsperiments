package com.example.bangcode.myexperiments.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bangcode.myexperiments.R;
import com.example.bangcode.myexperiments.activity.MyNavigation;

public class PickerFragment extends Fragment implements View.OnClickListener{
    public static final String TAG = PickerFragment.class.getSimpleName();


    public PickerFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PickerFragment newInstance() {
        PickerFragment fragment = new PickerFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_picker, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button dateButton;
        Button timeButton;

        ((MyNavigation)getActivity()).setActionBarTitle("Picker");


        dateButton = view.findViewById(R.id.button_date);
        timeButton = view.findViewById(R.id.button_time);

       dateButton.setOnClickListener(this);
       timeButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_date:
                DialogFragment dateFragment = new DateFragment();
                dateFragment.show(getChildFragmentManager(),
                        getString(R.string.date_picker));
                break;
            case R.id.button_time:
                DialogFragment timeFragment = new TimeFragment();
                timeFragment.show(getChildFragmentManager(),
                        getString(R.string.time_picker));
                break;
        }
    }
}
