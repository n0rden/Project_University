// Структура итогового XML файла

package models;

import jakarta.xml.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

// имя "корня"
@XmlRootElement(name = "root")
// для парсинга используем поля
@XmlAccessorType(XmlAccessType.FIELD)
// порядок следования элементов в файле
@XmlType(propOrder = {"students", "universities", "statistics", "currentDateTime"})

public class XmlStructure {

    @XmlElementWrapper(name = "studentsInfo") // обертка над списком
    @XmlElement(name = "studentEntry") // наименование элемента в XML файле
    List<Student> students;
    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    List<University> universities;
    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    List<Statistics> statistics;

    @XmlElement(name = "processedAt")
    String currentDateTime;

    public XmlStructure() {

    }

    public XmlStructure(List<Student> students, List<University> universities, List<Statistics> statistics) {

        this.students = students;
        this.universities = universities;
        this.statistics = statistics;

        ZonedDateTime time = ZonedDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSxxxxx");
        String dataTimeStr = dtf.format(time);

        currentDateTime = dataTimeStr;
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
}