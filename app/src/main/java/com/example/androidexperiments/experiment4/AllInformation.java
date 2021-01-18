package com.example.androidexperiments.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidexperiments.R;

public class AllInformation extends AppCompatActivity {
    private TextView name,hobby,tag;
    private InforMation person = new InforMation();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allinormation);
        name = (TextView)findViewById(R.id.Name);
        hobby = (TextView) findViewById(R.id.Hobby);
        tag = (TextView) findViewById(R.id.Tag);
        person = (InforMation) getIntent().getSerializableExtra("ToMyInformation");
        name.setText("姓名:\n"+person.getName());
        hobby.setText(person.getHobby());
        tag.setText(person.getTag());
    }
}