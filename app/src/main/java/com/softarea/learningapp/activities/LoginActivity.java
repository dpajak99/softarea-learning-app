package com.softarea.learningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.User;
import com.softarea.learningapp.sqlite.DBManager;
import com.softarea.learningapp.utils.BundleUtils;
import com.softarea.learningapp.utils.TokenUtils;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class LoginActivity extends AppCompatActivity {
  private static final String TAG = "TEST";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    Button buttonLogin = findViewById(R.id.button_login);
    buttonLogin.setOnClickListener(v -> validateLogin());
  }

  public void validateLogin() {
    DBManager dbManager = new DBManager(getApplicationContext());
    EditText email = findViewById(R.id.input_email);
    EditText password = findViewById(R.id.input_password);

    int id = dbManager.getUserId(email.getText().toString(), password.getText().toString());
    if (id != 0) {
      String token = TokenUtils.createToken(id);
      dbManager.updateToken(token, id);
      dbManager.updateLocalToken(token);

      token = dbManager.getLocalToken();
      User user = dbManager.getUser(token);

      Intent intent = new Intent(getApplicationContext(), MainActivity.class);
      intent.putExtras(BundleUtils.createSerializableBundle("user", user));
      intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
      getApplicationContext().startActivity(intent);

    } else {
      Toast.makeText(getApplicationContext(), "Błędne hasło lub login", Toast.LENGTH_LONG).show();
    }
  }
}
