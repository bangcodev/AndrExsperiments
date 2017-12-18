package com.example.bangcode.myexperiments.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.bangcode.myexperiments.R;
import com.example.bangcode.myexperiments.activity.MyNavigation;


public class AsyncInternetFragment extends Fragment {

    private Button button;
    EditText editText;
    String queryString;


    public AsyncInternetFragment() {
        // Required empty public constructor
    }


    public static AsyncInternetFragment newInstance() {
        AsyncInternetFragment fragment = new AsyncInternetFragment();
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
        return inflater.inflate(R.layout.fragment_async_internet, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MyNavigation)getActivity()).setActionBarTitle("Async internet");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryString = editText.getText().toString();
            }
        });
    }
}
