package com.linkuslive.roomdbtest.dbhelpers;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.linkuslive.roomdbtest.interfaces.db_interfaces.TaskDao;
import com.linkuslive.roomdbtest.models.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
