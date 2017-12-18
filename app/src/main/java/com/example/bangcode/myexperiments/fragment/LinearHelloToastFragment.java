package com.example.bangcode.myexperiments.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bangcode.myexperiments.R;
import com.example.bangcode.myexperiments.activity.MyNavigation;


public class LinearHelloToastFragment extends Fragment {
    private static final String TAG = LinearHelloToastFragment.class.getSimpleName();


    private int mCount = 0;
    private TextView mShowCount;
    private Button showToast;
    private Button countUp;


    public LinearHelloToastFragment() {
        // Required empty public constructor
    }


    public static LinearHelloToastFragment newInstance() {
        LinearHelloToastFragment fragment = new LinearHelloToastFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState!=null){
            mCount=savedInstanceState.getInt("mycount",0);
//            mShowCount=getActivity().findViewById(R.id.show_count);
//            mShowCount.setText(Integer.toString(mCount));
//            Log.e(TAG, "onCreate: ");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello_toast, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MyNavigation)getActivity()).setActionBarTitle(getString(R.string.linear_hello_toast));



        mShowCount = view.findViewById(R.id.show_count);
        showToast = view.findViewById(R.id.button_toast);
        showToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast();
            }
        });



        countUp = view.findViewById(R.id.button_count);

        countUp.setOnTouchListener(new View.OnTouchListener() {
            private Handler mHandler;

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (mHandler != null) return true;
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, 500);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        mHandler = null;
                        break;
                }

                return false;
            }

            Runnable mAction = new Runnable() {
                @Override
                public void run() {
                    mCount++;
                    if (mShowCount != null)
                        mShowCount.setText(Integer.toString(mCount));
                    mHandler.postDelayed(this, 300);
                }
            };
        });


    }

    public void showToast() {
        Toast.makeText(getActivity(), getString(R.string.hello_toast), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mycount",mCount);
    }
}
