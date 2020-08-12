package com.softarea.learningapp.utils;

import android.os.Bundle;

import java.io.Serializable;

public class BundleUtils {
  public static Bundle createSerializableBundle(String name, Serializable value) {
    Bundle result = new Bundle();
    result.putSerializable(name, value);
    return result;
  }
}
