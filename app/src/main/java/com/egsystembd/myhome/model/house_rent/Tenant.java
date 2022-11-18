package com.egsystembd.myhome.model.house_rent;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_tenant")

public class Tenant {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "phone")
    public String phone;

    @ColumnInfo(name = "nid")
    public String nid;

    @ColumnInfo(name = "devision")
    public String devision;

    @ColumnInfo(name = "district_id")
    public int district_id;

    @ColumnInfo(name = "thana_id")
    public int thana_id;

    @ColumnInfo(name = "post_office")
    public String post_office;

    @ColumnInfo(name = "area")
    public String area;

    @ColumnInfo(name = "update_date")
    public String update_date;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    public byte[] profile_image_byte;

    public byte[] getProfile_image_byte() {
        return profile_image_byte;
    }

    public void setProfile_image_byte(byte[] profile_image_byte) {
        this.profile_image_byte = profile_image_byte;
    }

}
