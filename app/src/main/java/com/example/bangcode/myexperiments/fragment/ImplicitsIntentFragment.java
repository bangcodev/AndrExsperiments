package com.example.bangcode.myexperiments.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bangcode.myexperiments.R;
import com.example.bangcode.myexperiments.activity.MyNavigation;


public class ImplicitsIntentFragment extends Fragment implements View.OnClickListener{
    private static final String LOG_TAG= ImplicitsIntentFragment.class.getSimpleName();

    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareEditText;
    private Button mWebButton;
    private Button mLocButton;
    private Button mShareButton;

    public ImplicitsIntentFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ImplicitsIntentFragment newInstance() {
        ImplicitsIntentFragment fragment = new ImplicitsIntentFragment();
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
        return inflater.inflate(R.layout.fragment_implicits_intent, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MyNavigation)getActivity()).setActionBarTitle(getString(R.string.implisitintent));

        mWebButton= view.findViewById(R.id.open_web_button);
        mWebButton.setOnClickListener(this);

        mLocButton= view.findViewById(R.id.open_location_button);
        mLocButton.setOnClickListener(this);

        mShareButton= view.findViewById(R.id.open_share_button);
        mShareButton.setOnClickListener(this);

        mWebsiteEditText = view.findViewById(R.id.website_editext);
        mLocationEditText= view.findViewById(R.id.loc_editext);
        mShareEditText= view.findViewById(R.id.share_editext);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.open_web_button:
//                get text url
                String url =mWebsiteEditText.getText().toString();
//                Toast.makeText(getActivity(),url,Toast.LENGTH_SHORT).show();

//                parse uri and create intent
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

//                find activity to hand the intent and start the activity
                if (intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }else {
                    Log.d(LOG_TAG,"tidak bisa handle intent ini");
                }
                break;


            case R.id.open_location_button:

                String loc =mLocationEditText.getText().toString();
                Uri addressUri= Uri.parse("geo:0,0?q=" + loc);
                Intent intent1 = new Intent(Intent.ACTION_VIEW, addressUri);

                if (intent1.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent1);
                }else {
                    Log.d(LOG_TAG,"tidak bisa handle intent ini");
                }

                break;
            case R.id.open_share_button:

                String txt =mShareEditText.getText().toString();
                String mimeType ="text/plain";

                ShareCompat.IntentBuilder
                        .from(getActivity())
                        .setType(mimeType)
                        .setText(txt)
                        .startChooser();

                break;
        }
    }
}
