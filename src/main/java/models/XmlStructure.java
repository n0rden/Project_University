// Структура итогового XML файла

package models;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "root") // имя "корня"
@XmlAccessorType(XmlAccessType.FIELD) // для парсинга используем поля
@XmlType(propOrder = {"students", "universities", "statistics", "currentDateTime"})
// порядок следования элементов в файле
public class XmlStructure {

    @XmlElementWrapper(name = "studentsInfo") // обертка над списком
    @XmlElement(name = "studentEntry") // наименование элемента в файле
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
