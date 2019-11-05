package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CityActivity extends Activity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_city);
  }

  public void chooseCity(View view) {
    TextView b = (TextView) view;
    String city = b.getText().toString();
    Toast.makeText(this, city, Toast.LENGTH_SHORT).show();

    Intent intent = new Intent();
    intent.putExtra("city", city);
    setResult(101, intent);
    finish();
  }
}
