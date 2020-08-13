package com.softarea.learningapp.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.softarea.learningapp.model.Token;

@Dao
public interface TokenDAO {
  @Query("SELECT Count(*) FROM TOKEN")
  int checkTokenExist();

  @Query("SELECT * FROM TOKEN")
  Token getLocalToken();

  @Query("UPDATE TOKEN SET token = :token WHERE id = 0")
  void updateLocalToken(String token);

  @Insert
  void createLocalToken(Token token);

  @Query("DELETE FROM TOKEN WHERE id = 0")
  void deleteLocalToken();
}
