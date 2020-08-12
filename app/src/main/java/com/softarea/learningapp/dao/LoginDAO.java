package com.softarea.learningapp.dao;

import android.content.Context;

import com.softarea.learningapp.sqlite.DBManager;

public class LoginDAO {
  public static void logout(Context context) {
    DBManager dbManager = new DBManager(context);
    dbManager.updateLocalToken("000");
  }
}
