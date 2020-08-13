package com.softarea.learningapp.dao;

import android.content.Context;

import com.softarea.learningapp.utils.DatabaseUtils;

public class LoginDAO {
  public static void logout(Context context) {
    DatabaseUtils.getDatabase(context).tokenDAO().deleteLocalToken();
  }
}
