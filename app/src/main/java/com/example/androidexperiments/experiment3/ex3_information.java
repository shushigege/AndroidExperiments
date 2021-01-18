package com.example.androidexperiments.experiment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidexperiments.R;
import com.example.androidexperiments.experiment4.InforMation;

public class ex3_information extends AppCompatActivity {

    private TextView ex3_username, ex3_password ,ex3_name ,ex3_email, ex3_sex,ex3_hobby;
    private InforMation per = new InforMation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3_information);
        ex3_username = findViewById(R.id.ex3_username);
        ex3_password = findViewById(R.id.ex3_password);
        ex3_name = findViewById(R.id.name);
        ex3_email = findViewById(R.id.ex3_email);
        ex3_sex = findViewById(R.id.ex3_sex);
        ex3_hobby = findViewById(R.id.ex3_hobby);
        per = (InforMation) getIntent().getSerializableExtra("ToMyInformation");
      //  ex3_username.setText(per.);
    }
}