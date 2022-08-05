package models;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"students","universities","statistics", "currentDateTime"})
public class XmlStructure {

    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    List<Student> students;
    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    List<University> universities;
    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    List<Statistics> statistics;

    @XmlElement(name = "processedAt")
    Long currentDateTime = 1451665447567L;

    public XmlStructure() {

    }

    public XmlStructure(List<Student> students, List<University> universities, List<Statistics> statistics) {
        this.students = students;
        this.universities = universities;
        this.statistics = statistics;
    }

    public List<Student> getStudents() {
        return students;
    }

    public XmlStructure setStudents(List<Student> students) {
        this.students = students;
        return this;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public XmlStructure setUniversities(List<University> universities) {
        this.universities = universities;
        return this;
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public XmlStructure setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
        return this;
    }

    public XmlStructure setCurrentDateTime(Long currentDateTime) {
        this.currentDateTime = currentDateTime;
        return this;
    }
}
