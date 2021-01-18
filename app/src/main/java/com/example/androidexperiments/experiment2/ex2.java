package com.example.androidexperiments.experiment2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.androidexperiments.R;

public class ex2 extends Fragment  {
    private Button btn_ex2;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ex2,null);

        btn_ex2 = (Button)view.findViewById(R.id.btn_ex2);
        btn_ex2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ex2intent.class);
                startActivity(intent);
            }
        });

        return view;
    }



   @Override
   public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);

       // btn_ex2 = (Button) findViewById(R.id.btn_ex2);
    }

}