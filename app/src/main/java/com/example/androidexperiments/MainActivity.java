package com.example.androidexperiments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.androidexperiments.experiment1.ex1;
import com.example.androidexperiments.experiment2.ex2;
import com.example.androidexperiments.experiment3.ex3;
import com.example.androidexperiments.experiment4.ex4;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Fragment ex1;
    private Fragment ex2;
    private Fragment ex3;
    private Fragment ex4;
    private Fragment[] fragments;
    private  int lastfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this,"25d48b037ba62db9b928e6a4ea0704f8");
        initFragment();

    }

    private void initFragment(){
        ex1 = new ex1();
        ex2 = new ex2();
        ex3 = new ex3();
        ex4 = new ex4();
        fragments = new Fragment[]{ex1,ex2,ex3,ex4};
        lastfragment = 0;
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragment,ex1).show(ex1).commit();
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.action_ex1:{
                    if (lastfragment != 0){
                        switchFragment(lastfragment,0);
                        lastfragment = 0;
                    }
                    return true;
                }

                case R.id.action_ex2:{
                    if (lastfragment != 1){
                        switchFragment(lastfragment,1);
                        lastfragment = 1;
                    }
                    return true;
                }

                case R.id.action_ex3:{
                    if (lastfragment != 2){
                        switchFragment(lastfragment,2);
                        lastfragment = 2;
                    }
                    return true;
                }

                case R.id.action_ex4:{
                    if (lastfragment != 3){
                        switchFragment(lastfragment,3);
                        lastfragment = 3;
                    }
                    return true;
                }
            }
            return false;
        }
    };





    //切换Fragment
    private void switchFragment(int lastfragment, int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if (fragments[index].isAdded() == false) {
            transaction.add(R.id.frame_fragment, fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }
}