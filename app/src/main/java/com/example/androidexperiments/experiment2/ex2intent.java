package com.example.androidexperiments.experiment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidexperiments.MainActivity;
import com.example.androidexperiments.R;

public class ex2intent extends AppCompatActivity {

    private String TAG= "生命周期";

    private Button btn_back;

    //private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2intent);
        Log.i(TAG,"ex2intent.onCreate()");
        btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ex2intent.this, MainActivity.class);
                //intent.putExtra("id",1);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"ex2intent.onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"ex2intent.onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"ex2intent.onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"ex2intent.onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"ex2intent.onStop()");
    }

}