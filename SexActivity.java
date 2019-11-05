package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SexActivity extends Activity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sex);
  }

  public void chooseCity(View view) {
    TextView b = (TextView) view;
    String sex = b.getText().toString();
    Toast.makeText(this, sex, Toast.LENGTH_SHORT).show();

    Intent intent = new Intent();
    intent.putExtra("sex", sex);
    setResult(102, intent);
    finish();
  }
}
