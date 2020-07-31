package com.softarea.learningapp;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

  Toolbar toolbar;
  NavController navController;
  BottomNavigationView bottomNavigationView;
  CollapsingToolbarLayout collapsingToolbarLayout;
  public static AppBarLayout appBarLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //BottomNavigationView navView = findViewById(R.id.nav_view);

    toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
    appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);





    AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
      R.id.navigation_home, R.id.navigation_panel_add, R.id.navigation_calendar, R.id.navigation_notifications, R.id.navigation_account)
      .build();
    navController = Navigation.findNavController(this, R.id.fragment_main);
    bottomNavigationView = findViewById(R.id.bottomNavigation);
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    NavigationUI.setupWithNavController(bottomNavigationView, navController);


    appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
      boolean isShow = true;
      int scrollRange = -1;

      @Override
      public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (scrollRange == -1) {
          scrollRange = appBarLayout.getTotalScrollRange();
        }
        if (scrollRange + verticalOffset == 0) {
          collapsingToolbarLayout.setTitle(navController.getCurrentDestination().getLabel());
          isShow = true;
        } else if (isShow) {
          collapsingToolbarLayout.setTitle(" ");//careful there should a space between double quote otherwise it wont work
          isShow = false;
        }
      }
    });

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.bottom_nav_menu, menu);
    return true;
  }

}
