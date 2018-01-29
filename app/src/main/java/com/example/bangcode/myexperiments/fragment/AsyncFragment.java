package com.example.bangcode.myexperiments.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bangcode.myexperiments.R;
import com.example.bangcode.myexperiments.activity.MyNavigation;
import com.example.bangcode.myexperiments.service.SimpleAsync;


public class AsyncFragment extends Fragment {
    private static final String TAG = AsyncFragment.class.getSimpleName();

    private static final String TEXT_STATE = "current_Text";


    private TextView mTextview;
    private Button button;
    private String myString="Hello World";


    public AsyncFragment() {
        // Required empty public constructor
    }


    public static AsyncFragment newInstance() {
        AsyncFragment fragment = new AsyncFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_async, container, false);


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MyNavigation) getActivity()).setActionBarTitle("Async");


        mTextview = view.findViewById(R.id.textview1);

//        if (savedInstanceState != null) {
//
//            Log.d(TAG, "onViewCreated: " + savedInstanceState.getString(TEXT_STATE));
//            mTextview.setText(savedInstanceState.getString(TEXT_STATE));
//        }

        mTextview.setText(myString);

        button = view.findViewById(R.id.buttonasync);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextview.setText("Napping ...");
                new SimpleAsync(mTextview,myString).execute();
                Log.d(TAG, "onClick: "+myString);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(TEXT_STATE, myString);

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

    }
}
