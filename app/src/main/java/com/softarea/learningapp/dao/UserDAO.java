package com.softarea.learningapp.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.softarea.learningapp.model.User;

@Dao
public interface UserDAO {
  @Query("SELECT * FROM USERS WHERE id = :authorId Limit 1")
  User getAuthor(int authorId);

  /*TODO: Delete it*/
  @Query("SELECT Count(*) FROM USERS WHERE id = :id")
  int getCount(int id);

  @Query("SELECT Count(*) FROM USERS WHERE email = :login AND password = :password ")
  int checkLoginData(String login, String password);

  @Query("SELECT * FROM USERS WHERE email = :login AND password = :password ")
  User getUser(String login, String password);

  @Query("SELECT * FROM USERS WHERE token = :token ")
  User getUser(String token);

  @Query("UPDATE USERS SET token = :token WHERE id = :id")
  void updateToken(String token, int id);

  @Insert
  void insert( User user );
}
