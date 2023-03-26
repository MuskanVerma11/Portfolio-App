package com.example.portfolioversion2o.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Course implements Parcelable {
    private String Course;
    private String Organization;
    private String Year1;

    public Course(String course, String organization, String year1) {
        Course = course;
        Organization = organization;
        Year1 = year1;
    }

    protected Course(Parcel in) {
        Course = in.readString();
        Organization = in.readString();
        Year1 = in.readString();
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String organization) {
        Organization = organization;
    }

    public String getYear1() {
        return Year1;
    }

    public void setYear1(String year1) {
        Year1 = year1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Course);
        parcel.writeString(Organization);
        parcel.writeString(Year1);
    }
}
