package com.example.nt118n11mmcl_projectfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OnboardingFragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OnboardingFragment3 extends Fragment {

    private Button btnGetStart;
    private View view;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public OnboardingFragment3() {

    }

    public static OnboardingFragment3 newInstance(String param1, String param2) {
        OnboardingFragment3 fragment = new OnboardingFragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_onboarding3, container, false);
       btnGetStart=view.findViewById(R.id.btn_get_start);
       btnGetStart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getActivity(), LoginActivity.class);
               getActivity().startActivity(intent);
           }
       });
       return view;
    }
}