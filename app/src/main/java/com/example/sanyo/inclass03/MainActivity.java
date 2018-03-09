package com.example.sanyo.inclass03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static String STUDENT_KEY= "STUDENT";
    String department;
    String name;
    String email;
    int mood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        setTitle("Main Activity");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editTextName);
                EditText editText1 = (EditText) findViewById(R.id.editText2);
                if(editText.getText().toString() == null || editText.getText().toString().length() == 0
                || editText1.getText().toString() == null || editText1.getText().toString().length() == 0){
                    Toast.makeText(MainActivity.this, "Missing Information",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                    name = editText.getText().toString();
                    email = editText1.getText().toString();
                    RadioGroup rg = findViewById(R.id.radioGroup);
                    department = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
                    SeekBar sb = findViewById(R.id.seekBar);
                    mood = sb.getProgress();
                    Student student = new Student(name, email, department, mood);
                    intent.putExtra(STUDENT_KEY, student);
                    startActivity(intent);
                }
            }
        });

    }
}
