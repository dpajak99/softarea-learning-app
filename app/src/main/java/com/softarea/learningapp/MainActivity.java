package com.softarea.learningapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

  Toolbar toolbar;
  NavController navController;
  BottomNavigationView bottomNavigationView;
  CollapsingToolbarLayout collapsingToolbarLayout;
  public static NestedScrollView mNestedView;

  public static AppBarLayout appBarLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //BottomNavigationView navView = findViewById(R.id.nav_view);
    mNestedView = findViewById(R.id.nested);
    toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        MainActivity.this.onBackPressed();
      }
    });

    collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
    appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);


    setExpandAndCollapseEnabled(true);


    AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
      R.id.navigation_home, R.id.navigation_panel_add, R.id.navigation_calendar, R.id.navigation_notifications, R.id.navigation_account)
      .build();
    navController = Navigation.findNavController(this, R.id.fragment_main);
    bottomNavigationView = findViewById(R.id.bottomNavigation);


    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    NavigationUI.setupWithNavController(bottomNavigationView, navController);

    LinearLayout[] createNote = { findViewById(R.id.shortcut_card1), findViewById(R.id.shortcut_card2), findViewById(R.id.shortcut_card3) };
    createNote[0].setOnClickListener(v -> navController.navigate(R.id.navigation_create_note));
    createNote[1].setOnClickListener(v -> navController.navigate(R.id.navigation_notes));


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

  public static void setExpandAndCollapseEnabled(boolean enabled) {
    NestedScrollView mNestedView = MainActivity.mNestedView;
    if (mNestedView.isNestedScrollingEnabled() != enabled) {
      mNestedView.setNestedScrollingEnabled(enabled);
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_appar, menu);
    return true;
  }

  @Override
  public void onBackPressed(){
    if (getSupportFragmentManager().getBackStackEntryCount() == 1){
      finish();
    }
    else {
      super.onBackPressed();
    }
  }


}
