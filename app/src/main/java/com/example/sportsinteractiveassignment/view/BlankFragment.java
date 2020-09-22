package com.example.sportsinteractiveassignment.view;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sportsinteractiveassignment.R;
import com.example.sportsinteractiveassignment.databinding.FragmentBlankBinding;
import com.example.sportsinteractiveassignment.model.entity.matchdetails.MatchDetailsEntity;
import com.example.sportsinteractiveassignment.model.repository.WebServiceRepository;
import com.example.sportsinteractiveassignment.viewmodel.MatchDetailsViewModel;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view = null;
    MatchDetailsViewModel matchDetailsViewModel;
    ProgressDialog progressDialog;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
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
        view =  inflater.inflate(R.layout.fragment_blank, container, false);
        initViews(view);
        progressDialog= ProgressDialog.show(getActivity(), "Loading...", "Please wait...", true);
        FragmentBlankBinding fragmentBlankBinding=DataBindingUtil.bind(view);
        matchDetailsViewModel.getMatchDetailsLiveData().observe(this, new Observer<MatchDetailsEntity>() {
            @Override
            public void onChanged(@Nullable MatchDetailsEntity matchDetailsEntity) {
                if(matchDetailsEntity!=null) {
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.dismiss();
                        fragmentBlankBinding.setMatchDetailsEntity(matchDetailsEntity);
                    }
                }else{

//                  Log.d("Val","Val "+matchDetailsEntity.toString());
                }
            }
        });

        return view;

    }

    private void initViews(View view) {
        matchDetailsViewModel = ViewModelProviders.of(getActivity()).get(MatchDetailsViewModel.class);
        progressDialog = new ProgressDialog(getActivity());
    }
}