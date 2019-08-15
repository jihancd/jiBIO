package com.jihan.jibio.repo;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

import android.arch.persistence.room.Room;
import android.content.Context;
import android.database.sqlite.SQLiteException;


import com.jihan.jibio.Biodata;
import com.jihan.jibio.User;
import com.jihan.jibio.repo.dao.ProfileDatabase;

import java.util.ArrayList;
import java.util.List;


public class Repository {

    private String DB_NAME = "db_jibio";
    private ProfileDatabase database;
    private Context context;

    public Repository(Context context) {
        this.context = context;
        database = Room.databaseBuilder(context, ProfileDatabase.class, DB_NAME)
                .allowMainThreadQueries()
                .build();
    }

    private static Repository INSTANCE = null;

    public static Repository getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = new Repository(context);
        }

        return INSTANCE;

    }

    public User getUser(String username, String password){
        return database.userDao().getUser(username,password);
    }

    public List<User> getUsers() {
        return database.userDao().getUsers();
    }

    public boolean createUser(User user) {
        return database.userDao().createUser(user) >= 0;
    }

    public boolean deleteUser(User user) {
        boolean status = true;
        try {
            database.userDao().delete(user);
        } catch (SQLiteException e){
            e.printStackTrace();
            status = false;
        }

        return status;
    }


    static String[] biodataData = new String[]{
            "",
            "10116356",
            "Jihan Candri Dinasty",
            "IF - 8",

    };

    static String[] kontakData = new String[]{
            "",
            "",
            "",
            "081395457825",
            "jhncandri@gmail.com",
            "jihandinasty",
            "Jihan Dinasty"

    };

    static String[][] temanData = new String[][]{
            {
                    "10116341",
                    "Sella Bintang",
                    "IF - 8",
                    "082217386767",
                    "sellabintang97@gmail.com",
                    "bintangprasatie_",
                    "Sella Bintang"
            }
    };

    public static ArrayList<Biodata> getBiodataData() {
        Biodata p = null;

        ArrayList<Biodata> list = new ArrayList<>();

        p = new Biodata();
        p.setPhoto(biodataData[0]);
        p.setNim(biodataData[1]);
        p.setName(biodataData[2]);
        p.setKelas(biodataData[3]);
        list.add(p);

        return list;
    }

    public static ArrayList<User> getKontakData() {
        User user = null;

        ArrayList<User> list = new ArrayList<>();

        user = new User();
        user.setPhone(kontakData[3]);
        user.setEmail(kontakData[4]);
        user.setInstagram(kontakData[6]);
        user.setFacebook(kontakData[7]);
        list.add(user);

        return list;
    }

    public static ArrayList<User> getTemanData() {
        User user = null;

        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < temanData.length; i++) {
            user = new User();
            user.setNim(temanData[i][0]);
            user.setUsername(temanData[i][1]);
            user.setKelas(temanData[i][2]);
            user.setPhone(temanData[i][3]);
            user.setEmail(temanData[i][4]);
            user.setInstagram(temanData[i][6]);
            user.setFacebook(temanData[i][7]);
            list.add(user);
        }
        return list;
    }


}
