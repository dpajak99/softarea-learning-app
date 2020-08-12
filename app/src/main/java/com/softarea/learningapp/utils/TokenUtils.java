package com.softarea.learningapp.utils;

import android.util.Log;

import com.softarea.learningapp.model.EncodedToken;

import java.util.Calendar;

public class TokenUtils {
  private static final String TAG = "TEST";

  public static EncodedToken encodeToken(String token) {
    Log.i(TAG, "encodeToken: " + token);
    EncodedToken encodedToken = new EncodedToken();
    Log.i(TAG, "encodeToken: " + encodedToken.toString());
    String result = "";
    for (int i = 0; i < token.length(); i++) {
      // Log.i(TAG, "encodeToken: charAt(i) " + token.charAt(i));
      if (i < 2) {
        result += token.charAt(i);

      } else if (i < 4) {
        if (i == 2) {
          Log.i(TAG, "encodeToken: result " + result);
          encodedToken.setDay(Integer.parseInt(result));
          result = "";
        }
        result += token.charAt(i);
      } else if (i < 8) {
        if (i == 4) {
          Log.i(TAG, "encodeToken: result " + result);
          encodedToken.setMonth(Integer.parseInt(result));
          result = "";
        }
        result += token.charAt(i);
      } else {
        if (i == 8) {
          Log.i(TAG, "encodeToken: result " + result);
          encodedToken.setYear(Integer.parseInt(result));
          result = "";
        }
        result += token.charAt(i);
        if (i == token.length() - 1) {
          Log.i(TAG, "encodeToken: result " + result);
          encodedToken.setId(Integer.parseInt(result));
          result = "";
        }
      }
    }

    return encodedToken;
  }

  public static boolean validateToken(String token) {
    EncodedToken encodedToken = encodeToken(token);
    Log.i(TAG, "encodedToken");
    Calendar currentDate = Calendar.getInstance();
    if (encodedToken.getYear() < currentDate.get(Calendar.YEAR)) {
      return false;
    }

    if (encodedToken.getMonth() < currentDate.get(Calendar.MONTH)) {
      return false;
    }

    if (encodedToken.getDay() < currentDate.get(Calendar.DAY_OF_MONTH) - 1) {
      return false;
    }

    return true;
  }

  public static String createToken(int id) {
    String token = "";
    Calendar creationDate = Calendar.getInstance();
    String day;
    String month;

    if (creationDate.get(Calendar.DAY_OF_MONTH) < 10) {
      day = StringUtils.join(0, creationDate.get(Calendar.DAY_OF_MONTH));
    } else {
      day = String.valueOf(creationDate.get(Calendar.DAY_OF_MONTH));
    }

    if (creationDate.get(Calendar.MONTH) < 10) {
      month = StringUtils.join(0, creationDate.get(Calendar.MONTH));
    } else {
      month = String.valueOf(creationDate.get(Calendar.MONTH));
    }

    token = StringUtils.join(
      day,
      month,
      String.valueOf(creationDate.get(Calendar.YEAR)),
      String.valueOf(id));

    Log.i(TAG, "createToken: " + token);
    return token;
  }
}
