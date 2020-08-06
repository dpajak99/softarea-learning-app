package com.softarea.learningapp.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.softarea.learningapp.R;
import com.softarea.learningapp.adapters.ToolbarShortcutAdapter;
import com.softarea.learningapp.dao.ToolbarShortcutDAO;

public class MainActivity extends AppCompatActivity {

  public static Toolbar toolbar;
  BottomNavigationView bottomNavigationView;
  CollapsingToolbarLayout collapsingToolbarLayout;
  RecyclerView toolbarShortcutsList;

  /*TODO: Repair memory leak warning!!!!!*/
  private static NestedScrollView mNestedView;
  public static NavController navController;
  /*-------------------------------------*/
  public static AppBarLayout appBarLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initViews();
    initStartSettings();


    ToolbarShortcutAdapter toolbarShortcutAdapter = new ToolbarShortcutAdapter(ToolbarShortcutDAO.getData());

    toolbarShortcutsList.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));
    toolbarShortcutsList.setHasFixedSize(true);
    toolbarShortcutsList.setAdapter(toolbarShortcutAdapter);


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
          collapsingToolbarLayout.setTitle(" ");
          isShow = false;
        }
      }
    });

  }

  public static void setExpandAndCollapseEnabled(boolean enabled) { ;
    NestedScrollView mNestedView = MainActivity.mNestedView;
    if (mNestedView.isNestedScrollingEnabled() != enabled) {
      mNestedView.setNestedScrollingEnabled(enabled);
    }
  }

  private void initViews() {
    mNestedView = findViewById(R.id.nested);
    toolbar = findViewById(R.id.toolbar);
    collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
    appBarLayout = findViewById(R.id.app_bar);
    bottomNavigationView = findViewById(R.id.bottomNavigation);
    toolbarShortcutsList = findViewById(R.id.list_toolbar_shortcuts);
  }

  private void initStartSettings() {
    setSupportActionBar(toolbar);
    toolbar.setNavigationOnClickListener(v -> MainActivity.this.onBackPressed());
    setExpandAndCollapseEnabled(true);

    AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
      R.id.navigation_home, R.id.navigation_panel_add, R.id.navigation_calendar, R.id.navigation_notifications, R.id.navigation_account)
      .build();
    navController = Navigation.findNavController(this, R.id.fragment_main);


    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    NavigationUI.setupWithNavController(bottomNavigationView, navController);
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
