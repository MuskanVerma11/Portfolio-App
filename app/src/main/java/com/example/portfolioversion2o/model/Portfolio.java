package com.example.portfolioversion2o.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Portfolio implements Parcelable {
    private String Name;
    private String Position;
    private Education education;
    private Course course;
    private String gitHubUserName;

    public Portfolio(String name, String position, Education education, Course course, String gitHubUserName) {
        Name = name;
        Position = position;
        this.education = education;
        this.course = course;
        this.gitHubUserName = gitHubUserName;
    }

    protected Portfolio(Parcel in) {
        Name = in.readString();
        Position = in.readString();
        education = in.readParcelable(Education.class.getClassLoader());
        course = in.readParcelable(Course.class.getClassLoader());
        gitHubUserName = in.readString();
    }

    public static final Creator<Portfolio> CREATOR = new Creator<Portfolio>() {
        @Override
        public Portfolio createFromParcel(Parcel in) {
            return new Portfolio(in);
        }

        @Override
        public Portfolio[] newArray(int size) {
            return new Portfolio[size];
        }
    };

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getGitHubUserName() {
        return gitHubUserName;
    }

    public void setGitHubUserName(String gitHubUserName) {
        this.gitHubUserName = gitHubUserName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Name);
        parcel.writeString(Position);
        parcel.writeParcelable(education, i);
        parcel.writeParcelable(course, i);
        parcel.writeString(gitHubUserName);
    }
}
