package com.example.bangcode.myexperiments.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bangcode.myexperiments.R;
import com.example.bangcode.myexperiments.activity.MyNavigation;


public class KeyboardSampleFragment extends Fragment {
    EditText editText;
    Button button;

    public KeyboardSampleFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static KeyboardSampleFragment newInstance() {
        KeyboardSampleFragment fragment = new KeyboardSampleFragment();
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
        return inflater.inflate(R.layout.fragment_keyboard_sample, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MyNavigation)getActivity()).setActionBarTitle("Keyboard Sample");

        editText = view.findViewById(R.id.editext_entry);
        button = view.findViewById(R.id.button_text_entry);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText != null) {
                    String showString = editText.getText().toString();
                    Toast.makeText(getActivity(), showString, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
