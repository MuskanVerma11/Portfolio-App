package com.example.portfolioversion2o.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Education implements Parcelable{
    private String CollegeName;
    private String Degree;
    private String Year;

    public Education(String collegeName, String degree, String year) {
        this.CollegeName = collegeName;
        this.Degree = degree;
        this.Year = year;
    }

    protected Education(Parcel in) {
        CollegeName = in.readString();
        Degree = in.readString();
        Year = in.readString();
    }

    public static final Creator<Education> CREATOR = new Creator<Education>() {
        @Override
        public Education createFromParcel(Parcel in) {
            return new Education(in);
        }

        @Override
        public Education[] newArray(int size) {
            return new Education[size];
        }
    };

    public String getCollegeName() {
        return CollegeName;
    }

    public void setCollegeName(String collegeName) {
        CollegeName = collegeName;
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String degree) {
        Degree = degree;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(CollegeName);
        parcel.writeString(Degree);
        parcel.writeString(Year);
    }
}
