package com.example.myapplication;

import androidx.annotation.Nullable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

  private EditText mUserName;
  private EditText mPassword;
  private Button mLoginButton;
  private Button mRegisterButton;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    mUserName = findViewById(R.id.username);
    mPassword = findViewById(R.id.password);
    mLoginButton = findViewById(R.id.login_button);
    mRegisterButton = findViewById(R.id.register_button);

    mRegisterButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        String username = mUserName.getText().toString();
        if (!username.isEmpty()){
          intent.putExtra("username", username);
        }
        startActivity(intent);
      }
    });
  }

  public void login(View view) {
    if (view.getId() == R.id.login_button) {
      String username = mUserName.getText().toString();
      String password = mPassword.getText().toString();
      if (username.isEmpty() || password.isEmpty()) {
        showText(R.string.warning_enter_credentials_correctly);
        return;
      }
      if (username.equals(password)) {
        showText("Correct Credentials");
      } else {
        showText("Incorrect Credentials");
      }
    }
  }

  private void showText(String text) {
    Toast toast = Toast.makeText(LoginActivity.this, text, Toast.LENGTH_SHORT);
    toast.show();
  }
  private void showText(int text) {
    Toast toast = Toast.makeText(LoginActivity.this, text, Toast.LENGTH_SHORT);
    toast.show();
  }

}