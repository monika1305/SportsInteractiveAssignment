package com.example.sportsinteractiveassignment;

import android.content.Intent;
import android.os.Bundle;

import com.example.sportsinteractiveassignment.model.repository.WebServiceRepository;
import com.example.sportsinteractiveassignment.utils.Utility;
import com.example.sportsinteractiveassignment.view.BlankFragment;
import com.example.sportsinteractiveassignment.view.TeamFragment;
import com.example.sportsinteractiveassignment.viewmodel.MatchDetailsViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    MatchDetailsViewModel viewModel;
    BottomNavigationView bottomNavigationView;
    FragmentTransaction transaction = null;
    Fragment f=null;
    Fragment setf=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureBottomNavigationView();
        viewModel= ViewModelProviders.of(MainActivity.this).get(MatchDetailsViewModel.class);
//
        if(Utility.isNetworAvailable(this)){
//            Log.e("EMP_REPO","onCreate == ");
            viewModel.getWebApiCall();

        }
//        else{
//            Toast.makeText(this,"No internet available showing cached list view",Toast.LENGTH_SHORT).show();
//        }
        startMatchFragment();
    }

    private void configureBottomNavigationView() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.getMenu().getItem(3).setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent ;
                switch (item.getItemId()) {
                    case R.id.action_summary:
                        startTeamFragment();
                        return true;
                    case R.id.action_scorecard:
//                        Toast.makeText(getApplicationContext(),"This feature is Under Development",Toast.LENGTH_SHORT).show();
//                        f = new ContactsFragment();
//                        transaction = getSupportFragmentManager().beginTransaction();
//                        transaction.replace(R.id.frame_main, f);
//                        transaction.commit();
                        return true;
                    case R.id.action_commentary:
//                        drawerLayout.closeDrawers();
//                        Utility.launcherApps("Microsoft Teams",DashboardActivity.this);
                        return true;
                    case R.id.action_match_info:
                        startMatchFragment();
                        return true;

                    default:
                        return true;
                }
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
//        Fragment test =  getSupportFragmentManager().findFragmentById(R.id.frame_main);
//        if (test instanceof NotificationFragment) {
//            bottomNavigationView.getMenu().getItem(1).setChecked(true);
//
//        }else


    }
    private void startMatchFragment() {

        Bundle  bundle = new Bundle();
        f = new BlankFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_main, f);
        transaction.commit();
        bottomNavigationView.getMenu().getItem(3).setChecked(true);
    }
    private void startTeamFragment() {

        Bundle  bundle = new Bundle();
        f = new TeamFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_main, f);
        transaction.commit();
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
    }

}
