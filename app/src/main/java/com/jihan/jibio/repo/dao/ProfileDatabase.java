package com.jihan.jibio.repo.dao;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.jihan.jibio.User;

@Database(entities = {User.class}, version = 1)
public abstract class ProfileDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
