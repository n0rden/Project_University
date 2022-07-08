import models.Student;
import models.University;
import utils.ExcelReader;
import utils.JsonUtil;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "src\\main\\resources\\universityInfo.xlsx";

        //Создаем и заполняем коллекции Студентов и Университетов данными, распарсивая Excel таблицы
        List<Student> studentsList = ExcelReader.studentsReader(fileName);
        List<University> universitiesList = ExcelReader.universityReader(fileName);

        // Сериализуем коллекции Студентов и Университетов
        String studentsJson = JsonUtil.studentsListSerialization(studentsList);
        String universitiesJson = JsonUtil.universityListSerialization(universitiesList);

        // Десериализуем коллекции Студентов и Университетов
        List<Student> studentsDeserializedList = JsonUtil.studentsListDeserialization(studentsJson);
        List<University> universitiesDeserializedList = JsonUtil.universityListDeserialization(universitiesJson);

        // Проверяем корректность десериализации коллекций
        System.out.println(studentsList.size() == studentsDeserializedList.size()
                ? "Students list corrected deserialize"
                : "Students list uncorrected deserialize");
        System.out.println(universitiesList.size() == universitiesDeserializedList.size()
                ? "Universities list corrected deserialize"
                : "Universities list uncorrected deserialize");

        // Сериализуем четные элементы коллекций, выводим их на печать, десериализуем, выводим на печать
        studentsList.stream().filter(x -> studentsList.indexOf(x) % 2 == 0).forEach(student -> {
            String studentData = JsonUtil.studentSerialization(student);
            System.out.println(studentData);
            System.out.println(JsonUtil.studentDeserialization(studentData));
        });

        universitiesList.stream().filter(x -> universitiesList.indexOf(x) % 2 == 0).forEach(university -> {
            String universityData = JsonUtil.universitySerialization(university);
            System.out.println(universityData);
            System.out.println(JsonUtil.universityDeserialization(universityData));
        });
    }
}