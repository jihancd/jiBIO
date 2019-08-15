package com.jihan.jibio.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.jihan.jibio.User;


public class Preferences {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private static Preferences INSTANCE = null;

    public static Preferences getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Preferences(context);
        }
        return INSTANCE;
    }

    Preferences(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void saveLogin(User user) {
        editor.putString(NIM, user.getNim());
        editor.putString(USERNAME, user.getUsername());
        editor.putString(KELAS, user.getKelas());
        editor.putString(PHONE, user.getPhone());
        editor.putString(EMAIL, user.getEmail());
        editor.putString(INSTAGRAM, user.getInstagram());
        editor.putString(FACEBOOK, user.getFacebook());
        editor.putString(PASSWORD, user.getPassword());
        editor.apply();
    }

    public User getUserLogin() {
        User user = new User();
        user.setNim(sharedPreferences.getString(NIM, ""));
        user.setUsername(sharedPreferences.getString(USERNAME, ""));
        user.setKelas(sharedPreferences.getString(KELAS, ""));
        user.setPhone(sharedPreferences.getString(PHONE, ""));
        user.setEmail(sharedPreferences.getString(EMAIL, ""));
        user.setInstagram(sharedPreferences.getString(INSTAGRAM, ""));
        user.setFacebook(sharedPreferences.getString(FACEBOOK, ""));
        user.setPassword(sharedPreferences.getString(PASSWORD, ""));
        return user;
    }

    public void deleteLogin(){
        editor.clear();
        editor.apply();
    }


    static String NIM = "nim";
    static String USERNAME = "username";
    static String KELAS = "kelas";
    static String PHONE = "telepon";
    static String EMAIL = "email";
    static String INSTAGRAM = "instagram";
    static String FACEBOOK = "facebook";
    static String PASSWORD = "password";


}
