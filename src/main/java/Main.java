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
        File file = new File("resultXML.xml");

        logger.info("Start program");

        String fileName = "src\\main\\resources\\universityInfo.xlsx";
        String fileNameToSave = "src\\main\\resources\\statistics.xlsx";

        // Создаем и заполняем коллекции Студентов и Университетов данными, распарсивая Excel таблицы
        List<Student> studentsList = ExcelReader.studentsReader(fileName);
        List<University> universitiesList = ExcelReader.universityReader(fileName);

        // Генерируем элементы статистики и записываем их в xlsx файл
        List<Statistics> statisticsList = GetStatistics.getStatistics(universitiesList, studentsList);
        XlsWriter.tableGenerateAndWrite(statisticsList, fileNameToSave);

        // Создаем объект XML структуры
        XmlStructure xmlObject = new XmlStructure(studentsList, universitiesList, statisticsList);

        // Генерируем XML файл из объекта XML структуры
        XmlWriter.saveObject(file, xmlObject);
        //GetStatisticsStream.getStatistics(universitiesList, studentsList);
    }
}