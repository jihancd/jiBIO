package com.jihan.jibio;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;



@Entity
public class User implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nim")
    private String nim;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "kelas")
    private String kelas;

    @ColumnInfo(name = "telepon")
    private String phone;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "instagram")
    private String instagram;

    @ColumnInfo(name = "facebook")
    private String facebook;

    @ColumnInfo(name = "password")
    private String password;

    public User(){

    }

    public User(Parcel in) {
        nim = in.readString();
        username = in.readString();
        kelas = in.readString();
        phone = in.readString();
        email = in.readString();
        instagram = in.readString();
        facebook = in.readString();
        password = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nim);
        dest.writeString(username);
        dest.writeString(kelas);
        dest.writeString(phone);
        dest.writeString(email);
        dest.writeString(instagram);
        dest.writeString(facebook);
        dest.writeString(password);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String telepon) {
        this.phone = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Creator<User> getCREATOR() {
        return CREATOR;
    }
}