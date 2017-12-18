package com.example.bangcode.myexperiments.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bangcode.myexperiments.R;
import com.example.bangcode.myexperiments.activity.MyNavigation;


public class SpinnerFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private static final String TAG = SpinnerFragment.class.getSimpleName();

    private Spinner spinner;
    private String mSpinnerLabel = "";
    private EditText editText;
    private TextView phoneNumberResult;

    public SpinnerFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SpinnerFragment newInstance() {
        SpinnerFragment fragment = new SpinnerFragment();
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
        return inflater.inflate(R.layout.fragment_spinner, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MyNavigation)getActivity()).setActionBarTitle(getString(R.string.spinner));
        editText= view.findViewById(R.id.editext_spinner);
        phoneNumberResult = view.findViewById(R.id.text_phone_label);
        spinner = view.findViewById(R.id.label_spinner);

        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this.getActivity(),
                R.array.labels_array,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        if (spinner != null){
            spinner.setAdapter(adapter);
        }



    }

    public void showText(View view) {

        if (editText != null) {

            String showString = (editText.getText().toString() + " - " + mSpinnerLabel);

            if (phoneNumberResult != null) phoneNumberResult.setText(showString);
        }


    }


    //    adapter

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mSpinnerLabel = parent.getItemAtPosition(position).toString();
        showText(view);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d(TAG, "onNothingSelected: ");
    }
}
