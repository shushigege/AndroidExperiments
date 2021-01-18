package com.example.androidexperiments.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidexperiments.R;

public class HobbyActivity extends AppCompatActivity {
    private CheckBox checkBox1,checkBox2,checkBox3,
            checkBox4,checkBox5,checkBox6,
            checkBox7,checkBox8,checkBox9;
    private EditText morehobby;
    //private TextView showname;
    private Button submit_hobby;
    private String name,returnhobby="爱好是:\n",more;
    public String[] hobby = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby);
        name = getIntent().getStringExtra("name1");
        submit_hobby = (Button) findViewById(R.id.SubmitHobby);
        ///showname= (TextView) findViewById(R.id.ChoseHobby_Name);
        morehobby = (EditText) findViewById(R.id.MoreHobby);
        checkBox1 = (CheckBox)findViewById(R.id.MyHobby1);
        checkBox2 = (CheckBox)findViewById(R.id.MyHobby2);
        checkBox3 = (CheckBox)findViewById(R.id.MyHobby3);
        checkBox4 = (CheckBox)findViewById(R.id.MyHobby4);
        checkBox5 = (CheckBox)findViewById(R.id.MyHobby5);
        checkBox6 = (CheckBox)findViewById(R.id.MyHobby6);
        checkBox7 = (CheckBox)findViewById(R.id.MyHobby7);
        checkBox8 = (CheckBox)findViewById(R.id.MyHobby8);
        checkBox9 = (CheckBox)findViewById(R.id.MyHobby9);

        morehobby.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                more = s.toString();
            }
        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox1.isChecked()){
                    hobby[0] = checkBox1.getText().toString();
                }else {
                    hobby[0] = null;
                }
            }
        });


        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox2.isChecked()){
                    hobby[1] = checkBox2.getText().toString();
                }else {
                    hobby[1] = null;
                }
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox3.isChecked()){
                    hobby[2] = checkBox3.getText().toString();
                }else {
                    hobby[2] = null;
                }
            }
        });

        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox4.isChecked()){
                    hobby[3] = checkBox4.getText().toString();
                }else {
                    hobby[3] = null;
                }
            }
        });


        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox5.isChecked()){
                    hobby[4] = checkBox5.getText().toString();
                }else {
                    hobby[4] = null;
                }
            }
        });



        checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox6.isChecked()){
                    hobby[5] = checkBox6.getText().toString();
                }else {
                    hobby[5] = null;
                }
            }
        });


        checkBox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox7.isChecked()){
                    hobby[6] = checkBox7.getText().toString();
                }else {
                    hobby[6] = null;
                }
            }
        });


        checkBox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox8.isChecked()){
                    hobby[7] = checkBox8.getText().toString();
                }else {
                    hobby[7] = null;
                }
            }
        });


        checkBox9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox9.isChecked()){
                    hobby[8] = checkBox9.getText().toString();
                }else {
                    hobby[8] = null;
                }
            }
        });


        submit_hobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleatup(hobby);
                Intent intent = new Intent(HobbyActivity.this, ex4.class);
                intent .putExtra("myHobby",returnhobby);
                setResult(1,intent);
                Toast.makeText(getApplication(),"提交爱好成功！",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }


    private void cleatup(String[] hobby){
        for(int i=0;i<9;i++){
            if(hobby[i]!=null){
                hobby[i]+=",";
                returnhobby+=hobby[i];
            }
        }
        if(more==null){
            returnhobby=returnhobby.substring(0,returnhobby.length()-1);
        }else{
            returnhobby+=more;
        }
    }
}