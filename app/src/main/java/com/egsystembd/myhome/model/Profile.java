package com.egsystembd.myhome.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_profile")
public class Profile {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;
//
//    @ColumnInfo(name = "designation")
//    public String designation;

//    @ColumnInfo(name = "profile_image")
//    public String profile_image;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    public byte[] profile_image_byte;

    @ColumnInfo(name = "update_date")
    public String update_date;


    public byte[] getProfile_image_byte() {
        return profile_image_byte;
    }

    public void setProfile_image_byte(byte[] profile_image_byte) {
        this.profile_image_byte = profile_image_byte;
    }


}
