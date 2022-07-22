import models.Statistics;
import models.Student;
import models.University;
import utils.ExcelReader;
import utils.GetStatistics;
import utils.GetStatisticsStream;
import utils.XlsWriter;

import java.util.logging.*;
import java.util.List;

public class Main {

    static {
        // загрузка logging.properties из classpath
        String path = Main.class.getClassLoader().getResource("logging.properties").getFile();
        System.setProperty("java.util.logging.config.file", path);
    }

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Start program");
        String fileName = "src\\main\\resources\\universityInfo.xlsx";
        String fileNameToSave = "src\\main\\resources\\statistics.xlsx";

        // Создаем и заполняем коллекции Студентов и Университетов данными, распарсивая Excel таблицы
        List<Student> studentsList = ExcelReader.studentsReader(fileName);
        List<University> universitiesList = ExcelReader.universityReader(fileName);

        // Генерируем элементы статистики и записываем их в xlsx файл
        List<Statistics> statistics = GetStatistics.getStatistics(universitiesList, studentsList);
        XlsWriter.tableGenerateAndWrite(statistics, fileNameToSave);

        GetStatisticsStream.getStatistics(universitiesList, studentsList);
    }
}