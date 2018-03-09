package com.example.sanyo.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    static final String NAME = "NAME";
    static final String EMAIL = "email";
    static final String DEPT = "DEPARTMENT";
    static final String MOOD = "Mood";
    static final String TYPE = "TYPE";
    String VALUE;
    int REQ_CODE = 100;
    static final String STUDENT_KEY = "KEY_DISPLAY";
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        setTitle("Display Activity");
        if(getIntent() != null  && getIntent().getExtras() != null){
            student = (Student) getIntent().getExtras().getSerializable(MainActivity.STUDENT_KEY);
            TextView nameDis = findViewById(R.id.textView12Name);
            nameDis.setText(student.name);

            TextView emailDis = findViewById(R.id.textView13Email);
            emailDis.setText(student.email);

            TextView deptDis = findViewById(R.id.textView14Dept);
            deptDis.setText(student.department);

            TextView moodDis = findViewById(R.id.textView15mood);
            moodDis.setText(student.mood+" % Positive");

            findViewById(R.id.imageViewName).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    VALUE = NAME;
                    Intent i = new Intent("com.example.sanyo.inclass03.intent.action.VIEW");
                    i.addCategory(Intent.CATEGORY_DEFAULT);
                    i.putExtra(STUDENT_KEY, student);
                    i.putExtra(TYPE, VALUE);
                    startActivityForResult(i,REQ_CODE);
                }
            });
            findViewById(R.id.imageViewEmail).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    VALUE = EMAIL;
                    Intent i = new Intent("com.example.sanyo.inclass03.intent.action.VIEW") ;
                    i.addCategory(Intent.CATEGORY_DEFAULT);
                    i.putExtra(STUDENT_KEY, student);
                    i.putExtra(TYPE, VALUE);
                    startActivityForResult(i,REQ_CODE);

                }
            });
            findViewById(R.id.imageViewDept).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    VALUE = DEPT;
                    Intent i = new Intent("com.example.sanyo.inclass03.intent.action.VIEW") ;
                    i.addCategory(Intent.CATEGORY_DEFAULT);
                    i.putExtra(STUDENT_KEY, student);
                    i.putExtra(TYPE, VALUE);
                    startActivityForResult(i,REQ_CODE);

                }
            });
            findViewById(R.id.imageViewMood).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    VALUE = MOOD;
                    Intent i = new Intent("com.example.sanyo.inclass03.intent.action.VIEW") ;
                    i.addCategory(Intent.CATEGORY_DEFAULT);
                    i.putExtra(STUDENT_KEY, student);
                    i.putExtra(TYPE, VALUE);
                    startActivityForResult(i,REQ_CODE);

                }
            });


        }


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {
            if (resultCode == RESULT_OK) {
                student = (Student) data.getExtras().getSerializable(EditActivity.EDIT_KEY);
                TextView name = findViewById(R.id.textView12Name);
                name.setText(student.name);
                TextView email = findViewById(R.id.textView13Email);
                email.setText(student.email);
                TextView dept = findViewById(R.id.textView14Dept);
                dept.setText(student.department);
                TextView mood = findViewById(R.id.textView15mood);
                mood.setText(student.mood + " % Positive");
            }
        }


    }
}
