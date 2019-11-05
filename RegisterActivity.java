package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class RegisterActivity extends Activity {

  private EditText mFirstName;
  private EditText mLastName;
  private EditText mUserName;
  private EditText mCity;
  private EditText mSex;
  private Button mRegisterButton;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    mFirstName = findViewById(R.id.first_name);
    mLastName = findViewById(R.id.last_name);
    mUserName = findViewById(R.id.username);
    mRegisterButton = findViewById(R.id.register_button);
    mCity = findViewById(R.id.city);
    mSex = findViewById(R.id.sex);

    Intent intent = getIntent();
    if (intent.getExtras() != null && intent.getExtras().get("username") != null) {
      String userName = intent.getExtras().getString("username");
      mUserName.setText(userName);
    }
  }

  public void chooseCity(View view) {
    Intent intent = new Intent(RegisterActivity.this, CityActivity.class);
    startActivityForResult(intent, 100);
  }
  public void chooseSex(View view) {
    Intent intent = new Intent(RegisterActivity.this, SexActivity.class);
    startActivityForResult(intent, 100);
  }
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    if (intent != null && requestCode == 100 && resultCode == 101) {
      String city = intent.getStringExtra("city");
      if (city != null && !city.isEmpty()) {
        mCity.setText(city);
      }
    }else if (intent != null && requestCode == 100 && resultCode == 102) {
      String sex = intent.getStringExtra("sex");
      if (sex != null && !sex.isEmpty()) {
        mSex.setText(sex);
      }
    }
  }
}
