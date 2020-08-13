package com.softarea.learningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.softarea.learningapp.R;
import com.softarea.learningapp.sqlite.DBManager;
import com.softarea.learningapp.utils.AnimationUtils;
import com.softarea.learningapp.utils.BundleUtils;
import com.softarea.learningapp.utils.TokenUtils;

public class SplashScreenActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen);

    ImageView logoView = findViewById(R.id.logo);




    AnimationUtils.createPulsarLogo(logoView);

    DBManager dbManager = new DBManager(getApplicationContext());
    dbManager.setLocalToken("000");

    /****************************************/
    /*User user = new User(0, "Dominik Pająk", "SOFTAREA - Junior Android Developer", R.drawable.dpajak);
    dbManager.addUser(user, "dominik", "123");
    user = new User(0, "Łukasz Usarz", "SOFTAREA - SEO", R.drawable.lusarz);
    dbManager.addUser(user, "lusarz", "123");*/
    /****************************************/

    String token = dbManager.getLocalToken();

    Intent intent;
    if(TokenUtils.validateToken(token)) {
      intent = new Intent(getApplicationContext(), MainActivity.class);
      intent.putExtras(BundleUtils.createSerializableBundle("user", dbManager.getUser(token)));
    } else {
      intent = new Intent(getApplicationContext(), LoginActivity.class);
    }

    final Handler handler = new Handler();
    handler.postDelayed(() -> {
      startActivity(intent);
      finish();
    }, 500);
  }
}
