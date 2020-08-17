package com.softarea.learningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.softarea.learningapp.R;
import com.softarea.learningapp.dao.TokenDAO;
import com.softarea.learningapp.dao.UserDAO;
import com.softarea.learningapp.model.Token;
import com.softarea.learningapp.model.User;
import com.softarea.learningapp.consts.AlertConst;
import com.softarea.learningapp.utils.BundleUtils;
import com.softarea.learningapp.utils.DatabaseUtils;
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
    EditText et_email = findViewById(R.id.input_email);
    EditText et_password = findViewById(R.id.input_password);

    String email = et_email.getText().toString();
    String password = et_password.getText().toString();

    UserDAO userDAO = DatabaseUtils.getDatabase(getApplicationContext()).userDAO();
    TokenDAO tokenDAO = DatabaseUtils.getDatabase(getApplicationContext()).tokenDAO();

    if (userDAO.checkLoginData(email, password) == DatabaseUtils.USER_EXIST) {
        User user = userDAO.getUser(email, password);
        String token = TokenUtils.createToken(user.getId());
        if(tokenDAO.checkTokenExist() == DatabaseUtils.TOKEN_EXIST) {
          tokenDAO.updateLocalToken(token);
        } else if(tokenDAO.checkTokenExist() == DatabaseUtils.TOKEN_NOT_FOUND ) {
          tokenDAO.createLocalToken(new Token(0, token));
        } else {
          AlertConst.alert(getApplicationContext(), AlertConst.MORE_THAN_ONE_TOKEN);
        }

        userDAO.updateToken(token, user.getId());

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtras(BundleUtils.createSerializableBundle("user", user));
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent);

      } else if (userDAO.checkLoginData(email, password) == DatabaseUtils.USER_NOT_FOUND) {
        AlertConst.alert(getApplicationContext(), AlertConst.USER_NOT_FOUND);
      } else {
        AlertConst.alert(getApplicationContext(), AlertConst.MORE_THAN_ONE_USER);
      }
    }
  }
