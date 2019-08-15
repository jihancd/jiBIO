package com.jihan.jibio.repo.dao;



import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.jihan.jibio.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getUsers();

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    User getUser(String username, String password);

    @Insert
    long createUser(User user);

    @Delete
    void delete(User user);

}
