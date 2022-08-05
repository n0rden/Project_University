package models;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.*;
import enums.StudyProfile;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "fullName", "mainProfile"})
public class University {

    @SerializedName("University ID")
    @XmlElement(name = "universityId")
    private String id;
    @SerializedName("University name")
    @XmlElement(name = "universityName")
    private String fullName;
    @SerializedName("University abbreviation")
    @XmlTransient
    private String shortName;
    @SerializedName("Foundation year")
    @XmlTransient
    private int yearOfFoundation;
    @SerializedName("Study profile")
    @XmlElement(name = "universityProfile")
    private StudyProfile mainProfile;

    public University(String toString, String s, String string, double numericCellValue) {
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }


    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    @Override
    public String toString() {
        return String.format("Id: %s full name: %s short name: %s year of foundation: %d main profile: %s",
                id, fullName, shortName, yearOfFoundation, mainProfile.getSpecialty());
    }
}