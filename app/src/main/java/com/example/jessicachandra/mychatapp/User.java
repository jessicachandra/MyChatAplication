package com.example.jessicachandra.mychatapp;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Jessica Chandra on 07/01/2018.
 */

class User implements Parcelable {
    private String nama ;
    private String email;
    private String  telepon;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference userRef = database.getReference("users");

    public void register(){
        userRef.child(this.telepon).setValue(this);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelpon() {
        return telepon;
    }

    public void setTelpon(String telpon) {
        this.telepon = telpon;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    public User(){

    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.email);
        dest.writeString(this.telepon);
     }

    protected User(Parcel in) {
        this.nama = in.readString();
        this.email = in.readString();
        this.telepon = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
