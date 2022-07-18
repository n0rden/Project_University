import models.Statistics;
import models.Student;
import models.University;
import utils.ExcelReader;
import utils.GetStatistics;
import utils.XlsWriter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "src\\main\\resources\\universityInfo.xlsx";
        String fileNameToSave = "src\\main\\resources\\statistics.xlsx";

        // Создаем и заполняем коллекции Студентов и Университетов данными, распарсивая Excel таблицы
        List<Student> studentsList = ExcelReader.studentsReader(fileName);
        List<University> universitiesList = ExcelReader.universityReader(fileName);

        // Генерируем элементы статистики и записываем их в xlsx файл
        List<Statistics> statistics = GetStatistics.getStatistics(universitiesList, studentsList);
        XlsWriter.tableGenerateAndWrite(statistics, fileNameToSave);
    }
}