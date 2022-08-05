package models;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;
import jakarta.xml.bind.annotation.*;

import java.util.Optional;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"mainProfile", "avgExamScore"})
public class Statistics {

    @XmlElement (name = "universityProfile")
    StudyProfile mainProfile;
    @XmlElement(name = "avgScore")
    double avgExamScore;
    @XmlTransient
    int numberOfStudentsByProfile;
    @XmlTransient
    int numberOfUniversitiesByProfile;
    @XmlTransient
    String universityName;


    public Statistics setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    public Statistics setAvgExamScore(double avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public Statistics setNumberOfStudentsByProfile(int numberOfStudentsByProfile) {
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
        return this;
    }

    public Statistics setNumberOfUniversitiesByProfile(int numberOfUniversitiesByProfile) {
        this.numberOfUniversitiesByProfile = numberOfUniversitiesByProfile;
        return this;
    }

    public Statistics setUniversityName(String universityName) {
        this.universityName = universityName;
        return this;
    }

    public String getMainProfile() {
        return mainProfile.getSpecialty();
    }

    public Optional<Double> getAvgExamScore() {
        return Optional.ofNullable(avgExamScore);
    }

    public int getNumberOfStudentsByProfile() {
        return numberOfStudentsByProfile;
    }

    public int getNumberOfUniversitiesByProfile() {
        return numberOfUniversitiesByProfile;
    }

    public String getUniversityName() {
        return universityName;
    }
}
