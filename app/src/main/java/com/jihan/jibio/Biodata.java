package com.jihan.jibio;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

public class Biodata {
    String username;
    String password;
    String name;
    String nim;
    String photo;
    String kelas;

    public Biodata(){

    }

    public Biodata(String username, String password, String nama, String nim, String photo) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nim = nim;
        this.photo = photo;
        this.kelas = kelas;
    }

    public Biodata(String username, String password, String nim) {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getKelas() {
        return photo;
    }

    public void setKelas(String photo) {
        this.photo = photo;
    }
}
