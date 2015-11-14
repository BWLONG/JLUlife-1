package com.brady.jlulife.Fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.brady.jlulife.CourseActivity;
import com.brady.jlulife.DrcomLoginActivity;
import com.brady.jlulife.JWQueryActivity;
import com.brady.jlulife.NewsActivity;
import com.brady.jlulife.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

//    ViewPager mViewPager;
//    RecyclerView mRecyclerView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Intent intent;
//        initComponents(view);
//        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity().getApplicationContext(),4);
//        mRecyclerView.setLayoutManager(manager);
                ((Button) view.findViewById(R.id.main_drcom_login)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DrcomLoginActivity.class);
                startActivity(intent);
            }
        });
        ((Button) view.findViewById(R.id.main_jwQuery)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JWQueryActivity.class);
                startActivity(intent);
            }
        });
        ((Button) view.findViewById(R.id.main_xntz)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(getActivity(), NewsActivity.class);
                startActivity(intent);

            }
        });
        ((Button) view.findViewById(R.id.main_my_lesson_list)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CourseActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initComponents(View view) {
//        mViewPager = (ViewPager) view.findViewById(R.id.main_viewpager);
//        mRecyclerView = (RecyclerView) view.findViewById(R.id.main_recyclerView);
    }
}
