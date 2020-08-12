package com.softarea.learningapp.utils;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

public class ValidationUtils {
  public static boolean validateMinLength(Context context, TextView view, int requiredLength, int resId) {
    if(view.getText().toString().length() < requiredLength) {
      Toast.makeText(context, resId, Toast.LENGTH_LONG).show();
      return false;
    }
    return true;
  }
}
