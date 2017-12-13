package com.example.bangcode.myexperiments.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bangcode.myexperiments.R;


public class ConstraintHelloToastFragment extends Fragment implements View.OnClickListener{
    private int mCount=0;
    private TextView mShowCount;
    private Button showToast;
    private Button countUp;


    public ConstraintHelloToastFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ConstraintHelloToastFragment newInstance() {
        ConstraintHelloToastFragment fragment = new ConstraintHelloToastFragment();
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
        return inflater.inflate(R.layout.fragment_constraint_hello_toast, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(getString(R.string.constraint_hello_toast));

        mShowCount=view.findViewById(R.id.show_count_constraint);
        showToast=view.findViewById(R.id.button_toast_constraint);
        showToast.setOnClickListener(this);

        countUp=view.findViewById(R.id.button_count_constraint);
        countUp.setOnClickListener(this);
    }

    public void countUp(View view){
        mCount++;
        if(mShowCount !=null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void showToast(View view){
        Toast.makeText(getActivity(),getString(R.string.hello_toast),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_count_constraint:
                countUp(v);
                break;
            case R.id.button_toast_constraint:
                showToast(v);
                break;
        }
    }
}
