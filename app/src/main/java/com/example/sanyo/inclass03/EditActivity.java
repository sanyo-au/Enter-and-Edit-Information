package com.example.sanyo.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    static final String EDIT_KEY = "EDIT_KEY";
    Student s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        setTitle("Edit Activity");
        String type;
        final EditText editTextName = (EditText) findViewById(R.id.editTextNameEdit);
        final EditText editTextEmail = (EditText) findViewById(R.id.editTextEmailEdit);
        final RadioGroup rg = findViewById(R.id.radioGroup2);
        final  TextView textView24 = findViewById(R.id.textView24);
        final TextView textViewMood = findViewById(R.id.textViewMoodEdit);
        final  SeekBar sb = findViewById(R.id.seekBar7);

        if(getIntent() != null  && getIntent().getExtras() != null){
          type = getIntent().getExtras().getString(DisplayActivity.TYPE);
          s = (Student)getIntent().getExtras().getSerializable(DisplayActivity.STUDENT_KEY);
          if(type.equals(DisplayActivity.DEPT))    {
              editTextEmail.setVisibility(View.INVISIBLE);
              editTextName.setVisibility(View.INVISIBLE);
              textViewMood.setVisibility(View.INVISIBLE);
              sb.setVisibility(View.INVISIBLE);
              findViewById(R.id.buttonSubmitEdit).setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view)              {
                      RadioButton rb= ((RadioButton )findViewById(rg.getCheckedRadioButtonId()));
                      String dept = rb.getText().toString();
                      s.department = dept;
                      Intent i = new Intent();
                      i.putExtra(EDIT_KEY, s);
                      setResult(RESULT_OK, i);

                      finish();
                  }

              });
          }
          else if(type.equals( DisplayActivity.EMAIL)){
              rg.setVisibility(View.INVISIBLE);
              editTextName.setVisibility(View.INVISIBLE);
              textViewMood.setVisibility(View.INVISIBLE);
              textView24.setVisibility(View.INVISIBLE);
              sb.setVisibility(View.INVISIBLE);
              findViewById(R.id.buttonSubmitEdit).setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      s.email = editTextEmail.getText().toString();
                      Intent i = new Intent();
                      i.putExtra(EDIT_KEY, s);
                      setResult(RESULT_OK, i);

                      finish();
                  }

              });
            }
          else if(type.equals( DisplayActivity.MOOD)){
              rg.setVisibility(View.INVISIBLE);
              editTextName.setVisibility(View.INVISIBLE);
              textView24.setVisibility(View.INVISIBLE);
              editTextEmail.setVisibility(View.INVISIBLE);

              findViewById(R.id.buttonSubmitEdit).setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      s.mood = sb.getProgress();
                      Intent i = new Intent();
                      i.putExtra(EDIT_KEY, s);
                      setResult(RESULT_OK, i);
                      finish();
                  }

              });
          }
          else if(type.equals( DisplayActivity.NAME)){
              rg.setVisibility(View.INVISIBLE);
              editTextEmail.setVisibility(View.INVISIBLE);
              textViewMood.setVisibility(View.INVISIBLE);
              textView24.setVisibility(View.INVISIBLE);
              sb.setVisibility(View.INVISIBLE);
              findViewById(R.id.buttonSubmitEdit).setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      s.name = editTextName.getText().toString();
                      Intent i = new Intent();
                      i.putExtra(EDIT_KEY, s);
                      setResult(RESULT_OK, i);
                      finish();
                  }

              });
          };

        }


    }
}
