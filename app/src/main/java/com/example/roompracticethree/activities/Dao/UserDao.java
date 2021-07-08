package com.example.roompracticethree.activities.Dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roompracticethree.activities.entities.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    @Insert
    void insertUser(User...user);

    @Delete
    void deleteUser(User...user);
}
