package models;

import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("Full name")
    private String fullName;
    @SerializedName("University ID")
    private String universityId;
    @SerializedName("Course number")
    private int currentCourseNumber;
    @SerializedName("Average score")
    private float avgExamScore;

    public Student() {
    }
    public Student(String universityId, String fullName, int currentCourseNumber, float avgExamScore) {
        this.universityId = universityId;
        this.fullName = fullName;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    @Override
    public String toString() {
        return String.format("""
                        Full name: %s
                        university ID: %s
                        current course number: %d
                        avg exam score: %.1f
                        """, fullName, universityId, currentCourseNumber, avgExamScore);
    }
}