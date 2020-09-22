package com.example.sportsinteractiveassignment.view.tabfragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportsinteractiveassignment.R;
import com.example.sportsinteractiveassignment.databinding.FragmentTeamOneBinding;
import com.example.sportsinteractiveassignment.databinding.PlayersListItemsBinding;
import com.example.sportsinteractiveassignment.model.entity.playerdetails.PlayersEntity;
import com.example.sportsinteractiveassignment.model.entity.teamdetails.TeamsEntity;
import com.example.sportsinteractiveassignment.viewmodel.TeamsDetailsViewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class TeamOneTabFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";


    TeamsDetailsViewModel teamsDetailsViewModel;
    TeamsEntity mTeamEntity;
    RecyclerView recyclerView;
    CustomTabsAdapter adapter;
    List<PlayersEntity> entities;
    public TeamOneTabFragment() {
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null)
            teamsDetailsViewModel = ViewModelProviders.of(this.getActivity()).get(TeamsDetailsViewModel.class);

    }

    public static TeamOneTabFragment newInstance(TeamsEntity birthdayPojos) {
        TeamOneTabFragment fragment = new TeamOneTabFragment();
        Bundle args = new Bundle();
        args.putSerializable("teamData", (Serializable) birthdayPojos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        teamsDetailsViewModel = ViewModelProviders.of(this.getActivity()).get(TeamsDetailsViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
            mTeamEntity = (TeamsEntity) getArguments().getSerializable("teamData");
        }
        teamsDetailsViewModel.setIndex(index);


    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_team_one, container, false);
        FragmentTeamOneBinding fragmentBlankBinding = DataBindingUtil.bind(root);
        fragmentBlankBinding.setMTeamEntity(mTeamEntity);
         recyclerView = root.findViewById(R.id.recyclerView);


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        teamsDetailsViewModel.getPlayersLiveData(mTeamEntity.id).observe(this, new Observer<List<PlayersEntity>>() {
            @Override
            public void onChanged(List<PlayersEntity> playersEntities) {
//                Log.d("TeamOneTabFragment", "TeamOneTabFragment playersEntities not null  check ::::" + (playersEntities != null));
//                Log.d("TeamOneTabFragment", "TeamOneTabFragment playersEntities size ::::" + (playersEntities.size()));
                entities=playersEntities;
                adapter = new CustomTabsAdapter(getActivity(), entities);
                recyclerView.setAdapter(adapter);
            }
        });

        return root;
    }

        class CustomTabsAdapter extends RecyclerView.Adapter<CustomTabsAdapter.MyViewHolder> {
            private List<PlayersEntity> OfferList;
            Context context;

            public class MyViewHolder extends RecyclerView.ViewHolder {
                TextView PlayerName;

                public MyViewHolder(View view) {
                    super(view);
                    this.PlayerName = (TextView) view.findViewById(R.id.PlayerName);

                }
            }

            public CustomTabsAdapter(Context context, List<PlayersEntity> list) {
                this.OfferList = list;
                this.context = context;
            }

            public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.players_list_items, viewGroup, false));
            }

            @Override
            public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
                PlayersEntity gridModel = (PlayersEntity) this.OfferList.get(i);
                myViewHolder.PlayerName.setText(gridModel.players.Name_Full);
            }

            @Override
            public int getItemCount() {
                return this.OfferList.size();
            }
        }

    }