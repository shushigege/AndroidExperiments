package com.example.androidexperiments.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.androidexperiments.R;

public class TagActivity extends AppCompatActivity {
    private CheckBox checkBox1,checkBox2,checkBox3,
            checkBox4,checkBox5,checkBox6,
            checkBox7,checkBox8,checkBox9;
    private InforMation inforMation;
    private Button SubmitTag;
    private String returntag="标签:\n";
    private String[] tag = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);
        inforMation=(InforMation) getIntent().getSerializableExtra("information");
        SubmitTag = (Button) findViewById(R.id.SubmitTag);
        checkBox1 = (CheckBox)findViewById(R.id.MyTag1);
        checkBox2 = (CheckBox)findViewById(R.id.MyTag2);
        checkBox3 = (CheckBox)findViewById(R.id.MyTag3);
        checkBox4 = (CheckBox)findViewById(R.id.MyTag4);
        checkBox5 = (CheckBox)findViewById(R.id.MyTag5);
        checkBox6 = (CheckBox)findViewById(R.id.MyTag6);
        checkBox7 = (CheckBox)findViewById(R.id.MyTag7);
        checkBox8 = (CheckBox)findViewById(R.id.MyTag8);
        checkBox9 = (CheckBox)findViewById(R.id.MyTag9);
        getMyTag();
    }





    private void getMyTag(){
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox1.isChecked()){
                    tag[0]=checkBox1.getText().toString();
                }else{
                    tag[0]=null;
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox2.isChecked()){
                    tag[1]=checkBox2.getText().toString();
                }else{
                    tag[1]=null;
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox3.isChecked()){
                    tag[2]=checkBox3.getText().toString();
                }else{
                    tag[2]=null;
                }
            }
        });
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox4.isChecked()){
                    tag[3]=checkBox4.getText().toString();
                }else{
                    tag[3]=null;
                }
            }
        });
        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox5.isChecked()){
                    tag[4]=checkBox5.getText().toString();
                }else{
                    tag[4]=null;
                }
            }
        });
        checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox6.isChecked()){
                    tag[5]=checkBox6.getText().toString();
                }else{
                    tag[5]=null;
                }
            }
        });
        checkBox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox7.isChecked()){
                    tag[6]=checkBox7.getText().toString();
                }else{
                    tag[6]=null;
                }
            }
        });
        checkBox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox8.isChecked()){
                    tag[7]=checkBox8.getText().toString();
                }else{
                    tag[7]=null;
                }
            }
        });
        checkBox9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox9.isChecked()){
                    tag[8]=checkBox9.getText().toString();
                }else{
                    tag[8]=null;
                }
            }
        });

        SubmitTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearup(tag);
                Intent intent = new Intent(TagActivity.this, ex4.class);
                intent.putExtra("myTag",returntag.substring(0,returntag.length()-1));
                setResult(2,intent);
                Toast.makeText(getApplication(),"提交标签成功!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void clearup(String[] tag){
        for(int i=0;i<9;i++){
            if(tag[i] !=null){
                returntag+=tag[i]+",";
            }
        }
    }
}