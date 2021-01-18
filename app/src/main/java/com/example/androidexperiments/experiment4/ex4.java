package com.example.androidexperiments.experiment4;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.androidexperiments.R;
public class ex4 extends Fragment implements View.OnClickListener{
    private Button ChooseHobby,ChooseTag,ex4_finish,ex4_cancel;
    private EditText Myname;
    private Button change_hobby,change_tag;
    InforMation inforMation = new InforMation();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ex4,null);
        ChooseHobby = (Button)view.findViewById(R.id.ChooseHobby);
        ChooseTag = (Button)view.findViewById(R.id.ChooseTag);
        ex4_finish = (Button)view.findViewById(R.id.ex4_finish);
        ex4_cancel = (Button)view.findViewById(R.id.ex4_cancel);
        change_hobby = (Button)view.findViewById(R.id.change_hobby);
        change_tag = (Button)view.findViewById(R.id.change_tag);
        ChooseHobby.setOnClickListener(this);
        ChooseTag.setOnClickListener(this);
        ex4_finish.setOnClickListener(this);
        ex4_cancel.setOnClickListener(this);
        change_hobby.setOnClickListener(this);
        change_tag.setOnClickListener(this);
        Myname = (EditText)view.findViewById(R.id.Myname);
        Myname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                inforMation.setName(s.toString());
            }
        });
        change_tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),TagActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ChooseHobby:
                Intent intent1 = new Intent(getActivity(),HobbyActivity.class);
                intent1.putExtra("name1",inforMation.getName());
                startActivityForResult(intent1,1);
                break;
            case R.id.ChooseTag:
                Intent intent2 = new Intent(getActivity(),TagActivity.class);
                intent2.putExtra("name2",inforMation.getName());
                startActivityForResult(intent2,2);
                startActivity(intent2);
                break;
            case R.id.ex4_finish:
                Intent intent3 = new Intent(getActivity() ,AllInformation.class);
                intent3.putExtra("ToMyInformation",inforMation);
                startActivity(intent3);
                break;
            case R.id.change_hobby:
                Intent intent = new Intent(getActivity(),HobbyActivity.class);
                intent.putExtra("name3",inforMation.getName());
                startActivityForResult(intent,1);
                break;
            case R.id.change_tag:
                Intent intent4 = new Intent(getActivity(),TagActivity.class);
                intent4.putExtra("name4",inforMation.getName());
                startActivityForResult(intent4,2);
                startActivity(intent4);
            case R.id.ex4_cancel:
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==1){
            String hobby = data.getStringExtra("myHobby");
            inforMation.setHobby(hobby);
        }
        if(requestCode==2 && resultCode==2){
            String tag = data.getStringExtra("myTag");
            inforMation.setTag(tag);
        }
    }
}