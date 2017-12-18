package com.example.bangcode.myexperiments.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bangcode.myexperiments.R;

import java.util.ArrayList;
import java.util.List;


public class TabAsync extends Fragment {
    private TabLayout myTab;
    private ViewPager mypager;

    public TabAsync() {
        // Required empty public constructor
    }


    public static TabAsync newInstance() {
        TabAsync fragment = new TabAsync();
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
        return inflater.inflate(R.layout.fragment_tab_async, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myTab=view.findViewById(R.id.tabAsync);
        mypager=view.findViewById(R.id.pagerAsync);

        TabAsync.PagerAdapter pagerAdapter = new TabAsync.PagerAdapter(getChildFragmentManager());
        mypager.setAdapter(pagerAdapter);

        pagerAdapter.add(new AsyncFragment(), "Async");
        pagerAdapter.add(new AsyncInternetFragment(), "Async Internet");

        myTab.setupWithViewPager(mypager);
    }

    //    class for adapter

    private class PagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments = new ArrayList<>();
        private List<String> titles = new ArrayList<>();

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public void add(Fragment fragment, String title) {
            fragments.add(fragment);
            titles.add(title);

            notifyDataSetChanged();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

}
