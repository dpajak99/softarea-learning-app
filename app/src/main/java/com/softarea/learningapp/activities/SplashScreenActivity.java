package com.softarea.learningapp.activities;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.EncodedToken;
import com.softarea.learningapp.model.User;
import com.softarea.learningapp.sqlite.DBManager;
import com.softarea.learningapp.utils.TokenUtils;

public class SplashScreenActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen);

    ImageView textView = findViewById(R.id.logo);

    /****************************************/
    /*User user = new User(0, "Dominik Pająk", "SOFTAREA - Junior Android Developer", R.drawable.dpajak);
    DBManager dbManager = new DBManager(getApplicationContext());
    dbManager.addUser(user, "dominik", "123");
    user = new User(0, "Łukasz Usarz", "SOFTAREA - SEO", R.drawable.lusarz);
    dbManager.addUser(user, "lusarz", "123");*/
    /****************************************/


    ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(
      textView,
      PropertyValuesHolder.ofFloat("scaleX", 1.03f),
      PropertyValuesHolder.ofFloat("scaleY", 1.03f));
    scaleDown.setDuration(500);

    scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
    scaleDown.setRepeatMode(ObjectAnimator.REVERSE);

    scaleDown.start();
    DBManager dbManager = new DBManager(getApplicationContext());

    dbManager.setLocalToken("000");

    String token = dbManager.getLocalToken();
    Log.i("TEST", "TOKEN " + token);
    EncodedToken encodedToken = TokenUtils.encodeToken(token);
    Log.i("TEST", encodedToken.toString());
    if(TokenUtils.validateToken(encodedToken)) {
      User user = dbManager.getUser(token);

      Intent intent = new Intent(getApplicationContext(), MainActivity.class);
      Bundle bundle = new Bundle();
      bundle.putSerializable("user", user);
      intent.putExtras(bundle);
      final Handler handler = new Handler();
      handler.postDelayed(() -> {
        startActivity(intent);
        finish();
      }, 500);
    } else {
      final Handler handler = new Handler();
      handler.postDelayed(() -> {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
      }, 500);
    }




  }
}
