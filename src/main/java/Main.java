import jakarta.xml.bind.JAXBException;

import models.Statistics;
import models.Student;
import models.University;
import models.XmlStructure;
import utils.*;

import java.io.IOException;
import java.util.logging.*;
import java.util.List;

public class Main {

    static {
        // загрузка logging.properties из classpath
        String path = Main.class.getClassLoader().getResource("logging.properties").getFile();
        System.setProperty("java.util.logging.config.file", path);
    }

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws JAXBException, IOException {
        logger.info("Start program");

        String sourceXlsFile = "src\\main\\resources\\universityInfo.xlsx";
        String outputXlsFile = "src\\main\\resources\\statistics.xlsx";
        String outputXmlPath = "src\\main\\xmlReqs";
        String outputJsonPath = "src\\main\\jsonReqs";

        // Создаем и заполняем коллекции Студентов и Университетов данными, распарсивая Excel таблицы
        List<Student> studentsList = ExcelReader.studentsReader(sourceXlsFile);
        List<University> universitiesList = ExcelReader.universityReader(sourceXlsFile);

        // Генерируем элементы статистики и записываем их в xlsx файл
        List<Statistics> statisticsList = GetStatistics.getStatistics(universitiesList, studentsList);
        XlsWriter.tableGenerateAndWrite(statisticsList, outputXlsFile);

        // Создаем объект XML структуры
        XmlStructure xmlObject = new XmlStructure(studentsList, universitiesList, statisticsList);
        // Генерируем XML файл из объекта XML структуры
        XmlWriter.saveObject(outputXmlPath, xmlObject);

        // Генерируем JSON файл
        String studentsJson = JsonUtil.universalSerializer(studentsList);
        JsonWriter.saveObject(outputJsonPath, studentsJson);

        String universityJson = JsonUtil.universalSerializer(universitiesList);
        JsonWriter.saveObject(outputJsonPath, universityJson);

        logger.info("Close program");
    }
}