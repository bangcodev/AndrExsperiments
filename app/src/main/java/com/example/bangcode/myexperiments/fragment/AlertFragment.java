package com.example.bangcode.myexperiments.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.bangcode.myexperiments.R;
import com.example.bangcode.myexperiments.activity.MyNavigation;


public class AlertFragment extends Fragment {
    public static final String TAG= AlertFragment.class.getSimpleName();

    public AlertFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static AlertFragment newInstance() {
        AlertFragment fragment = new AlertFragment();
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
        return inflater.inflate(R.layout.fragment_alert, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MyNavigation)getActivity()).setActionBarTitle("Alert Dialog");

        Button button = view.findViewById(R.id.button_alert);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickShowAlert();
            }
        });


    }


    public void onClickShowAlert(){
        AlertDialog.Builder builder = new
                AlertDialog.Builder(this.getActivity());

        builder.setTitle(R.string.alert);
        builder.setMessage(R.string.alertMessage);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), R.string.pressed_ok,
                        Toast.LENGTH_SHORT).show();
            }
        });


        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), R.string.pressed_cancel,
                        Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();

    }
}
