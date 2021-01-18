package com.example.androidexperiments.experiment3;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.androidexperiments.R;
import com.example.androidexperiments.experiment3.bmob.Person;


import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class ex3 extends Fragment implements View.OnClickListener {

    private Button ex3_register,ex3_cancel;
    private EditText username,password,name,email;
    private RadioButton chooseSex1,chooseSex2;
    //private RadioButton age1,age2,age3,age4;
    private CheckBox hobby1,hobby2,hobby3,hobby4,hobby5,hobby6;
    private String[] hobbys = new String[6];
    private String returnhobby1="爱好是：\n";
    private Spinner spinner;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ex3,null);
        username = (EditText)view.findViewById(R.id.username);
        password = (EditText)view.findViewById(R.id.password);
        name = (EditText)view.findViewById(R.id.name);
        email = (EditText)view.findViewById(R.id.email);
        chooseSex1 = (RadioButton)view.findViewById(R.id.choseSex1);
        chooseSex2 = (RadioButton)view.findViewById(R.id.choseSex2);
//        age1 = (RadioButton)view.findViewById(R.id.Age1);
//        age2 = (RadioButton)view.findViewById(R.id.Age2);
//        age3 = (RadioButton)view.findViewById(R.id.Age3);
//        age4 = (RadioButton)view.findViewById(R.id.Age4);
        hobby1 = (CheckBox)view.findViewById(R.id.hobby1);
        hobby2 = (CheckBox)view.findViewById(R.id.hobby2);
        hobby3 = (CheckBox)view.findViewById(R.id.hobby3);
        hobby4 = (CheckBox)view.findViewById(R.id.hobby4);
        hobby5 = (CheckBox)view.findViewById(R.id.hobby5);
        hobby6 = (CheckBox)view.findViewById(R.id.hobby6);
        ex3_register = (Button)view.findViewById(R.id.ex3_register);
        ex3_cancel = (Button)view.findViewById(R.id.ex3_cancle);
        ex3_register.setOnClickListener(this);
        ex3_cancel.setOnClickListener(this);
        spinner = (Spinner)view.findViewById(R.id.sp_type);

        return view;
    }


    @Override
    public void onClick(View v) {
        Person person = new Person();
        String userName = username.getText().toString();
        String Password = password.getText().toString();
        String Name = name.getText().toString();
        String Email = email.getText().toString();
        String Sex1 = chooseSex1.getText().toString();
        String Sex2 = chooseSex2.getText().toString();
//        String Age1 = age1.getText().toString();
//        String Age2 = age2.getText().toString();
//        String Age3 = age3.getText().toString();
//        String Age4 = age4.getText().toString();
        String Hobby1 = hobby1.getText().toString();
        String Hobby2 = hobby2.getText().toString();
        String Hobby3 = hobby3.getText().toString();
        String Hobby4 = hobby4.getText().toString();
        String Hobby5 = hobby5.getText().toString();
        String Hobby6 = hobby6.getText().toString();
        if (v.getId() == R.id.ex3_register){
            person.setUsername(userName);
            person.setPassword(Password);
            person.setName(Name);
            person.setEmail(Email);
            if (chooseSex1.isChecked()){
                person.setSex(Sex1);
            }else if(chooseSex2.isChecked()){
                person.setSex(Sex2);
            }

//            if (age1.isChecked()){
//                person.setAge(Age1);
//            }else if (age2.isChecked()){
//                person.setAge(Age2);
//            }else if (age3.isChecked()){
//                person.setAge(Age3);
//            }else if (age4.isChecked()){
//                person.setAge(Age4);
//            }

            hobby1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(hobby1.isChecked()){
                        hobbys[0]=hobby1.getText().toString();

                    }else{
                        hobbys[0]=null;
                    }
                }
            });
            hobby2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(hobby2.isChecked()){
                        hobbys[1]=hobby2.getText().toString();

                    }else{
                        hobbys[1]=null;
                    }
                }
            });
            hobby3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(hobby3.isChecked()){
                        hobbys[2]=hobby3.getText().toString();

                    }else{
                        hobbys[2]=null;
                    }
                }
            });
            hobby4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(hobby4.isChecked()){
                        hobbys[3]=hobby4.getText().toString();

                    }else{
                        hobbys[3]=null;
                    }
                }
            });
            hobby5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(hobby5.isChecked()){
                        hobbys[4]=hobby5.getText().toString();

                    }else{
                        hobbys[4]=null;
                    }
                }
            });
            hobby6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(hobby6.isChecked()){
                        hobbys[5]=hobby6.getText().toString();

                    }else{
                        hobbys[5]=null;
                    }
                }
            });

            for(int i=0;i<6;i++){
                if(hobbys[i]!=null){
                    hobbys[i]+=",";
                    returnhobby1+=hobbys[i];
                }
            }


            person.setHobby(person.getHobby(returnhobby1));



            person.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                    if (e == null){
                        Toast.makeText(getActivity(),"注册成功",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getActivity(),"注册失败",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else if (v.getId() == R.id.ex3_cancle){
            Toast.makeText(getActivity(),"取消成功",Toast.LENGTH_SHORT).show();
        }
    }




}