import jakarta.xml.bind.JAXBException;

import models.Statistics;
import models.Student;
import models.University;
import models.XmlStructure;
import utils.*;

import java.io.File;
import java.util.logging.*;
import java.util.List;

public class Main {

    static {
        // загрузка logging.properties из classpath
        String path = Main.class.getClassLoader().getResource("logging.properties").getFile();
        System.setProperty("java.util.logging.config.file", path);
    }

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws JAXBException {
        logger.info("Start program");

        String sourceXlsFile = "src\\main\\resources\\universityInfo.xlsx";
        String outputXlsFile = "src\\main\\resources\\statistics.xlsx";
        String outputXmlFile = "src\\main\\xmlReqs";
        String outputJsonFile = "src\\main\\jsonReqs";

        // Создаем и заполняем коллекции Студентов и Университетов данными, распарсивая Excel таблицы
        List<Student> studentsList = ExcelReader.studentsReader(sourceXlsFile);
        List<University> universitiesList = ExcelReader.universityReader(sourceXlsFile);

        // Генерируем элементы статистики и записываем их в xlsx файл
        List<Statistics> statisticsList = GetStatistics.getStatistics(universitiesList, studentsList);
        XlsWriter.tableGenerateAndWrite(statisticsList, outputXlsFile);

        // Создаем объект XML структуры
        XmlStructure xmlObject = new XmlStructure(studentsList, universitiesList, statisticsList);

        // Генерируем XML файл из объекта XML структуры
        XmlWriter.saveObject(outputXmlFile, xmlObject);
        //GetStatisticsStream.getStatistics(universitiesList, studentsList);
    }
}