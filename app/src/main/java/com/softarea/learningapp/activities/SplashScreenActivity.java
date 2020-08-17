package com.softarea.learningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.softarea.learningapp.R;
import com.softarea.learningapp.dao.TokenDAO;
import com.softarea.learningapp.dao.UserDAO;
import com.softarea.learningapp.model.Token;
import com.softarea.learningapp.model.User;
import com.softarea.learningapp.consts.AlertConst;
import com.softarea.learningapp.utils.AnimationUtils;
import com.softarea.learningapp.utils.BundleUtils;
import com.softarea.learningapp.utils.DatabaseUtils;
import com.softarea.learningapp.utils.TokenUtils;

public class SplashScreenActivity extends AppCompatActivity {
  Intent intent;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen);

    ImageView logoView = findViewById(R.id.logo);

    AnimationUtils.createPulsarLogo(logoView);

    if( DatabaseUtils.getDatabase(getApplicationContext()).userDAO().getCount(0) == 0 ) {
      User user = new User(0, "Dominik Pająk", "SOFTAREA - Junior Android Developer", R.drawable.dpajak, "dominik00801@gmail.com", "123", "000");
      DatabaseUtils.getDatabase(getApplicationContext()).userDAO().insert(user);
    }

    if( DatabaseUtils.getDatabase(getApplicationContext()).userDAO().getCount(1) == 0 ) {
      User user = new User(1, "Łukasz Usarz", "SOFTAREA - SEO", R.drawable.lusarz, "lusarz", "123", "000");
      DatabaseUtils.getDatabase(getApplicationContext()).userDAO().insert(user);
    }


    TokenDAO tokenDAO = DatabaseUtils.getDatabase(getApplicationContext()).tokenDAO();
    UserDAO userDAO = DatabaseUtils.getDatabase(getApplicationContext()).userDAO();
    Token token = tokenDAO.getLocalToken();

    if(tokenDAO.checkTokenExist() == DatabaseUtils.TOKEN_EXIST) {
      if(TokenUtils.validateToken(token.getToken())) {
        intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtras(BundleUtils.createSerializableBundle("user", userDAO.getUser(token.getToken())));
      } else {
        AlertConst.alert(getApplicationContext(), AlertConst.SESSION_EXPIRED);

        intent = new Intent(getApplicationContext(), LoginActivity.class);
      }
    } else if(tokenDAO.checkTokenExist() == DatabaseUtils.TOKEN_NOT_FOUND){
      intent = new Intent(getApplicationContext(), LoginActivity.class);
    } else {
      AlertConst.alert(getApplicationContext(), AlertConst.MORE_THAN_ONE_TOKEN);
    }

    final Handler handler = new Handler();
    handler.postDelayed(() -> {
      startActivity(intent);
      finish();
    }, 500);
  }
}
