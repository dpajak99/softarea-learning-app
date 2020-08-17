package com.softarea.learningapp.consts;

import android.content.Context;
import android.widget.Toast;

public class AlertConst {
  public static final int SESSION_EXPIRED = 0;
  public static final int MORE_THAN_ONE_TOKEN = 1;
  public static final int MORE_THAN_ONE_USER = 2;
  public static final int USER_NOT_FOUND = 3;

  public static void alert(Context context, int id) {
    String alertContent = null;
    switch( id ) {
      case SESSION_EXPIRED:
        alertContent = "Twoja sesja wygasła. Zaloguj się ponownie";
        break;
      case MORE_THAN_ONE_TOKEN:
        alertContent = "Wystąpił błąd, skontaktuj się z administratorem (token)";
        break;
      case MORE_THAN_ONE_USER:
        alertContent = "Wystąpił błąd, skontaktuj się z administratorem (user)";
        break;
      case USER_NOT_FOUND:
        alertContent = "Błędny login lub hasło";
        break;
    }
    Toast.makeText(context, alertContent, Toast.LENGTH_LONG).show();
  }
}
