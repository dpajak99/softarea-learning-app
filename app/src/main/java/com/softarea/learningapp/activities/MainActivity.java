package com.softarea.learningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

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
import com.softarea.learningapp.components.ImageViewRounded;
import com.softarea.learningapp.dao.LoginDAO;
import com.softarea.learningapp.dao.ToolbarShortcutDAO;
import com.softarea.learningapp.model.User;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    NestedScrollView mNestedView = findViewById(R.id.nested);
    Toolbar toolbar = findViewById(R.id.toolbar);
    AppBarLayout appBarLayout = findViewById(R.id.app_bar);


    setSupportActionBar(toolbar);
    toolbar.setNavigationOnClickListener(v -> MainActivity.this.onBackPressed());

    AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
      R.id.navigation_home, R.id.navigation_panel_add, R.id.navigation_calendar, R.id.navigation_notifications, R.id.navigation_account)
      .build();

    NavController navController = Navigation.findNavController(this, R.id.fragment_main);
    BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    NavigationUI.setupWithNavController(bottomNavigationView, navController);
    navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
      boolean isHome = destination.getId() == R.id.navigation_home;
      mNestedView.setNestedScrollingEnabled(isHome);
      appBarLayout.setExpanded(isHome, false);
      appBarLayout.setBackgroundResource(isHome ? R.color.below_toolbar : R.color.backgroundColor);
    });


    ImageViewRounded profileImage = findViewById(R.id.profile_image);
    TextView profileName = findViewById(R.id.profile_name);
    TextView profilePosition = findViewById(R.id.profile_position);

    User user = (User) getIntent().getExtras().getSerializable("user");
    profileImage.setImageResource(user.getImage());
    profileName.setText(user.getFullName());
    profilePosition.setText(user.getPosition());

    RecyclerView toolbarShortcutsList = findViewById(R.id.list_toolbar_shortcuts);
    ToolbarShortcutAdapter toolbarShortcutAdapter = new ToolbarShortcutAdapter(this, ToolbarShortcutDAO.getData(getApplicationContext()));
    toolbarShortcutsList.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));
    toolbarShortcutsList.setHasFixedSize(true);
    toolbarShortcutsList.setAdapter(toolbarShortcutAdapter);

    CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
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

  private void logout() {
    LoginDAO.logout(getApplicationContext());

    Intent intent = new Intent(MainActivity.this,
      LoginActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
      Intent.FLAG_ACTIVITY_CLEAR_TASK |
      Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_appar, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.navigation_panel_add:
        logout();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
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
