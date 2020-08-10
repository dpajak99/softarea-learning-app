package com.softarea.learningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.softarea.learningapp.R;
import com.softarea.learningapp.dao.LoginDAO;
import com.softarea.learningapp.model.User;
import com.softarea.learningapp.sqlite.DBManager;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class LoginActivity extends AppCompatActivity {
  private static final String TAG = "TEST";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    Button buttonLogin = findViewById(R.id.button_login);
    buttonLogin.setOnClickListener(v -> validateLogin());



    //Log.i(TAG, "Added User");

  }

  public void validateLogin() {
    DBManager dbManager = new DBManager(getApplicationContext());
    EditText email = findViewById(R.id.input_email);
    EditText password = findViewById(R.id.input_password);

    Log.i(TAG, "PROVIDED EMAIL: " + email.getText().toString());
    Log.i(TAG, "PROVIDED PASSWORD: " + password.getText().toString());

    int id = dbManager.getUserId(email.getText().toString(), password.getText().toString());
    Log.i(TAG, "GETTED USER ID : " + String.valueOf(id));

    if (id != 0) {
      String token = LoginDAO.createToken(id);
      Log.i(TAG, "Created token");
      dbManager.updateToken(token, id);
      Log.i(TAG, "Updated token");
      dbManager.updateLocalToken(token);
      Log.i(TAG, "Updated local token");

      token = dbManager.getLocalToken();
      Log.i(TAG, "TOKEN: " + token);
      User user = dbManager.getUser(token);
      Log.i(TAG, "Getted user via token");

      Intent intent = new Intent(getApplicationContext(), MainActivity.class);
      Bundle bundle = new Bundle();
      bundle.putSerializable("user", user);
      intent.putExtras(bundle);
     //TODO:FIIIIIX IT
      intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
      getApplicationContext().startActivity(intent);

    } else {
      Toast.makeText(getApplicationContext(), "Błędne hasło lub login", Toast.LENGTH_LONG).show();
    }
  }
}
