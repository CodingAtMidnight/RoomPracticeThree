package com.example.roompracticethree.activities.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roompracticethree.activities.Dao.UserDao;
import com.example.roompracticethree.activities.entities.User;

@Database(entities = {User.class},version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
   public abstract UserDao userDao();

   private static UserDatabase INSTANCE;

   public  static UserDatabase getDbInstance(Context context) {
       if (INSTANCE == null) {
           INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                   UserDatabase.class,
                   "user_db")
                   .allowMainThreadQueries()
                   .build();
       }
           return INSTANCE;
   }

}
